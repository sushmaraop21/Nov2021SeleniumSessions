package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuitvsClose {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com"); //e00cc1c9c50d995102c8106391a4903b
		String title=driver.getTitle(); //04bb4b3d0bbf45ed02a40622eb827ee1->driver.close
		System.out.println("Title is :"+ title);
		
		if(title.equals("Google")) {
			System.out.println("Correct title");
		}else {
			System.out.println("incorrect title");
		}
		System.out.println(driver.getCurrentUrl());// same session s maintained
		
		//1.
		//driver.quit(); // in this session id is null
		//2.
		driver.close();// in this case session id :b9f83a4b0952b0ca07083a786edf2c36 which is invalid
		System.out.println(driver.getTitle());//NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
		//chrome on WINDOWS (null)
		// invalid session id=> driver close
		driver=new ChromeDriver();	
		System.out.println(driver.getTitle());
	}

}
