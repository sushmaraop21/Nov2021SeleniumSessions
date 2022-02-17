package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {
		// Implicitly wait- is dynamic wait ->not static
		// Its only applicable for Webelements: FE,FEs
		// Not applicable for non web elements: Title,URL,alert
		// global wait: Once it is applied,it will be applicable for all the upcoming web elements

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		//10 secs - max time (if 2esc-8 secs will be ignored)->it waits for 10 secs gives exception-in case if it doesnt find
		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys("test@gmail.com");
		
		// 10 secs - v can override for 5 secs for pwd
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement pwd=driver.findElement(By.id("test"));
		// for the rest of 100 elements- 5 secs will b applied
		//e3- 5
		//e4- 5
		//home page : v need 20 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Home1
		//Hom2
		//Home3
		//click on logout-landing on login page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// so n number of times v need to override the implicitly timeout according to the pages
		
		//click on reg-page: v dont wait wait: so overirde with 0 secs		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		//Reg page1
		//Reg page2
		
		// so we never use - its a bad design

	}

}
