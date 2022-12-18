package FrameWorkTest;

import FrameWorkDemo.pageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;

public class OrderPlacement {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String productTitle = "ADIDAS ORIGINAL";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        ProductCatalog productCatalog = loginPage.login("vinuthatest27@gmail.com", "test@123");

        List<WebElement> productsList=productCatalog.getProductsList();
        productCatalog.addProductToCart(productTitle);
        CartPage cartPage =productCatalog.goToCartPage();

        Boolean match= cartPage.validateCartHasProduct(productTitle);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage =cartPage.clickOnCheckoutButton();

        checkoutPage.verifyCountrySelection("India");
        OrderConfirmationPage orderConfirmationPage =checkoutPage.clickOnSubmitButton();

        String text =orderConfirmationPage.validateOrderConfirmation();
        Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();
    }
}
