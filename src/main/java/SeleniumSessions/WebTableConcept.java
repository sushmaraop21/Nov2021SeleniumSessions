package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
//		System.out.println(getCompanyName("Maria Anders"));
//		System.out.println(getCompanyName("Roland Mendel"));
//
//		System.out.println(getCountryName("Maria Anders"));
//		System.out.println(getCountryName("Roland Mendel"));
//
//		System.out.println(getRowCount());
//		System.out.println(getCoulmnCount());

		// *[@id="customers"]/tbody/tr[2]/td[1]
		// *[@id="customers"]/tbody/tr[3]/td[1]
		// *[@id="customers"]/tbody/tr[7]/td[1]

		// to print 1st column and all rows
//		String beforeXPath = "//table[@id=\"customers\"]/tbody/tr[";
//		String afterXPath = "]/td[1]";
//		for (int i = 2; i <= getRowCount(); i++) {
//			String xpath = beforeXPath +i+ afterXPath;
//			//System.out.println(xpath);
//			String text = driver.findElement(By.xpath(xpath)).getText();
//			System.out.println(text);
//		}

		// to print the entire table :interview question
		String before_xpath = "//table[@id=\"customers\"]/tbody/tr[";
		String after_xpath = "]/td[";
		for (int col = 1; col <= getCoulmnCount(); col++) {
			for (int row = 2; row < getRowCount(); row++) {
				String xpath = before_xpath + row + after_xpath + col + "]";
				String text = driver.findElement(By.xpath(xpath)).getText();
				System.out.print(text + " ");
			}
			System.out.println();
		}
		// 1.assignment-to traverse all the table
		 getEntireTable();

		// 2.assignment
		findvalue("Contact", "Maria Anders");
		findvalue("Country", "India");
	}

	// assginment
	
	public static void findvalue(String colName, String name) {
		//List<String> valList = new ArrayList<String>();
		List<WebElement> list = driver.findElements(
				By.xpath("//table[@id='customers']//th[text()='" + colName + "']//..//following-sibling::tr"));
		System.out.println(list.size());
		// for(WebElement e:list) {
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			System.out.println(text);
			//valList.add(text);
			if (text.contains(name)) {
				System.out.println("Found " + name);
				flag = true;
				break;
			}

		}
		if(flag==false) {
			System.out.println("Not found...");
		}
		// return valList;

	}

	// Assignment=traverse the entire table
	public static void getEntireTable() {
		// List<String> finalList=new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath("(//table[@id='customers'])//tr//td"));
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			// finalList.add(text);
			System.out.println(text);
		}

	}

	public static int getCoulmnCount() {
		return driver.findElements(By.xpath("(//table[@id='customers'])//tr[1]/th")).size();
	}

	public static int getRowCount() {
		// return driver.findElements(By
		// .xpath("//table[@id='customers']//tr")).size()-1=>v dont
		// want header in the row count
		// this is for before and after xpath for loop
		return driver.findElements(By.xpath("//table[@id='customers']//tr")).size();

	}

	public static String getCompanyName(String name) {
		return driver.findElement(By.xpath("//td[text()='" + name + "']/preceding-sibling::td")).getText();

	}

	public static String getCountryName(String name) {
		return driver.findElement(By.xpath("//td[text()='" + name + "']/following-sibling::td")).getText();

	}

}
