package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomElement {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		// this is a shadow element
		// Hierarchy- Browser-page-iFrame-shadowDom-input
		// driver.findElement(By.id("tea")).sendKeys("masala tea"); //no such element:
		// Unable to locate element exception

		driver.switchTo().frame("pact");
		// document.querySelector("#snacktime").shadowRoot.querySelector("#tea") =>copy
		// jspath
		// v have to use jscript executor
		// v have to convert driver to jsexecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// typecast into webelement ( this will return html element -so v r converting to webelement
		WebElement tea = (WebElement) js
				.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		tea.sendKeys("Masala Tea");

	}

}
