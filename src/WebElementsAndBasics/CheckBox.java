package WebElementsAndBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CheckBox {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.cssSelector("input[id*=\"friendsandfamily\"]")).click();
        Assert.assertEquals(  driver.findElement(By.cssSelector("input[id*=\"friendsandfamily\"]")).isSelected(),true);

        System.out.println(  driver.findElements(By.cssSelector("input[type=\"checkbox\"]")).size());


        driver.close();
    }
}
