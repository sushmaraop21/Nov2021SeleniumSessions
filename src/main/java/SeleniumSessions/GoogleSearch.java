package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
//		driver.findElement(By.name("q")).sendKeys("Naveen Automation Labs");
//		Thread.sleep(3000);

//		List<WebElement> suggList = driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span"));
//		System.out.println(suggList.size());
//		for (WebElement e : suggList) {
//			String text = e.getText();
//			if (text.contains("Naveen automation labs resume")) {
//				e.click();
//				break;
//			}
//
//		}
//		
		// Assignment-without forloop
		driver.findElement(By.name("q")).sendKeys("Naveen Automation Labs");
		Thread.sleep(4000);
		WebElement ele=driver.findElement(By.xpath("//div[@class='OBMEnb']//b[contains(text(),' mock interview')]"));		
		//WebElement ele = driver.findElement(By.xpath("//li[@role='presentation']//div[@class='wM6W7d']/span")); // not this
		ele.click();

	}
}
