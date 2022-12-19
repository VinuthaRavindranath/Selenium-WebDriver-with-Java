package FrameWorkTest.Tests;

import FrameWorkDemo.pageObjects.*;
import FrameWorkTest.TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;


public class OrderPlacement extends BaseTest {

    String productTitle = "ADIDAS ORIGINAL";
    @Test
    public void OrderPlacement() throws IOException {
        ProductCatalog productCatalog = loginPage.login("vinuthatest27@gmail.com", "test@123");

        List<WebElement> productsList = productCatalog.getProductsList();
        productCatalog.addProductToCart(productTitle);
        CartPage cartPage = productCatalog.goToCartPage();

        Boolean match = cartPage.validateCartHasProduct(productTitle);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.clickOnCheckoutButton();

        checkoutPage.verifyCountrySelection("India");
        OrderConfirmationPage orderConfirmationPage = checkoutPage.clickOnSubmitButton();

        String text = orderConfirmationPage.validateOrderConfirmation();
        Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods ="OrderPlacement" )
    public void OrdersPageValidation(){
        ProductCatalog productCatalog = loginPage.login("vinuthatest27@gmail.com", "test@123");
        MyOrdersPage ordersPage=productCatalog.goToMyOrdersPage();
        boolean match = ordersPage.validateMyOrdersPage(productTitle);
        Assert.assertTrue(match);
    }

}
