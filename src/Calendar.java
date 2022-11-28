import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Calendar {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.cssSelector("input[id*=\"rbtnl_Trip_1\"]")).click();

        if ( driver.findElement(By.className("picker-second")).getAttribute("style").contains("1") ){
            Assert.assertTrue(true);
            driver.findElement(By.cssSelector("input[id*=\"view_date2\"]")).click();
        }
        else {
            Assert.assertTrue(false);
        }
    }
}
