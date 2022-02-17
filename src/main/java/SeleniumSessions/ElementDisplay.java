package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisplay {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailId = By.id("input-email");
		if (doIsdisplayed(emailId)) {
			doSendKeys(emailId, "test@gmal.com");
		}
		driver.findElement(emailId).isEnabled();// visible but disabled

	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static boolean doIsdisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
