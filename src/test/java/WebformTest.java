import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebformTest {

    WebDriver driver;
    Faker faker = new Faker();

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @DisplayName("WebformAutomation")
    @Test
    public void webformAutomation() throws InterruptedException {

        driver.get("https://www.digitalunite.com/practice-webform-learners");

        // Assert initial page title
        String actualTitle = driver.getTitle();
        Assertions.assertEquals("Practice webform for learners | Digital Unite", actualTitle);

        System.out.println("Page loaded. Title: " + actualTitle);

        // Accept cookie banner (try both common IDs)
        try {
            driver.findElement(By.id("ccc-notify-accept")).click();
            System.out.println("Cookie banner accepted (ccc-notify)");
            Thread.sleep(2000);
        } catch (Exception e) {
            try {
                driver.findElement(By.id("onetrust-accept-btn-handler")).click();
                System.out.println("Cookie banner accepted (onetrust)");
                Thread.sleep(2000);
            } catch (Exception ignored) {
                System.out.println("No cookie banner found or already accepted");
            }
        }

        // Fill name
        driver.findElement(By.id("edit-name")).sendKeys(faker.name().fullName());

        // Fill number (phone)
        driver.findElement(By.id("edit-number")).sendKeys("01994050014");

        // Fill date (mm/dd/yyyy format)
        driver.findElement(By.id("edit-date")).sendKeys("12122000");

        // Fill email
        driver.findElement(By.id("edit-email")).sendKeys(faker.internet().emailAddress());

        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 800);");
        Thread.sleep(1000);

        // Fill message
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-"))
                .sendKeys("Automated test by Mehbuba - learning Selenium & JUnit");

        // Scroll more for upload/checkbox
        js.executeScript("window.scrollTo(0, 1400);");
        Thread.sleep(1000);

        // Upload file (place images.jpg in src/test/resources/)
        String filePath = System.getProperty("user.dir") + "/src/test/resources/images.jpg";
        System.out.println("Uploading file from: " + filePath);
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(filePath);
        Thread.sleep(3000);

        // Check consent checkbox
        WebElement consentBox = driver.findElement(By.id("edit-age"));
        if (!consentBox.isSelected()) {
            js.executeScript("arguments[0].click();", consentBox);
            System.out.println("Consent checkbox checked");
        }

        // Scroll to bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1000);

        // Manual CAPTCHA wait
        System.out.println("Waiting 10 seconds for manual CAPTCHA solve... Please click 'I'm not a robot'");
        Thread.sleep(20000);

        // Submit with JS click (fixes interception)
        WebElement submitBtn = driver.findElement(By.id("edit-submit"));
        js.executeScript("arguments[0].click();", submitBtn);
        System.out.println("Submit button clicked");

        // Wait for confirmation page
        Thread.sleep(8000);

        // Assert success by URL and page source
        String currentUrl = driver.getCurrentUrl();
        String pageSource = driver.getPageSource();

        Assertions.assertTrue(
                currentUrl.contains("/confirmation") ||  // Your success URL pattern
                        currentUrl.contains("thank-you") ||
                        currentUrl.contains("submitted") ||
                        pageSource.contains("Thank you for your submission!") ||
                        pageSource.contains("Thank you") ||
                        pageSource.contains("success") ||
                        pageSource.contains("enquiry"),
                "Form submission failed - did not reach confirmation page. Current URL: " + currentUrl
        );

        System.out.println("Success! Reached confirmation page: " + currentUrl);
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}