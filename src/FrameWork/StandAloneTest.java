package FrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/client/");
        driver.findElement(By.id("userEmail")).sendKeys("vinuthatest27@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("test@123");
        driver.findElement(By.id("login")).click();

        //Explicit wait
        WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        WebElement prod = products.stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
        prod.findElement(By.cssSelector("button.btn.w-10.rounded")).click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        explicitWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
    }
}
