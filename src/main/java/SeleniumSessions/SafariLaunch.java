package SeleniumSessions;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.safari.SafariDriver;

public class SafariLaunch {
	public static void main(String[] args) {

			WebDriver driver = new SafariDriver();
		driver.get("https://www.google.com");// enter url
		String title = driver.getTitle();
		System.out.println("Title is " + title);

	}
}
