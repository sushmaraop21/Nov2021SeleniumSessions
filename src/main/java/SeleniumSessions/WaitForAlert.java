package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlert {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click(); // if this is commented(Expected condition failed: waiting for
														// alert to be present (tried for 5 second(s) with 500
														// milliseconds interval)

		// Thread.sleep(5000);//alert pop up- in usual cases v put thread.sleep for the
		// alert pop up to appear
		// driver.switchTo().alert(); //no such alert exception-may b alert comes after
		// 5 secs
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // this will handle only js alerts
//		System.out.println(alert.getText());
//		alert.accept();

		System.out.println(getAlertText(5));
		acceptAlert(5);
	}

	public static Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public static String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();

	}

	public static void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}

	public static void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
}
