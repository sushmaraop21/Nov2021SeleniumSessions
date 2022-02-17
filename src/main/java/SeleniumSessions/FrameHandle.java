package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		//frame(2)=> frame number 2=>based on index of frame- this s not always reliable
	//	driver.switchTo().frame(2);
		//driver.switchTo().frame("main"); // this is name
		driver.switchTo().frame(driver.findElement(By.name("main")));
				
		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);
		
		driver.switchTo().defaultContent();//Selects either the first frame on the page, or the main document when a page containsiframes. 
		driver.switchTo().parentFrame();//sel4 -new edition
		

	}

}
