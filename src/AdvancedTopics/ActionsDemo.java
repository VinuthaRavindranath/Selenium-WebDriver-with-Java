package AdvancedTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class ActionsDemo {


    //Mover hover action
    public static void mouseHoverAction(WebDriver driver, Actions a){
        List<WebElement> images=driver.findElements(By.cssSelector("div.figure>img"));
        int imageSize=images.size();
        for (int i = 0; i < imageSize; i++) {
            WebElement img =  driver.findElements(By.cssSelector("div.figure>img")).get(i);
            WebElement userText = driver.findElements(By.cssSelector("div.figcaption>h5")).get(i);
            WebElement viewProfileLink =   driver.findElements(By.cssSelector("div.figcaption>a")).get(i);

            driver.findElements(By.cssSelector("div.figure>img")).get(i);
            a.moveToElement(img).build().perform();
            System.out.println(userText.getText());
            viewProfileLink.click();
            driver.navigate().back();
        }
    }

    //Keyboard action
    public static void keyBoardAction(WebDriver driver, Actions a){
        driver.get("https://the-internet.herokuapp.com/key_presses?");
        WebElement searchBar = driver.findElement(By.cssSelector("#target"));
        a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("Hello").build().perform();
        a.moveToElement(searchBar).doubleClick().keyDown(Keys.BACK_SPACE).build().perform();
        a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("Hi").doubleClick().build().perform();
    }

    //mouse right click action
    public static void mouseRightClickAction(WebDriver driver, Actions a){
        WebElement searchBar = driver.findElement(By.cssSelector("#target"));
        a.moveToElement(searchBar).contextClick().build().perform();
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions a = new Actions(driver);
        mouseHoverAction(driver,a);
        keyBoardAction(driver,a);
        mouseRightClickAction(driver,a);

        driver.close();
    }
}
