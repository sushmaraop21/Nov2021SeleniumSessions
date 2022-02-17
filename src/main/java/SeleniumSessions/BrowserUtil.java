package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * This method is used to initialize the driver on the basis of browsername
	 * 
	 * @param browser return returns webdriver
	 */

	public WebDriver launchBrowser(String browser) {
		System.out.println("Browser is: " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
		//	System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();			
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver","C:\\Users\\vijay\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			 WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
		}
		// write for edge
		else
			System.out.println("please pass the right browser");
		return driver;
	}
	
	//Assignment browser switch case
	public WebDriver launchBrowser2 (String browser2) {
		System.out.println("Browser is:" +browser2);
		switch (browser2.toLowerCase().trim()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();			
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		default:
			break;
		}
		return driver;
	}
	
	

	/**
	 * method to validate url
	 * @param url
	 */

	public void enterUrl(String url) {
		System.out.println("Url is .." + url);
		if (url.contains("https") || url.contains("http")) {
			driver.get(url);
		} else {
			System.out.println("incorrect url...");
			try {
			throw new Exception("Incorrect URL Missing https or http");
			}
			catch (Exception e) {
				
			}
		}

	}

	public String getPageTitle() {
		return driver.getTitle();
		
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	public void closeBrowser() {
		driver.close();
	}

}
