package AdvancedTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class FramesDemo {
    public static void frameHandle(WebDriver driver){
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        WebElement draggableElement = driver.findElement(By.cssSelector("div#draggable"));
        WebElement droppableElement = driver.findElement(By.cssSelector("div#droppable"));
        Actions a = new Actions(driver);
        a.dragAndDrop(draggableElement,droppableElement).build().perform();

        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector(".view-source >a")).click();
    }
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        System.out.println(  driver.findElements(By.tagName("iframe")).size());

        frameHandle(driver);

        driver.close();
    }
}