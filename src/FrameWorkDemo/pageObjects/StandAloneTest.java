package FrameWorkDemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/client/");
        LoginPage lp = new LoginPage(driver);
        driver.findElement(By.id("userEmail")).sendKeys("vinuthatest27@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("test@123");
        driver.findElement(By.id("login")).click();

        String productTitle = "ADIDAS ORIGINAL";

        //Explicit wait
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        WebElement prod = products.stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().equals(productTitle)).findFirst().orElse(null);
        prod.findElement(By.cssSelector("button.btn.w-10.rounded")).click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        explicitWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

        List<WebElement> productsInCart = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match = productsInCart.stream().anyMatch(prodTitle -> prodTitle.getText().equals(productTitle));
        Assert.assertTrue(match);

        driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        List<WebElement> dropDownOptions = driver.findElements(By.cssSelector("button> span"));
       // dropDownOptions.stream().takeWhile(options-> options.getText().equals("India")).forEach(options ->options.click());
        for (WebElement options : dropDownOptions) {
            if (options.getText().equalsIgnoreCase("India")) {
                options.click();
                break;
            }
        }
        driver.findElement(By.cssSelector(".action__submit")).click();

        String orderConfirmationText=driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(orderConfirmationText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }
}