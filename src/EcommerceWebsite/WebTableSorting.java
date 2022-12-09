package EcommerceWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

//Using streams() and lambda function
public class WebTableSorting {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.cssSelector("span.sort-icon.sort-descending")).click();
        List<WebElement> texts = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> OriginalTexts = texts.stream().map(text -> text.getText()).collect(Collectors.toList());

        List<String> SortedTexts = OriginalTexts.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(OriginalTexts.equals(SortedTexts));

        List<String> price;
        do {
            List<WebElement> elementTexts = driver.findElements(By.xpath("//tr/td[1]"));
            price = elementTexts.stream().filter(s -> s.getText().contains("Strawberry")).map(s -> getVeggiePrice(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if (price.size() < 1) {
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        }
        while (price.size() < 1);

    }

    private static String getVeggiePrice(WebElement s) {
        String veggiePrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return veggiePrice;
    }
}
