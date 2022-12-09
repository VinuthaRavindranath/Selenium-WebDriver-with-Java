package EcommerceWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Search {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.cssSelector("div >input#search-field")).sendKeys("Rice");

        List<WebElement> searchResult = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> result = searchResult.stream().filter(s -> s.getText().contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(searchResult.size(), result.size());
    }
}
