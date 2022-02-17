package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterLinkAssignment {

	//static WebDriver driver;
	
	public static void main(String[] args) {
	
		BrowserUtil br=new BrowserUtil();
		WebDriver driver= br.launchBrowser("chrome");
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		System.out.println(br.getPageTitle());

		By name=By.name("firstname");
		By laName=By.name("lastname");
		By emailId=By.id("input-email");
		By teleNum=By.xpath("//*[@id=\"input-telephone\"]");
		By pwd=By.id("input-password");
		By conpwd=By.id("input-confirm");
		By yesRbtn=By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input");
		By noRbtn=By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");
		By chkbx=By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
		By continueBtn=By.cssSelector("#content > form > div > div > input.btn.btn-primary");
		By register=By.xpath("//*[@id=\"content\"]/h1");
		//By reg=By.tagName("h1");
		
		
		ElementUtil el=new ElementUtil(driver);
		el.doSendKeys(name, "sushma");
		el.doSendKeys(laName, "vijay");
		el.doSendKeys(emailId, "sush4@gmail.com");
		el.doSendKeys(teleNum, "9876512345");
		el.doSendKeys(pwd, "sush123");
		el.doSendKeys(conpwd, "sush123");
		el.doClick(yesRbtn);
	//	el.doClick(noRbtn);
		el.doClick(chkbx);
		el.doClick(continueBtn);
		//el.dogetText(register);
		if(el.dogetText(register).contains("Your Account Has Been Created!")) {
			System.out.println("successful");
		}else {
			System.out.println("Unsuccessful");
		}
		

	}

}
