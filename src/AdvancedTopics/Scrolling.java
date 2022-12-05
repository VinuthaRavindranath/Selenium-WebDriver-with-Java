package AdvancedTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Scrolling {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor)driver ;
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");

       List<WebElement> amountData =driver.findElements(By.cssSelector("#product > tbody > tr > td:nth-child(4)"));
       int totalAmount =0;
        for (int i = 0; i <amountData.size() ; i++) {
            totalAmount=totalAmount +Integer.parseInt (amountData.get(i).getText());
        }

        int totalAmountCollected=Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(totalAmount,totalAmountCollected);

    }
}
