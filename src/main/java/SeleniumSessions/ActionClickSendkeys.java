package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClickSendkeys {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		By fn = By.id("input-firstname");
		By ln = By.id("input-lastname");		By emailID=By.id("input-email");
		By telephone=By.id("input-telephone");
		By pwd=By.id("input-password");
		By cfmPwd=By.id("input-confirm");
		By radioBtnNo=By.xpath("//input[@value=0]");
		By chkBox=By.name("agree");
		By login = By.xpath("//input[@value='Continue']");
		By register=By.id("content");


//		Actions act = new Actions(driver);
//		act.sendKeys(driver.findElement(fn), "Sush").perform();
//		act.sendKeys(driver.findElement(ln), "Vijay").perform();
//		act.click(driver.findElement(login)).perform();
		doActionsSendKeys(fn, "Sush");
		doActionsSendKeys(ln, "vijay");
		doActionsSendKeys(emailID, "adhu1@gmail.com");
		doActionsSendKeys(telephone, "9876512345");
		doActionsSendKeys(pwd, "test123");
		doActionsSendKeys(cfmPwd, "test123");
		doActionsClick(radioBtnNo);
		doActionsClick(chkBox);		
		doActionsClick(login);
		if(getElement(register).getText().contains("Your Account Has Been Created!")){
			System.out.println("successful");
		}
		else {
			System.out.println("Not successful");
		}
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
/**
 * Equivalent to calling: Actions.click(element).sendKeys(keysToSend).This method is different from 
 * @param locator
 * @param value
 */
	public static void doActionsSendKeys(By locator, String value) {
		Actions act=new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();

	}
	/**
	 * Clicks in the middle of the given element. Equivalent to: Actions.moveToElement(onElement).click()
	 * @param locator
	 */
	public static void doActionsClick(By locator) {
		Actions act=new Actions(driver);
		act.click(getElement(locator)).perform();

	}
}
