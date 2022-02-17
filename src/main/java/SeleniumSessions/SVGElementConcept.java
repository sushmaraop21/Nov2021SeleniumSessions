package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		Thread.sleep(5000);

		String xvgXpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']/*[name()='g']/*[name()='path']";

		List<WebElement> graphList = driver.findElements(By.xpath(xvgXpath));

		Actions act = new Actions(driver);
		for (WebElement e : graphList) {
			act.moveToElement(e).perform();
			Thread.sleep(1000);
			String nameAttr = e.getAttribute("name");
			System.out.println(nameAttr);
			if (nameAttr.equalsIgnoreCase("tennessee")) {
				// e.click();- this doesnt work here
				act.click(e).perform();
				break;
			}
		}

	}

//	public void getCounty() {
//		String svgXPath=
//				child
//				47189
//	}

	// flipkart- page - svgpath -flipkart.com
	//
	// *[local-name()='svg']/*[name()='g' and @fill-rule='evenodd']

}
