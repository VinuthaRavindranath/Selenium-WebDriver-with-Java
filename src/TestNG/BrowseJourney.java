package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BrowseJourney {

   @BeforeSuite
    @Parameters({"URL"})
    @Test
    public void openBrowser(String url) {
        System.out.println("openBrowser test");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        System.out.println(url);
        driver.get(url);
    }


//    @BeforeTest
    @Test(dataProvider = "getData")
    public void login(String userName, String password) {
        System.out.println("Login test");
        System.out.println(userName+ " & "+ password);
    }

    @AfterTest
    @Test(timeOut = 4000)
    public void logout() {
        System.out.println("logout test");
       // Assert.assertTrue(false); to fail the code intentionally to check if onTestFailure() is working
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

    @DataProvider
    public Object[][] getData() {
        //1st combiantion - username password - good credit history= row
        //2nd - username password  - no crdit history
        // 3rd - fraudelent credit history
        Object[][] data = new Object[3][2];
        //1st set
        data[0][0] = "firstsetusername";
        data[0][1] = "firstpassword";
        //couloumns in the row are nothing but values for that particualar combination(row)

        //2nd set
        data[1][0] = "secondsetusername";
        data[1][1] = "secondpassword";

        //3rd set
        data[2][0] = "thirdsetusername";
        data[2][1] = "thirdpassword";
        return data;


    }




}
