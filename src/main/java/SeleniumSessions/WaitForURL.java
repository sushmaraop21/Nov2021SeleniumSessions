package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForURL {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.linkText("Register")).click();

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		if (wait.until(ExpectedConditions.urlContains("account/register"))) {
//			System.out.println(driver.getCurrentUrl());
//		}

		String url = waitForURLContains("account/register", 5);
		System.out.println(url);
		
		System.out.println(waitForURLToBe("https://demo.opencart.com/index.php?route=account/register", 2));
	}

	public static String waitForURLContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	public static String waitForURLToBe(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlToBe(urlFraction))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
}
