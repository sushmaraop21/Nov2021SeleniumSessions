package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchSugg {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		driver.findElement(By.id("search_query_top")).sendKeys("Dress");
		Thread.sleep(4000);
		//This below=> works without the generic method
//		WebElement ele=
//				driver.findElement(By.xpath("//div[@class='ac_results']//li[contains(text(),'Casual Dresses > Printed')]"));
//		ele.click();		

		 selectSuggestion("Casual Dresses > Printed");

		// Assignment with for loop
//
//		List<WebElement> elements = driver
//				.findElements(By.xpath("//div[@class='ac_results']//li[contains(text(),'Dress')]"));
//		System.out.println(elements.size());
//		for (WebElement e : elements) {
//			String text = e.getText();
//			if (text.contains("Printed Summer Dress")) {
//				e.click();
//				break;
//			}
//		}
//		

	}

//we cant use the by locator here-thats y v r appending suggestion to the xpath
	public static void selectSuggestion(String suggestion) {
		WebElement ele = driver
				.findElement(By.xpath("//div[@class='ac_results']//li[contains(text(),'" + suggestion + "')]"));
		ele.click();

	}

}
