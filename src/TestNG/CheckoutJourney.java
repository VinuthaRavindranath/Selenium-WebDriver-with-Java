package TestNG;

import org.testng.annotations.Test;

public class CheckoutJourney {

    @Test
    public void addAddress() {
        System.out.println("add Address test");
    }

    @Test
    public void selectShippingMethod() {
        System.out.println("select Shipping Method test");
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
