package Miscellaneous;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class DeleteCookies {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().deleteCookieNamed("__gpi");

       Set<Cookie> cookies= driver.manage().getCookies();
        for (Cookie c:cookies) {
            System.out.println(c);
        }

        driver.manage().deleteAllCookies();
        Set<Cookie> cookiesAfterDeletion= driver.manage().getCookies();
        for (Cookie c:cookiesAfterDeletion) {
            System.out.println(c);
        }
    }
}
