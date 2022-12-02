package WebElementsAndBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;

public class SeleniumWaitsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Explicit wait
        WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#start>button")));
        driver.findElement(By.cssSelector("div#start>button")).click();

        //Fluent wait
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
        WebElement foo= fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                if(driver.findElement(By.cssSelector("div#finish > h4")).isDisplayed()){
                    return driver.findElement(By.cssSelector("div#finish > h4"));
                }
              else{
                  return null;
                }

            }
        });
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish > h4")).getText(),"Hello World!");
    }
}
