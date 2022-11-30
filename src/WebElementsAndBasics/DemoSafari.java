package WebElementsAndBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

public class DemoSafari {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new SafariDriver();
        String password =getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");


        driver.findElement(By.id("inputUsername")).sendKeys("Vinutha");
        driver.findElement(By.cssSelector("input[name*=inputPass]")).sendKeys(password);
        driver.findElement(By.cssSelector("input#chkboxOne")).click();
        driver.findElement(By.cssSelector("input#chkboxTwo")).click();
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.login-container >p")).getText(),"You are successfully logged in.");
        driver.close();

    }
    public static String getPassword(WebDriver driver) throws InterruptedException{
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form > p.infoMsg")).getText();
        String getPassword[]=passwordText.split("'");
        String password=getPassword[1].split("'")[0];
        return password;
    }
}
