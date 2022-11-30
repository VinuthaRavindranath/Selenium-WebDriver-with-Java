package WebElementsAndBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Calendar {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.cssSelector("input[id*=\"rbtnl_Trip_1\"]")).click();

        if ( driver.findElement(By.className("picker-second")).getAttribute("style").contains("1") ){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }

        driver.findElement(By.cssSelector("input[id*=\"view_date1\"]")).click();

        List<WebElement> dates=driver.findElements(By.cssSelector(" div.ui-datepicker-group.ui-datepicker-group-first > table > tbody > tr:nth-child(5) > td>a"));
        int total_nodes=dates.size();
        for (int i = 0; i < total_nodes; i++) {
            String date=dates.get(i).getText();
            if (date.equals("31")){
                dates.get(i).click();
                break;
            }
            else if(date.equals("30")){
                dates.get(i).click();
                break;
            }
        }

        Thread.sleep(1000);
        driver.close();


    }
}
