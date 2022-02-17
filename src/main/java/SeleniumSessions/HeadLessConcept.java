package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessConcept {
	
	//execution is faster in headless mode-it blocks browser launch( main use-quick sanity checks)
	//mouse over ,popups might not work in headless-limitations

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co=new ChromeOptions();
		//co.addArguments("--headless");
		co.setHeadless(true);// v can use this as well
		
		WebDriver driver = new ChromeDriver(co); //co has to be passed in this constructor of chrome driver

		driver.get("https://www.google.com");//enter url
			// driver.get("www.google.com");
		String title = driver.getTitle();
		System.out.println("Title is " + title); 

		if (title.equals("Google")) {
			System.out.println("Correct title");
		} else {
			System.out.println("Incorrect");
		}	//=automation testing

	System.out.println(driver.getCurrentUrl());
	//System.out.println(driver.getPageSource());
		if(driver.getPageSource().contains(" Copyright The Closure Library Authors")) {
			System.out.println("present..");
		}else {
			System.out.println("not presen");
		}
		driver.quit();
		
	}

}
