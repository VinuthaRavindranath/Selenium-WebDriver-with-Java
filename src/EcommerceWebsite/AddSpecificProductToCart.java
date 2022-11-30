package EcommerceWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AddSpecificProductToCart {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
        int productsSize= products.size();
        for (int i = 0; i <productsSize ; i++) {
            String name = products.get(i).getText();
           if (name.contains("Cucumber")){
               driver.findElements(By.xpath("//button[text()=\"ADD TO CART\"]")).get(i).click();
               break;
           }
        }

        driver.close();

    }
}
