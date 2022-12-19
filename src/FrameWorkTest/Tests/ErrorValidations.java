package FrameWorkTest.Tests;


import FrameWorkTest.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ErrorValidations extends BaseTest {
    @Test
    public void loginWithIncorrectCredentials(){
        loginPage.login("vinuthatest27@gmail.com", "test@12356");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error,"Incorrect email or password.");


    }
}
