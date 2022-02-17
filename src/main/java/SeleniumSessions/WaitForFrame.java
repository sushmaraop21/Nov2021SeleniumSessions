package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrame {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");

//		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(2));
		By frameLocator=By.name("main");
		//waitForFrameByIndex(5, 2);
		//waitForFrameByLocator(5, frameLocator);
		waitForFrameByElement(5, driver.findElement(frameLocator));
		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);
	}

	/**
	 * An expectation for checking whether the given frame is available to switch
	 * to. If the frame is available it switches the given driver to the specified
	 * frameIndex.
	 * 
	 * @param timeOut
	 * @param frameIndex
	 * @return
	 */
	public static WebDriver waitForFrameByIndex(int timeOut, int frameIndex) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public static WebDriver waitForFrameByLocator(int timeOut, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

	}
	public static WebDriver waitForFrameByElement(int timeOut, WebElement frameElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));

	}
}
