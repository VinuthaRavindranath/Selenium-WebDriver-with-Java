package WebElementsAndBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestiveDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.xpath("//input[@id='autosuggest']")).click();
        driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("In");

        List<WebElement> dropdownOptions=driver.findElements(By.cssSelector("a[class='ui-corner-all']"));
        for (WebElement options:dropdownOptions) {
            if (options.getText().equalsIgnoreCase("India")){
            options.click();
            break;
            }
        }
        driver.close();
    }
}
