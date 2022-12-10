package LatestFeaturesVersion4Onwards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class InvokingMultipleWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        String parentWindow = driver.getWindowHandle();
        //driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> windows =driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        String firstCourse;
        while (itr.hasNext()){
            String ChildWindow = itr.next();
            if (!parentWindow.equals(ChildWindow)){
                driver.switchTo().window(ChildWindow);
                driver.get("https://www.rahulshettyacademy.com/");
            }
        }
        firstCourse= driver.findElement(By.cssSelector(" div.upper-box > h2 > a")).getText();

        driver.switchTo().window(parentWindow);
        driver.findElement(By.cssSelector("div >input[name='name']")).sendKeys(firstCourse);
    }
}
