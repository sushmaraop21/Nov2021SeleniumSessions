package mytests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

	//global pre-condition
	//pre condition
	//test steps+assertions(act vs exp results)
	//post steps
	
	/**
	 * 	Bs---Create User
		BT---Connect with DB
		BC---launchBrowser
			BM---login to the app
			homePageTest
			AM---logout
					BM---login to the app
					priceTest
					AM---logout
			BM---login to the app
			searchTest
			AM---logout
		AC---close Browser
		AT----disconnect With DB
		AS---deleteUser
	 */
	
	//these below 4 r global pre conditions and pre conditions
	@BeforeSuite
	public void createUser() {
		System.out.println("Bs---Create User");
	}
	@BeforeTest
	public void connectWithDB() {
		System.out.println("BT---Connect with DB");
	}
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC---launchBrowser");
	}
	@BeforeMethod
	public void login() {
		System.out.println("BM---login to the app");
	}
	
	//test steps
	
	@Test
	public void homePageTest() {
		System.out.println("homePageTest");
	}
	
	@Test
	public void searchTest() {
		System.out.println("searchTest");
	}
	@Test
	public void priceTest() {
		System.out.println("priceTest");
	}
	//post
	
	@AfterMethod
	public void logOut() {
		System.out.println("AM---logout");
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC---close Browser");
	}
	@AfterTest
	public void disconnectWithDB() {
		System.out.println("AT----disconnect With DB");
	}
	@AfterSuite
	public void deleteUser() {
		System.out.println("AS---deleteUser");
	}
	
	
	
	
}
