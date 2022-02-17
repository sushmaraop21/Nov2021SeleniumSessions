package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementWithList {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		List<WebElement> footersList = driver.findElements(By.xpath("//ul[@class='footer-nav']//a"));

		for (int i = 0; i < footersList.size(); i++) {
			footersList.get(i).click();
			// Thread.sleep(1000);
			driver.navigate().back(); // stale element reference: element is not attached to the page document
			// Thread.sleep(1000);
			footersList = driver.findElements(By.xpath("//ul[@class='footer-nav']//a"));
		}

	}

}
