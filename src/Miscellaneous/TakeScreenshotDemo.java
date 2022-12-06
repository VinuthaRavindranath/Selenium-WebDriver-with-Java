package Miscellaneous;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshotDemo {
    public static void main(String[] args) throws IOException {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destinationFile= new File("/Users/vinuthar/eclipse-workspace/Selenium-WebDriver-with-Java/src/Miscellaneous/Screenshots/screenshot"+ System.currentTimeMillis() + ".png");
        FileHandler.copy(scrFile, destinationFile);

        driver.close();
    }
}
