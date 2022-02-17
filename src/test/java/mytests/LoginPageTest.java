package mytests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {
	
	@DataProvider
	public Object[][] loginTestData() {
		return new Object[][] {
			{"admin@gmail.com","admin123"},
			{"cust@gmail.com","cust123"},
			{"vendorgmail.com","vendor123"},
			{"vendor@gmail.com","@#$@#$"},
			{"@#$%$","vendor123"},
			{"",""},
			{null,null}
		};
	}
	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String userName,String password) {
		Assert.assertTrue(doLogin(userName,password));
	}
//	@Test
//	public void loginTest1() {
//		Assert.assertTrue(doLogin("cust@gmail.com", "cust123")); //this way v have to write multiple tcs  
//	}
	public boolean doLogin(String userName,String password) {
		System.out.println("UserName :"+userName);
		System.out.println("Password :"+password);
		System.out.println("Loging successful");
		return true;
	}
}
