package FileUploadingAndWindowPopUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileDownload {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://chromedriver.storage.googleapis.com/index.html?path=109.0.5414.25/");
        driver.findElement(By.cssSelector("a[href*='mac64.zip']")).click();
        Thread.sleep(15000);
        driver.close();
    }
}
