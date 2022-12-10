package LatestFeaturesVersion4Onwards;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PartialScreenshot {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement img = driver.findElement(By.cssSelector("div.jumbotron"));
        File sourceFile =img.getScreenshotAs(OutputType.FILE);
        File destinationFile= new File("/Users/vinuthar/eclipse-workspace/Selenium-WebDriver-with-Java/src/Miscellaneous/Screenshots/screenshot"+ System.currentTimeMillis() + ".png");
        FileHandler.copy(sourceFile, destinationFile);

    }
}
