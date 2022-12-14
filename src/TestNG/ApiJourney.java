package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ApiJourney {

    @Parameters("API Key")
    @Test
    public void postLoginAPI(String key) {
        System.out.println("post login API test");
        System.out.println(key);
    }

    @Parameters({"API Key","URL","Content-Type"})
    @Test
    public void getLoginAPI(String key, String url, String contentType) {
        System.out.println("get login API test");
        System.out.println(key);
        System.out.println(url);
        System.out.println(contentType);
    }

    @Test
    public void putLoginAPI() {
        System.out.println("put login API test");
    }

    @Test
    public void deleteLoginAPI() {
        System.out.println("delete login API test");
    }

    @Test
    public void getCartAPI() {
        System.out.println("get cart API test");
    }

    @Test
    public void getShippingAddressAPI() {
        System.out.println("get Shipping Address API API test");
    }
}
