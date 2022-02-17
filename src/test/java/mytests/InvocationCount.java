package mytests;

import org.testng.annotations.Test;

public class InvocationCount {
	@Test(invocationCount = 10)
	public void getUserTest() {
		System.out.println("get user");  // if u want to run a test for n number times
		
	}

}
