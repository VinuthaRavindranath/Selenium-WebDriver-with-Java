package ChromeDevTools;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v105.network.Network;
import org.openqa.selenium.devtools.v105.network.model.Request;
import org.openqa.selenium.devtools.v105.network.model.Response;

import java.util.Optional;

public class NetworkLogActivity {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), request -> {
            Request req= request.getRequest();
            System.out.println(req.getUrl());
//            System.out.println(req.getMethod());
//            System.out.println(req.getHeaders());
//            System.out.println(req.getPostData());

        });

        devTools.addListener(Network.responseReceived(),response -> {
            Response res=response.getResponse();
            if(res.getStatus() >= 200 && res.getStatus() < 300) {
                System.out.println(res.getUrl()+"failed with status "+res.getStatus());
            }
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
        Thread.sleep(2000);

    }
}
