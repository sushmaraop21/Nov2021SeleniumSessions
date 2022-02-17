package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableCheckBox {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		selectEmployee("Joe.Root");
		selectEmployee("John.Smith");
	

	}

	public static void selectEmployee(String name) {
		// a[text()='Joe.Root']/parent::td/preceding-sibling::td/child::input
		WebElement checkBox = driver
				.findElement(By.xpath("//a[text()='" + name + "']/parent::td/preceding-sibling::td/child::input"));
		checkBox.click();
		getEmpDetails(name);
		

	}

	public static void getEmpDetails(String name) {
		// input[@id='ohrmList_chkSelectRecord_21']/parent::td/following-sibling::td[@class='left']
		List<WebElement> listDetails = driver.findElements(
				By.xpath("// a[text()='"+name+"']/parent::td/preceding-sibling::td/child::input/ancestor::tr"));

		for(WebElement e:listDetails) {
			String text=e.getText();
			System.out.println(text);
		}
	}

}
