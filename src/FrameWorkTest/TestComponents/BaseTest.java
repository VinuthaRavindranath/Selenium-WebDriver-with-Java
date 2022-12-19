package FrameWorkTest.TestComponents;

import FrameWorkDemo.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    private WebDriver driver ;
    public   LoginPage loginPage;
    public WebDriver launchBrowser() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/FrameWorkResources/GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;

            default:
                System.out.println("plz pass the right browser.....");
        }
        return driver;
    }

    @BeforeMethod
    public LoginPage launchApplication() throws IOException {
        driver=launchBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        loginPage.goTo();
        return loginPage;
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
            System.out.println("browser is closed.....");
        }
    }
}
