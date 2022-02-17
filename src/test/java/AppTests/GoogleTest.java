package AppTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{
	
	@Test(priority = 1)
	public void getTitleTest() {
		//driver.get("https://www.google.com");
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	@Test(priority = 2,enabled = true)
	public void googleSearchTest() {
	driver.findElement(By.name("q")).sendKeys("macbook pro");
	Assert.assertTrue(true);
	}
	
}
