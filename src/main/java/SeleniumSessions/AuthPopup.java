package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthPopup {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		String userName="admin";
		String pwd="admin";
		driver.get("https://"+userName+":"+pwd+"@the-internet.herokuapp.com/basic_auth");
		//cdp tool-sel4=>will allow u to pass any UN n pwd
	}

}
