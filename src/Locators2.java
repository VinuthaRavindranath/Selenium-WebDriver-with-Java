import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys("Vinutha");
        driver.findElement(By.cssSelector("input[name*=inputPass]")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("input#chkboxOne")).click();
        driver.findElement(By.cssSelector("input#chkboxTwo")).click();
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("div.login-container >h2")).getText());
        System.out.println(driver.findElement(By.cssSelector("div.login-container >h1")).getText());
        System.out.println(driver.findElement(By.cssSelector("div.login-container >p")).getText());
        driver.close();
    }
}
