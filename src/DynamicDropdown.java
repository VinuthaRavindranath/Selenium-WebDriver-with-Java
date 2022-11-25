import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.cssSelector("input[id*=\"originStation1_CTX\"]")).click();
        driver.findElement(By.cssSelector("a[value=\"BLR\"]")).click();
        driver.findElement(By.xpath("(//a[@value=\"GOI\"])[2]")).click();

    }
}
