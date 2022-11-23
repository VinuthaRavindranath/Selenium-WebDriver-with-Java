import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DemoSafari {
    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();
        driver.get("https://rahulshettyacademy.com/");

        String title = driver.getTitle();
        System.out.println(title);

        String url = driver.getCurrentUrl();
        System.out.println(url);

        driver.close();
    }
}
