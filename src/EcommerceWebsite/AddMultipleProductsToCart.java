package EcommerceWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AddMultipleProductsToCart {

    public static void openBrowser( WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    public static void addItemsToCart(WebDriver driver, String[] ListOfProducts){
        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));

        int productsSize=products.size();


        for (int i = 0; i < productsSize; i++) {
            String productNames[]=products.get(i).getText().split("-");
            String productTitles=productNames[0].trim();
            List productsList = Arrays.asList(ListOfProducts);
            int j=0;
            if (productsList.contains(productTitles)){
                j++;
                driver.findElements(By.cssSelector("div.product-action > button")).get(i).click();
                if (j==ListOfProducts.length){
                    break;
                }
            }

        }
    }

    public static void checkout(WebDriver driver) throws InterruptedException {
        driver.findElement(By.cssSelector("img[alt=\"Cart\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]")).click();

        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
        Assert.assertEquals(driver.findElement(By.className("promoInfo")).getText(),"Code applied ..!");
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver);
        String ListOfProducts[]={"Cucumber","Water Melon","Beetroot","Walnuts"};
        addItemsToCart(driver, ListOfProducts);
        checkout(driver);


    }
}
