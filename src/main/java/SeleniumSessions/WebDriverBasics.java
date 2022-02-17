package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vijay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//automation steps:
		WebDriver driver = new ChromeDriver(); // manual tcs- launch chrome

		driver.get("https://www.google.com");//enter url
			// driver.get("www.google.com");
		String title = driver.getTitle();//get the title of the page
		System.out.println("Title is " + title); // this is not testing => v r not saying this correct or not

		// verification point/check point/ actual vs expected result

		if (title.equals("Google")) {
			System.out.println("Correct title");
		} else {
			System.out.println("Incorrect");
		}	//=automation testing

	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getPageSource());
		if(driver.getPageSource().contains(" Copyright The Closure Library Authors")) {
			System.out.println("present..");
		}else {
			System.out.println("not presen");
		}
		driver.quit();
		
		
		//Assignment
		
		WebDriver dr=new ChromeDriver();
		dr.get("https://www.facebook.com");
		String t=dr.getTitle();
		System.out.println("Title :"+ t);
		
		if(t.contains("Facebook")){
			System.out.println("Correct title");
		}else {
			System.out.println("Incorrect");
		}
		dr.quit();
		
		WebDriver d=new ChromeDriver();
		d.get("https://www.rediff.com/");
		String redT=d.getTitle();
		System.out.println("Title :"+redT);
		
		if(redT.equals("rediff")) {
			System.out.println("Crrect");
		}else {
			System.out.println("Incorrect");
		}
		d.quit();
	}

}
