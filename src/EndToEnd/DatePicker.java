package EndToEnd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DatePicker {

    public static void switchToCalendarWindow(WebDriver driver, String parentWindow){
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        while (itr.hasNext()){
            String childWindow = itr.next();
            if (!parentWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                System.out.println(driver.getTitle());
            }
        }
    }

    public static void selectYear(WebDriver driver){
        driver.findElement(By.className("input-group-addon")).click();
        driver.findElement(By.cssSelector("table[class=' table-condensed'] th[class='datepicker-switch']")).click();

        driver.findElement(By.cssSelector("div[class='datepicker-months'] th[class='datepicker-switch']")).click();

        List<WebElement> years =driver.findElements(By.cssSelector("div.datepicker-years > table > tbody > tr > td > span"));
        for (int i = 0; i <years.size() ; i++) {
            String year = years.get(i).getText();
            if (year.equals("2023")) {
                years.get(i).click();
                break;
            }
        }
    }

    public static void selectMonth(WebDriver driver){
        List<WebElement> months =driver.findElements(By.cssSelector("div.datepicker-months > table > tbody > tr > td > span"));
        for (int i = 0; i <months.size() ; i++) {
            String month=months.get(i).getText();
            if (month.equals("Feb")){
                months.get(i).click();
                break;
            }
        }
    }

    public static void selectDate(WebDriver driver){
        List<WebElement> dates =driver.findElements(By.cssSelector(" table > tbody > tr >td"));
        for (int i = 0; i <dates.size() ; i++) {
            String date=dates.get(i).getText();
            if (date.equals("19")){
                dates.get(i).click();
                break;
            }
        }
    }

    public static void calenderAssertion(WebDriver driver){
        driver.findElement(By.className("input-group-addon")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("td.active.day")).getText(),"19");
    }

    public static void switchBackToParentWindow(WebDriver driver, String parentWindow){
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle());
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/index.html");

        driver.findElement(By.id("datepicker")).click();
        String parentWindow= driver.getWindowHandle();

        switchToCalendarWindow(driver,parentWindow);
        selectYear(driver);
        selectMonth(driver);
        selectDate(driver);
        calenderAssertion(driver);
        switchBackToParentWindow(driver,parentWindow);
        driver.close();

    }
}
