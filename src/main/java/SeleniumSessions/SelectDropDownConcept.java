package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		// html tag=select

		By country = By.id("Form_submitForm_Country");
		By state=By.id("Form_submitForm_State");
//		WebElement countr_ele = driver.findElement(country);
//		WebElement state_ele=driver.findElement(state);
//
//		// this selenium select class can be used only for the html tags 'select'
//		Select select = new Select(countr_ele);
//		select.selectByIndex(5); // we can use this method where the values r always static/constant like calendar
//		select.selectByVisibleText("India"); //so always btr to use this
//		//select.selectByValue("Australia");// most of the apps value attribute wont be available
//		Thread.sleep(2000);
//		
//		Select select1=new Select(state_ele);
//		select1.selectByVisibleText("Karnataka");
//		
		doSelectDropDownByIndex(country, 5);
//		Thread.sleep(2000);
//		doSelectDropDownByIndex(state, 2); // exception=>no state for this country
		
		doSelectDropDownByVisibleText(country, "India");
		Thread.sleep(2000);
		doSelectDropDownByVisibleText(state, "Karnataka");
		
				
	} 
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropDownByIndex(By locator,int index) {
		Select select=new Select(getElement(locator));
		select.selectByIndex(index);
	}
	public static void doSelectDropDownByVisibleText(By locator,String visibleText) {
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	public static void doSelectDropDownByValue(By locator,String value) {
		Select select=new Select(getElement(locator));
		select.selectByValue(value);
	}
	
}
