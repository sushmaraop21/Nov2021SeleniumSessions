package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		// Create a web element
		// WebEle =By locator
		// Create Web element +action(Click, sendkeys, isDidplayed..)
		
		//1st locator:ID locator

		// 1. way of creating a webelement- unnecesserily v hit the server always to create web element
//		driver.findElement(By.id("input-email")).sendKeys("Sush@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@123");

		// 2.
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//
//		emailId.sendKeys("Sush@gmail.com");
//		pwd.sendKeys("test@123");
//		
		//3.by locator:
		
//		By emailId=By.id("input-email");
//		By password=By.id("input-password");
//		
//		WebElement eID= driver.findElement(emailId);
//		WebElement pwd= driver.findElement(password);
//		
//		eID.sendKeys("Sush@gmail.com");
//		pwd.sendKeys("test@123");
		
		//4.by locator with generic method
//		By emailId=By.id("input-email");
//		By password=By.id("input-password");
//		
//		getElement(emailId).sendKeys("Sush@gmail.com");
//		getElement(password).sendKeys("test@123");

		//5.by locator with get element and actions generic method
//		By emailId=By.id("input-email");
//		By password=By.id("input-password");
//		
//		doSendKeys(emailId, "Sush@gmail.com");
//		doSendKeys(password, "test@123");
//		
		//6.by locator with get element and actions generic method in util class
		//By locator should be maintained here in page locator n not in the util class
//		By emailId=By.id("input-email");
//		By password=By.id("input-password");
//		
//		ElementUtil eleUtil=new ElementUtil(driver);
//		eleUtil.doSendKeys(emailId, "Sush@gmail.com");
//		eleUtil.doSendKeys(password, "test@123");
		
		//7.string locator with by and get element and actions generic method in util class
//		
//		String eID= "input-email";
//		String pwd1="input-password";
//		
//		doSendKeys("id", eID, "input-email");
//		doSendKeys("id", pwd1, "test@123");
		//8.string locator with By, and getElement and actions generic method in util class
		
		String eID= "input-email";
		String pwd1="input-password";
		
		ElementUtil eleUtil=new ElementUtil(driver);
		eleUtil.doSendKeys("id", eID, "Sush@gmail.com");
		eleUtil.doSendKeys("id", pwd1, "test@123");
		
	}
	
	public static By getBy(String locatorType, String locatorValue) {
		
		By locator=null;
		
		switch (locatorType.toLowerCase()) {
		case "id":
			locator=By.id(locatorValue);			
			break;

		default:
			break;
		}
		return locator;
		
	}
	
	
	//pass any by locator and get the element and perform the action
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	

	/**
	 * overloaded method
	 * v r calling getelement (getBy()-> which gives locator)
	 * 
	 * @param locatorType
	 * @param locatorValue
	 * @param value
	 */
	public static void doSendKeys(String locatorType, String locatorValue,String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}

	
}
