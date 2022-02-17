package mytests;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {

	@Test
	public void loginTest() {
		System.out.println("login test...");
		int i=9/0;
	}
	@Test(dependsOnMethods = "loginTest")
	public void homeTest() {
		System.out.println("home test...");
	}
	@Test(dependsOnMethods = "loginTest")
	public void searchTest() {
		System.out.println("search test...");
	}
	//test should be independent
	//try to avoid this depends concept
	//try to avoid priority also
	//always define the assertion-act vs expected-validation point
	//crud
	
	//@Test t1
	//create user
	//assert the user id
	
	//@test t2(depends on t1) //always avoid depends on-> if an exception comes in t1 ,t2 never gets exceucted
	//update user
	//1.create user
	//2.take the user id from the new user(userid=3)
	//pick the same user from the new user
	//delete the userid=3
	//check the user is deleted(assertion)

	
	
}
	