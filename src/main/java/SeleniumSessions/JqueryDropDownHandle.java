package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		By choices = By.xpath("//span[@class='comboTreeItemTitle']");
		// tc_1: single selection
		// selectChoice(choices, "choice 1");
//		selectChoice(choices, "choice 2");
//		selectChoice(choices, "choice 2 2");

		 selectChoice(choices, "choice 8");//nagative scenario

		// tc_2: multiple selection
		// selectChoice(choices, "choice 1","choice 2");
		// selectChoice(choices, "choice 1", "choice 2", "choice 2 2");
		// selectChoice(choices, "choice 1", "choice 2", "choice 7");

		// Assignment =>handle this below secnario
		//selectChoice(choices, "choice 1", "choice 2", "choice 8");
		// tc_3:all selection
		 selectChoice(choices, "all"); // value=1 array size =>value param

	}

//for multiple values v have this String...=>multiples values can be passed 
	public static void selectChoice(By locator, String... value) {
		List<WebElement> choicesList = driver.findElements(locator);
		boolean flag = false; // v r maintaining this flag for negative scenario choice 8
		if (!value[0].equalsIgnoreCase("all")) {
			for (WebElement e : choicesList) {
				String text = e.getText();
				System.out.println(text);

				for (int i = 0; i < value.length; i++) {
					if (text.equals(value[i])) {
						e.click();
						flag = true;
						break;
					} else {
						flag = false;
					}
				}
			}
		}

		else {
			try {
				// for all selection
				for (WebElement e : choicesList) {
					e.click();
					flag = true;
				}
			} catch (ElementNotInteractableException e) {
				System.out.println("No more choices available....");
			}
		}
//		if (flag == false) {
//			System.out.println("Choice is not available " + value[0]); // this value s printed correctly for choice 8
//																		// but not multiple choices
//		}

	}
}
