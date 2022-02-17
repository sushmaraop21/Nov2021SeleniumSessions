package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitNonWebElements {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");

		String title = doGetPageTitle("Amazon", 5);
		System.out.println(title);

	//	System.out.println(doGetPageTitleIs("Amazon", 5)); //TimeoutException: Expected condition failed -will wait for exact title
		System.out.println(doGetPageTitleIs("Amazon.com. Spend less. Smile more.", 5));

	}

	public static boolean waitForPageTitle(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleValue));
	}

	// where as wait.until returns string here
	public static boolean waitForPageActTitle(String actTitle, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(actTitle));
	}

	public static String doGetPageTitle(String titleValue, int timeOut) {
		if (waitForPageTitle(titleValue, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}

	public static String doGetPageTitleIs(String titleValue, int timeOut) {
		if (waitForPageActTitle(titleValue, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
	//practice
	public static boolean waitforpagetitle(String title,int timeout) {
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait1.until(ExpectedConditions.titleContains(title));
		
	}
	public static String getpagetitle(String title,int timeout) {
		if(waitForPageActTitle(title, timeout)) {
			return driver.getTitle();
		}
		return null;
	}

}
