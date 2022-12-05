package EndToEnd;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        //Limiting WebDriver scope
        WebElement footerLinks = driver.findElement(By.cssSelector("#gf-BIG > table > tbody > tr"));
        System.out.println(footerLinks.findElements(By.tagName("a")).size());

        WebElement firstRowFooter= footerLinks.findElement(By.cssSelector("td:nth-child(1) > ul"));
        int size = firstRowFooter.findElements(By.tagName("a")).size();
        System.out.println(size);

        for (int i = 1; i < size; i++) {
           String clickOnLinkInNewTab= Keys.chord(Keys.COMMAND, Keys.ENTER);
            firstRowFooter.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkInNewTab);
        }

        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        while (itr.hasNext()) {
            String childWindows = itr.next();
            if (!mainWindow.equalsIgnoreCase(childWindows)) {
                driver.switchTo().window(childWindows);
                System.out.println(driver.getTitle());
            }
        }
        driver.switchTo().window(mainWindow);
        System.out.println(driver.getTitle());
    }
}
