package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelectorsConcept {

	public static void main(String[] args) {
	
		//{id}-->#id or tag#id
		//class-->.class
		//#input-email
		//input#input-email
		// .form-control (.class)
	//	input#input-email (tag#id)
	
		By.cssSelector("input#input-email"); // this can b ("#input-email"); as well
		By.cssSelector("input.form-control"); //class
		By.cssSelector("input#input-email.form-control"); //attr and class
		By.cssSelector("input.form-control#input-email");//reverse of above		
		By.cssSelector(".form-control#input-email");// this s also correct=>no need to write to tag before the class
		
		By.cssSelector("input[type='submit']"); //for button when u dont have id and class
		By.xpath("//input[@type='submit']"); //xpath
		
		By.cssSelector("input[type='submit'][value='Login']");//no and keyword so[] []
		
		//form-control private-form__control login-email // multiple classes
		//form-control private-form__control login-password m-bottom-3 - for pwd - 4 classes
		By.cssSelector(".form-control.private-form__control.login-email");
		By.cssSelector("input.form-control.private-form__control.login-email");
		By.cssSelector("input.form-control.private-form__control.login-email#username");
		
		By.cssSelector("input.form-control.private-form__control.login-email");//correct
		By.className(".form-control.private-form__control.login-email");//not correct=>classname cant have multiple classes
		By.xpath("//input[@class='form-control private-form__control login-email']"); //xpath - correct
		
		//contains- * acts like contains
		By.cssSelector("input[id*='email']");
		By.cssSelector("input[id^='input']"); // ^ acts like starts-with
		By.cssSelector("input[id$='email']");// $ acts like ends-with
		
		//to parent
		By.cssSelector("div.form-group");
		//Parent to child
		By.cssSelector("div.form-group>label");//only direct child - 1
		By.cssSelector("div.form-group>input#input-email");// parent and child
		By.cssSelector("div#content div");// indirect child-( direct+indirect) childs- give space -7
		
		//child to parent- not applicable-back traversing not possible
		
		//sibling - only following subling is allowed
		By.cssSelector("div.form-group label+input");// '+' - following sibling
		//indexing
		By.cssSelector("ul.footer-nav li:nth-of-type(2)");
		

		
		
	}

}
