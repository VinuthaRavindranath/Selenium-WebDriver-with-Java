package ChromeDevTools;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.HashMap;
import java.util.Map;

public class MobileEmulatorTest {
    public static void main(String[] args) {

        ChromeDriver driver= new ChromeDriver();
        DevTools devTools= driver.getDevTools();
        devTools.createSession();
       // devTools.send(Emulation.setDeviceMetricsOverride( 600, 1000, 50, 1, 1, 1, 1, 1, 1, 1,))

        Map deviceMetrics = new HashMap()
        {{
            put("width", 600);
            put("height", 1000);
            put("mobile", true);
            put("deviceScaleFactor", 50);
        }};
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.className("navbar-toggler-icon")).click();


    }
}
