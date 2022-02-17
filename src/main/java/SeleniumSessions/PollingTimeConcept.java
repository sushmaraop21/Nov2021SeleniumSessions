package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PollingTimeConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-emai11l");
		By pwd = By.id("input-password");
		// default time when v dont mention anything: 500 milli secs
		// Expected condition failed: waiting for visibility of element located by
		// By.id: input-emai11l (tried for 10 second(s) with 500 milliseconds interval)

		// Expected condition failed: waiting for visibility of element located by
		// By.id: input-emai11l (tried for 10 second(s) with 2000 milliseconds interval)
		// ->this is when v gave polling time 2 secs
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.pollingEvery(Duration.ofSeconds(2));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2)); // here sleep is
																										// poolling time

		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));
		ele.sendKeys("test@gmail.com");

	}

}
