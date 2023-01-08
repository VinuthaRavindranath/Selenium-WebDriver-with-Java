package FileUploadingAndWindowPopUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class FileUpload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        WebElement uploadEle=driver.findElement(By.cssSelector("input[type*='file']"));
        uploadEle.sendKeys(System.getProperty("user.dir")+"/src/FileUploadingAndWindowPopUp/youTubePause.png");
        driver.findElement(By.cssSelector("button[type*='submit']")).click();
        WebElement deleteButton =driver.findElement(By.cssSelector("button[data-type*='DELETE']"));
        assertTrue(deleteButton.isDisplayed());
        deleteButton.click();
        driver.close();
    }
}
