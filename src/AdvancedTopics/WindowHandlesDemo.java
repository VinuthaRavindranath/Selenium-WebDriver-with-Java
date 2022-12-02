package AdvancedTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandlesDemo {

    public static void multipleWindowsHandel(WebDriver driver){
        String mainWindow= driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@href=\"https://rahulshettyacademy.com/documents-request\"]")).click();

        Set<String> windows=driver.getWindowHandles();
        Iterator<String> itr= windows.iterator();
        while(itr.hasNext()){
            String childWindow=itr.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                String emailId= driver.findElement(By.cssSelector("a[href*=\"mailto\"]")).getText();
                driver.switchTo().window(mainWindow);
                driver.findElement(By.cssSelector("#username")).sendKeys(emailId);
            }
        }

    }
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        multipleWindowsHandel(driver);
        driver.close();




    }
}
