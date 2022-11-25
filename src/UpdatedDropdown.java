import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.cssSelector("#divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.cssSelector("#hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
       Assert.assertEquals(driver.findElement(By.cssSelector("#divpaxinfo")).getText(),"5 Adult");
       driver.close();
    }
}
