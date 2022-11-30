package EcommerceWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AddMultipleProductsToCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String ListOfProducts[]={"Cucumber","Brocolli","Beetroot"};
        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));

        int productsSize=products.size();


        for (int i = 0; i < productsSize; i++) {
            String productNames[]=products.get(i).getText().split("-");
            String productTitles=productNames[0].trim();
            List productsList = Arrays.asList(ListOfProducts);
            int j=0;
                if (productsList.contains(productTitles)){
                    j++;
                    driver.findElements(By.xpath("//button[text()=\"ADD TO CART\"]")).get(i).click();
                    if (j==ListOfProducts.length){
                        break;
                    }
                }

        }

    }
}
