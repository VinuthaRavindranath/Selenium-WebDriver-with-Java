package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutJourney {

    @Test
    public void addAddress() {
        System.out.println("add Address test");
    }

    @BeforeClass
    @Test
    public void selectShippingMethod() {
        System.out.println("select Shipping Method test");
    }

    @AfterClass
    @Test
    public void orderConfirmationEmail() {
        System.out.println("order Confirmation Email Method test");
    }

    @Test
    public void makePayment() {
        System.out.println("make Payment Method test");
    }

    @Test
    public void verifyOrderConfirmationPage() {
        System.out.println("verify Order Confirmation Page Method test");
    }
}
