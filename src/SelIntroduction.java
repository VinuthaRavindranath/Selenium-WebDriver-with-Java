import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class SelIntroduction {

	public static void main(String[] args) {
		//from selenium version 4.6.0(selenium manager) there is no need to setProperty of chromedriver, hence commented the below line
	    //System.setProperty("webdriver.chrome.driver","/Users/vinuthar/eclipse-workspace/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");

		String title = driver.getTitle();
		System.out.println(title);

		String url = driver.getCurrentUrl();
		System.out.println(url);

		driver.close();
	}

}
