package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGFlipKart {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/search");
		String svgPath = "//*[local-name()='svg']/*[name()='g' and @fill-rule='evenodd']";
		WebElement search = driver.findElement(By.xpath(svgPath));
		Actions act = new Actions(driver);
		act.moveToElement(search).perform();
//			act.sendKeys(search, "Dress");
//			act.click(search).perform();
		Thread.sleep(3000);
		By enterforSearching= By.xpath("//input[@class='_3704LK']");		
		act.sendKeys(driver.findElement(enterforSearching), "Dress");
		act.click(search).build().perform();


//			WebDriverManager.chromedriver().setup();
//			WebDriver driver = new ChromeDriver();
//			driver.get("https://www.flipkart.com/search");
//			String svgPath = "//*[local-name()='svg']/*[name()='g' and @fill-rule='evenodd']";
//			WebElement search = driver.findElement(By.xpath(svgPath));
//			Actions act = new Actions(driver);
//			act.moveToElement(search).perform();
//			Thread.sleep(3000);
//			By enterforSearching= By.xpath("//input[@class='_3704LK']");
//			
//			act.sendKeys(driver.findElement(enterforSearching), "Dress");
//			act.click(search).build().perform();

	}

}
