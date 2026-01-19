import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TableScrapTest {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @DisplayName("Scrap the table data")
    @Test
    public void scrapTableData() throws IOException, InterruptedException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(d -> driver.findElement(By.tagName("h2")).isDisplayed());

        WebElement table = driver.findElement(By.xpath("//table[1]"));
        List<WebElement> allRows = table.findElements(By.tagName("tr"));

        FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/src/test/resources/table_data.txt");

        int i = 0;
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                i++;
                String cellText = cell.getText().trim();
                System.out.println("num[" + i + "] " + cellText);
                writer.write("num[" + i + "] " + cellText + "\n");
            }
        }
        writer.flush();
        writer.close();
    }

    @AfterAll
    public void teardown() {
        driver.quit();
    }
}