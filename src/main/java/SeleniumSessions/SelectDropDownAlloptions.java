package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownAlloptions {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		// html tag=select

		By country = By.id("Form_submitForm_Country");
		By state = By.xpath("//select[@id='Form_submitForm_State']");

//		Select select = new Select(driver.findElement(country));
//		List<WebElement> optionsList = select.getOptions();
//		System.out.println(optionsList.size());
//		int i=0;
//		for(WebElement e: optionsList) {
//			System.out.println(i+":"+e.getText());// to get index
//			i++;
//		}
		System.out.println(getDropDownOptionsList(country));
		if (getDropDownOptionsList(country).contains("India")) {
			System.out.println("India is present");
		}

		selectValueFromDropDown(country, "India");
		selectValueFromDropDown(state, "Karnataka");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<String> getDropDownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>(); // top casting of arraylist
		System.out.println(optionsList.size());
		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}

	/*
	 * this method is interview question=>when u cant use index,visibletext,value
	 * methods
	 */
	public static void selectValueFromDropDown(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();

		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}
}
