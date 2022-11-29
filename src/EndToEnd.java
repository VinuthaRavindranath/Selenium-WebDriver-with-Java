import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class EndToEnd {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.cssSelector("input[id*=\"originStation1_CTX\"]")).click();
        driver.findElement(By.cssSelector("a[value=\"BLR\"]")).click();
        driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"]//a[@value=\"GOI\"]")).click();

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

        driver.findElement(By.cssSelector("#divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.cssSelector("#hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#divpaxinfo")).getText(),"5 Adult");

        WebElement currencyDropdown = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(currencyDropdown);
        dropdown.selectByValue("INR");

        driver.findElement(By.cssSelector("input[id*=\"btn_FindFlights\"]")).click();

        Thread.sleep(1000);
        driver.close();

    }
}
