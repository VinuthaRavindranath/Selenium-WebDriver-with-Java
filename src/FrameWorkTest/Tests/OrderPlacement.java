package FrameWorkTest.Tests;

import FrameWorkDemo.pageObjects.*;
import FrameWorkTest.TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class OrderPlacement extends BaseTest {


    @Test(dataProvider = "getData")
    public void OrderPlacement(HashMap<String,String> input) throws IOException, InterruptedException {
        ProductCatalog productCatalog = loginPage.login(input.get("email"), input.get("password"));

        List<WebElement> productsList = productCatalog.getProductsList();
        productCatalog.addProductToCart(input.get("productTitle"));
        CartPage cartPage = productCatalog.goToCartPage();

        Boolean match = cartPage.validateCartHasProduct(input.get("productTitle"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.clickOnCheckoutButton();

        checkoutPage.verifyCountrySelection("India");
        OrderConfirmationPage orderConfirmationPage = checkoutPage.clickOnSubmitButton();

        String text = orderConfirmationPage.validateOrderConfirmation();
        Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods ="OrderPlacement" , dataProvider = "getData")
    public void OrdersPageValidation(HashMap<String,String> input){
        ProductCatalog productCatalog = loginPage.login(input.get("email"), input.get("password"));
        MyOrdersPage ordersPage=productCatalog.goToMyOrdersPage();
        boolean match = ordersPage.validateMyOrdersPage(input.get("productTitle"));
        Assert.assertTrue(match);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data =getJsonDataToMap(System.getProperty("user.dir")+"/src/FrameWorkData/OrderPlacement.json");
        return new Object[][] {{data.get(0)},{data.get(1)}};
    }

}
