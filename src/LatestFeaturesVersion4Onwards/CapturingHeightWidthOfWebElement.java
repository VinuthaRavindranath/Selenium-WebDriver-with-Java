package LatestFeaturesVersion4Onwards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CapturingHeightWidthOfWebElement {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement img = driver.findElement(By.cssSelector("div.jumbotron"));
        int height=img.getRect().getDimension().getHeight();
        int width = img.getRect().getDimension().getWidth();
        System.out.println(height+ " "+ width);


    }
}
