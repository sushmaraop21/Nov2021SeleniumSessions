package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	static WebDriver driver;

	public static void main(String[] args) {

		// 1.id :unqiue- I
		// 2.name : can be duplicate-II
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		// driver.findElement(By.name("email")).sendKeys("test@gmail.com");

		// 3.classname :can be duplicateIV
		// driver.findElement(By.className("form-control")).sendKeys("MAC");

		// 4.xpath: is not an attribute->is and address of the element in HTML DOM -III
		// absolute path, relative path
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("test@gmail.com");
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("test@123");
//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
//		
//		By emailId=By.xpath("//*[@id=\"input-email\"]");
//		By pwd=By.xpath("//*[@id=\"input-password\"]");
//		By loginBtn=By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
//		
//		doSendKeys(emailId,"test@gmail.com");
//		doSendKeys(pwd,"test@123");
//		doClick(loginBtn);

		// 5.cssSelector : is not an attribute
		// CSS-Cascaded Style Sheet
//		By emailId=By.cssSelector("#input-email");
//		By pwd=By.cssSelector("#input-password");
//		By loginBtn=By.cssSelector("#content > div > div:nth-child(2) > div > form > input");
//		
//		doSendKeys(emailId,"test@gmail.com");
//		doSendKeys(pwd,"test@123");
//		doClick(loginBtn);

		// 6.LinkText : only for links: <a>
//		driver.findElement(By.linkText("Register")).click();

		// 7.PartialLinkText:
//		driver.findElement(By.partialLinkText("Forgotten")).click();

		// 8.tagName: html tag
//		String header=driver.findElement(By.tagName("h2")).getText();
//		System.out.println(header);

		By register = By.linkText("Register");
		By header=By.tagName("h2");
		
		System.out.println(dogetText(register));
		System.out.println(dogetText(header));
	

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
