import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        String username = "Vinutha";

        driver.findElement(By.id("inputUsername")).sendKeys(username);
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();

        System.out.println( driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();

        driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("vinu@gmail.com");
        driver.findElement(By.cssSelector("form > input:nth-child(4)")).sendKeys("999999999");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form > p.infoMsg")).getText());

        driver.findElement(By.xpath("//div[@class=\"forgot-pwd-btn-conainer\"]/button[1]")).click();

        driver.findElement(By.id("inputUsername")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name*=inputPass]")).sendKeys("rahulshettyacademy");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#chkboxOne")).click();
        driver.findElement(By.cssSelector("input#chkboxTwo")).click();
        driver.findElement(By.className("signInBtn")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.login-container >h2")).getText(),"Hello "+ username+",");
        System.out.println(driver.findElement(By.cssSelector("div.login-container >h1")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.login-container >p")).getText(),"You are successfully logged in.");
        driver.findElement(By.cssSelector("button.logout-btn")).click();
        driver.close();
    }
}
