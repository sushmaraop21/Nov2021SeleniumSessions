package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WDMConcept {

	public static void main(String[] args) {

		 WebDriverManager.chromedriver().setup();// Chrome-96.0--download 96.0 exe
		/// WebDriverManager.firefoxdriver().setup();
		// WebDriverManager.chromedriver().browserVersion("87.0").setup();
		 
		 
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("title:" + title);

		driver.quit();

	}

}
