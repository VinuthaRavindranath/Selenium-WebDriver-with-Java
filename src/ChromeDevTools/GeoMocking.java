package ChromeDevTools;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class GeoMocking {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map geoLocation =new HashMap()
        {{
            put("latitude", 12.864970);
            put("longitude", 77.655067);
            put("accuracy", 100);
        }};
        driver.executeCdpCommand("Emulation.setGeolocationOverride", geoLocation);
        driver.get("https://mycurrentlocation.net/");
    }
}
