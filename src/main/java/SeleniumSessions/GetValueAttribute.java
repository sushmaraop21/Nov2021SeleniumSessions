package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetValueAttribute {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId=By.id("input-email");
		doSendKeys(emailId, "sush@gmail.com");
		
	//	String att=driver.findElement(emailId).getAttribute("placeholder");//E-Mail Address
		String att=driver.findElement(emailId).getAttribute("value"); //sush@gmail.com
		System.out.println(att);
		
		String para=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/p[2]")).getText();
		System.out.println(para);
		
		
//		String text=dogetText(emailId); // this wont work for the text in the textbox
//		System.out.println(text);
		
		System.out.println(doGetAttribute(emailId, "value"));
		

	}
	
	public static String doGetAttribute(By locator,String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	public static String dogetText(By locator) {
		return getElement(locator).getText();
	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}


}
