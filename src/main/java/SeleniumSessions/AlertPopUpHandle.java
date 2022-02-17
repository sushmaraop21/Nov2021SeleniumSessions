package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		// Alert:js alert popup
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();

		
		//alert pop up
		Thread.sleep(5000);
		Alert alert=driver.switchTo().alert(); //Switches to the currently active modal dialog for this particular driver instance
		String text=alert.getText();
		System.out.println(text);
		alert.accept();// click on ok btn
		//alert.dismiss();// click on cancel=> like esc key
		//alert.sendKeys("testing");
		
		
		

	}

}
