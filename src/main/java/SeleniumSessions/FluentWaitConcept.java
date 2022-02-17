package SeleniumSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email111");
		By pwd = By.id("input-password");
		
		//Wait is a raw type. References to generic type Wait<F> should be parameterized
		//dont try to ignore timeout exception-it has to come after 10 secs
//		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
//								.withTimeout(Duration.ofSeconds(10))
//									.pollingEvery(Duration.ofSeconds(2))
//										.ignoring(NoSuchElementException.class)
//											.ignoring(StaleElementReferenceException.class);	
//		WebElement email_ele= wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
		waitForElementPresenceWithFluentWait(emailId, 10, 2).sendKeys("test@gmail.com");
		driver.findElement(pwd).sendKeys("test123");	
										
	}
	
	public static WebElement waitForElementPresenceWithFluentWait(By locator,int timeOut,int pollingTime) {
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofSeconds(pollingTime))
							.ignoring(org.openqa.selenium.NoSuchElementException.class)
							.ignoring(StaleElementReferenceException.class)
							.withMessage(locator+" is not foudn within the time..........");
	 return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	//So here we proved that whatever v can do with fluent wait ,v can do with the webdriver wait
	//in our frameworks v mostly use webdriver wait
	public static void waitForElementPresenceWithWait(By locator,int timeOut,int pollingTime) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(pollingTime))
		.ignoring(org.openqa.selenium.NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.withMessage(locator+ " is not found in the time given");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
