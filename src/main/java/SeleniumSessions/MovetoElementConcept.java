package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MovetoElementConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// move to element
		// parent to child menu

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/search/?txtsearch=&o=rec");

		WebElement contentParent = driver.findElement(By.className("menulink"));

		// for actions v will send driver, for select v will send webelement
		Actions act = new Actions(driver);
		act.moveToElement(contentParent).build().perform();
		//act.moveToElement(contentParent).perform();//correct
	//	act.moveToElement(contentParent).build(); // doesnt work
		Thread.sleep(3000);
		driver.findElement(By.linkText("COURSES")).click();

	}

}
