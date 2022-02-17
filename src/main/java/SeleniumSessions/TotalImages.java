package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {

	static WebDriver driver;
	// WAP
	// 1.total images
	// 2.print the alt value
	// 3.print the src value

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		System.out.println("Total images " + imagesList.size());

		for (WebElement e : imagesList) {
			String altval = e.getAttribute("alt");
			String srcval = e.getAttribute("src");
			System.out.println(altval + ":" + srcval);
		}
	}

}
