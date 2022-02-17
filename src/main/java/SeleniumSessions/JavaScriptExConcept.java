package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://www.freshworks.com/");
		//driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.get("https://amazon.com/");

		// JavascriptExecutor - is an Interface and '(JavascriptExecutor)driver' this
		// acts like a reference and v store in
		// JavascriptExecutor js like this.=>here v r converting driver into js executor

//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		String text=js.executeScript("return document.title;").toString(); // document.title is js code=>document is obj of dom and title is giving u the title of the page
//		System.out.println(text);
//		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//		String text = jsUtil.getTitleByJS();
//		System.out.println(text);
//
//		String pageText = jsUtil.getPageInnerText();
//		if (pageText.contains("Book")) {
//			System.out.println("pass");
//		}
//		
//		jsUtil.generateAlert("hi this is selenium alert");
		//jsUtil.refreshBrowserByJS();
		
		//the border appears only after the page is fully loaded
		//WebElement ele=driver.findElement(By.xpath("//h1[text()='Delight made easy']")); 
//		WebElement ele=driver.findElement(By.cssSelector("div #content form"));
//		jsUtil.drawBorder(ele);
		
//	WebElement ele=driver.findElement(By.id("input-email"));
//		WebElement eleP=driver.findElement(By.id("input-password"));
//		
//	jsUtil.flash(ele);
//	ele.sendKeys("test@gmail.com");
//	jsUtil.flash(eleP);
//		eleP.sendKeys("test");
		
		//Vertical scrolling-not horizontal
//		jsUtil.scrollPageDown();
//		Thread.sleep(5000);
//		jsUtil.scrollPageUp();	
		//jsUtil.scrollPageDown("700");
		
		WebElement ele=driver.findElement(By.xpath("//span[text()='K-12 Classroom management printables' and @class='a-color-base']"));
		jsUtil.scrollIntoView(ele);
		jsUtil.flash(ele);
		jsUtil.drawBorder(ele);
//		
		
//		WebElement custLink=driver.findElement(By.xpath("//a[text()='Careers']"));
//		jsUtil.clickElementByJS(custLink); // we use this when v get elementedinterceptedException
		
//		//sendkeys-only id,name,classname//		
		//jsUtil.sendKeysUsingWithId("input-email", "sush@gmail.com");
	}

}
