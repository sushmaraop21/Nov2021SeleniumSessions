package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorsConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		WebElement ele = driver.findElement(By.linkText("Victoria, Canada"));
		String text = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(text);
		String rank=driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(rank);
		String belowCity=driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(belowCity);
		String aboveCity=driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(aboveCity);
		//near-15pixels radius
		String near=driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(near);//v r getting-Victoria, Canada- the nearest p of a link here is p
		
		//u get all the values above the element defined-above this-Victoria, Canada
		List<WebElement> list=driver.findElements(with(By.tagName("p")).above(ele));
		for(WebElement e:list) {
			System.out.println(e.getText());
		}
	}

}
