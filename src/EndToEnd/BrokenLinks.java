package EndToEnd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> footerLinks=driver.findElements(By.cssSelector("tbody > tr > td > ul > li > a"));
        SoftAssert sa = new SoftAssert();

        for (int i = 0; i < footerLinks.size(); i++) {
            String url=footerLinks.get(i).getAttribute("href");
            HttpURLConnection connect = (HttpURLConnection)new URL(url).openConnection();
            connect.setRequestMethod("HEAD");
            connect.connect();
            int responseCode =connect.getResponseCode();
            Assert.assertTrue(responseCode<400,"Broken link URL text is:"+ footerLinks.get(i).getText()+ " with response code:"+ responseCode);
        }
        sa.assertAll();
    }
}
