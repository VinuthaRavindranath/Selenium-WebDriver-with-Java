package WebElementsAndBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String name="Vinutha";

        driver.findElement(By.cssSelector("input[id=\"name\"]")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(),"Hello Vinutha, share this practice page and share your knowledge");
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input[id=\"name\"]")).sendKeys(name);
        driver.findElement(By.id("confirmbtn")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(),"Hello Vinutha, Are you sure you want to confirm?");
        driver.switchTo().alert().dismiss();

        driver.close();
    }
}
