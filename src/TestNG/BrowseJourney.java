package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrowseJourney {

    @Parameters({"URL"})
    @Test
    public void openBrowser(String url) {
        System.out.println("URL-->"+url);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void login() {
        System.out.println("Login test");
    }

    @Test(enabled = false)
    public void navigateToHomePage() {
        System.out.println("browse Products test");
    }

    @Test
    public void browseProducts() {
        System.out.println("browse Products test");
    }

    @Test(dependsOnMethods = {"openBrowser", "login", "browseProducts"})
    public void searchProducts() {
        System.out.println("search Products Products test");
    }

    @Test(timeOut = 4000)
    public void addProductsToCart() {
        System.out.println("add Products To Cart test");
    }
}
