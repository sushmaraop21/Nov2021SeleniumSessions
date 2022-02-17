package AppTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHrmTest extends BaseTest{
	
	

	@Test(priority = 1)
	public void logoTest() {
	//	driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		Assert.assertTrue(driver.findElement(By.className("nav-logo")).isDisplayed());
		// Assert.assertTrue(flag);//Asserts that a condition is true. If it isn't,an
		// AssertionError is thrown.
	}

	@Test(priority = 2)
	public void contactSalesLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("CONTACT SALES")).isDisplayed());
	}

	@Test(priority = 4)
	public void getTitle() {
		String title = driver.getTitle();
		System.out.println("Page title : " + title);
		Assert.assertEquals(title, "Sign Up for a Free HR Software Trial | OrangeHRM");
	}

	@Test(priority = 3)
	public void headerTest() {
		String header = driver.findElement(By.cssSelector("div.try-it-text h1")).getText();
		Assert.assertTrue(header.contains("free trial"));
	}


}
