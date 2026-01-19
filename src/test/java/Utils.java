import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.Random;

public class Utils {
    public static void doScroll(WebDriver driver, int px) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + px + ")");
    }

    public static String generatePassword(int passwordLength) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$";
        char[] chars = letters.toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(chars.length);
            sb.append(chars[randomIndex]);
        }
        System.out.println(sb);
        return sb.toString();
    }
}