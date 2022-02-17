package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefExceptionConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//1.approach
//		//DOM v1
//		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
//		//DOM v1
//		WebElement fn = driver.findElement(By.id("Form_submitForm_Name"));
//		//stale element reference: element is not attached to the page document		
//		fn.sendKeys("sush");
//		driver.navigate().refresh();
//		//back/fwd
//		//DOM v2 (dom creates a new id )
//		fn = driver.findElement(By.id("Form_submitForm_Name"));
//		fn.sendKeys("adhu");
		//2.Approach
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
//		WebElement fn = driver.findElement(By.id("Form_submitForm_Name"));
//		fn.sendKeys("sush");
//		driver.navigate().refresh();
//		
//		//Topcasting with parent class FluentWait to child WebDriverWait
//		FluentWait<WebDriver> wait=new WebDriverWait(driver, Duration.ofSeconds(10))
//							.pollingEvery(Duration.ofSeconds(1))
//							.ignoring(StaleElementReferenceException.class);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Form_submitForm_Name"))).sendKeys("Adhu");
		
		//Assignment with By locator
		/**
		 * This approach with By locator wont give stale element exception
		 */
		By fName=By.id("Form_submitForm_Name");
		driver.findElement(fName).sendKeys("Adhu");
		driver.navigate().refresh();
		driver.findElement(fName).sendKeys("sush");
		
		
		

	}

}
