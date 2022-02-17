package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefox {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\vijay\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");// enter url
		String title = driver.getTitle();
		System.out.println("Title is " + title);

	}

}
