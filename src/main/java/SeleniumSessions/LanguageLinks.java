package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageLinks {

	static WebDriver driver;
	static ElementUtil el;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.get("https://www.amazon.com");
//		By langs=By.xpath(("//div[@id='navFooter']/a"));
//		clickOnLink(langs, "Back to top");
//		
//		driver.get("https://www.freshworks.com/");
//		By footers = By.xpath("//ul[@class='footer-nav']//a");
//		clickOnLink(footers, "Careers");

		// Assignment 1

//		By terms = By.xpath("//div[@class='footer-nav copyrights-nav hide-in-mobile']/a");
//		el = new ElementUtil(driver);
//		el.printElementsText(terms); // this will print
//		System.out.println(el.getElementCount(terms));
//		if(el.getElementTextList(terms).contains("Privacy Notice")) {
//		System.out.println("***** Footers present*******");
//		}
		// System.out.println(el.dogetText(terms)); //for just checking
		// clickOnLink(terms, "Terms of service");
	// clickOnLink(terms, "Privacy Notice");
		// clickOnLink(terms, "Takedown Policy");
		// clickOnLink(terms, "GDPR");
		// clickOnLink(terms, "Security");
		// clickOnLink(terms, "CSR Policy");
		// clickOnLink(terms, "TAX FAQs");
	//	 clickOnLink(terms, "Unsubscribe");
		 
		// Assignment 2

		driver.get("https://google.com");
		By googlefooters = By.xpath("//div[@class='KxwPGc AghGtd']/a");
		By googleRHSfooters = By.xpath("//div[@class='KxwPGc iTjxkf']/a");
		By settingsbtn = By.xpath("//button[text()='Settings']");
		el = new ElementUtil(driver);
		// this is for lhs footers
		el.printElementsText(googlefooters);
		System.out.println(el.getElementCount(googlefooters));
		if (el.getElementTextList(googlefooters).contains("Business")) {
			System.out.println("******Successful**********");
		}
		// clickOnLink(googlefooters, "Business");
		//clickOnLink(googleRHSfooters, "Privacy");
		// rhs footers
		el.printElementsText(googleRHSfooters);
		int count = el.getElementCount(googleRHSfooters);
		System.out.println(count);
		if (el.getElementTextList(googleRHSfooters).contains("Terms")) {
			System.out.println("RHS footers present...");
		}
		// settings footer link
		el.printElementsText(settingsbtn);
		el.clickOnLink(settingsbtn, "Settings");
		//el.doClick(settingsbtn);

		//el.getElementAttributeList(settingsbtn, "src");

	}

	public static void clickOnLink(By locator, String linkText) {

		List<WebElement> langList = driver.findElements(locator);
		System.out.println(langList.size());

		for (WebElement e : langList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(linkText)) {
				e.click();
				break;
			}
		}
	}

	/**
	 * practice print method
	 * 
	 * @param locator
	 */
	public static void printElementsText(By locator) {
		// List<WebElement> eleList = driver.findElements(locator); // v dont need to
		// write likt this as we hav method
		List<WebElement> eleList = el.getElements(locator);
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				System.out.println(text);
			}
		}
	}

//practice method
	public static int getCount(By locator) {
		// List<WebElement> eleList = driver.findElements(locator);
		return el.getElements(locator).size();
	}
}
