import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowActivities {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.navigate().to("https://rahulshettyacademy.com/");
        driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googinhydr1-21&ref=pd_sl_98xjxt98l7_e&adgrpid=60639568242&hvpone=&hvptwo=&hvadid=617721280315&hvpos=&hvnetw=g&hvrand=9649586625296222659&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062083&hvtargid=kwd-316976916880&hydadcr=5841_2362028&gclid=CjwKCAiA7IGcBhA8EiwAFfUDsfHQ6TLMIOVubTocxeGozBqWhS2FFIZAV5qCvhNgihMR4Kii0zRGlxoCti4QAvD_BwE");
        driver.navigate().back();
        driver.navigate().forward();

        driver.close();
    }
}
