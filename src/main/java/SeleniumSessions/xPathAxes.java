package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xPathAxes {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/india-in-south-africa-2021-22-1277060/south-africa-vs-india-1st-odi-1277082/full-scorecard");
//		System.out.println(getWicketTakerName("Temba Bavuma"));
//		System.out.println(getWicketTakerName("Aiden Markram"));

//		System.out.println(getPlayerScoreCard("Temba Bavuma")); // 7 [110, 143, 200, 8, 0, 76.92]
//		System.out.println(getPlayerScoreCard("Aiden Markram"));
		// 17 [4, 11, 10, 0, 0, 36.36, 6, 0, 30, 1, 5.00, 16, 2, 0, 1, 0]=> it picks
		// from bowlers table as well

		System.out.println(getBattingPlayersScores("Temba Bavuma"));
		System.out.println(getBowlingPlayerScores("Jasprit Bumrah"));
	}

	public static String getWicketTakerName(String playerName) {
		WebElement batsman = driver
				.findElement(By.xpath("//a[text()='" + playerName + "']/parent::td/following-sibling::td/span"));
		return batsman.getText();
	}

	public static List<String> getPlayerScoreCard(String playerName) {
		List<String> actualScoreList = new ArrayList<String>();
		List<WebElement> scoreList = driver
				.findElements(By.xpath("//a[text()='" + playerName + "']/parent::td/following-sibling::td"));
		System.out.println(scoreList.size());
		// but the prblm with this foreach loop is it gives wickettakername as well
		// which is unnecessary
		// for(WebElement e: scoreList) {
		for (int i = 1; i < scoreList.size(); i++) { // here i=1=>v dont wante 1st td=> wicketatkername
			String text = scoreList.get(i).getText();
			actualScoreList.add(text);
		}
		return actualScoreList;
	}

	/**
	 * Assignment - getplayerScoreCard under Batting the xpath has "SOUTH AFRICA
	 * INNINGS (50 OVERS MAXIMUM)" as parent=>so it gives batting score only for
	 * south africa
	 * 
	 * @return this below xpath has parent as batting- this will give u both
	 *         batting(india n south africa )thats y v used xpath(which v used in the method 
	 *         //table[@class='table batsman']//a[text()='" + name + "']/parent::td/following-sibling::td
	 */

	public static List<String> getBattingPlayersScores(String name) {
		List<String> finalList = new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath(
				"//div[@class='Collapsible' ]//div[@class='col']/h5[text()='South Africa INNINGS (50 overs maximum)']//..//..//..//..//..//table[@class='table batsman']//a[text()='"
						+ name + "']/parent::td/following-sibling::td"));

		System.out.println(list.size());
//		for (WebElement e : list) {
//			String text = e.getText();
//			System.out.println(text);
//		}

		for (int i = 1; i < list.size(); i++) { // here i=1=>v r avoiding wicketatkername
			String text = list.get(i).getText();
			finalList.add(text);

		}
		return finalList;

	}

	public static List<String> getBowlingPlayerScores(String name) {
		List<String> finalListBowlers = new ArrayList<String>();
		List<WebElement> listBowlers = driver.findElements(
				By.xpath("//table[@class='table bowler']//a[text()='" + name + "']/parent::td/following-sibling::td"));
//		for (WebElement e : listBowlers) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		//boolean flag = false;
		for (int i = 0; i < listBowlers.size(); i++) {
			String text = listBowlers.get(i).getText();
			finalListBowlers.add(text);
			//flag = true;
		}
//		if (flag == false) {
//			System.out.println("Please enter the right Bowlername");
//
//		}
		return finalListBowlers;

	}
	// table[@class='table batsman']//a[text()='Temba
	// Bavuma']/parent::td/following-sibling::td

	// (//a[text()='Temba Bavuma']//..//..//..//..)//th[text()='BATTING']-- first
	// //table[@class='table batsman']//child::th[text()='BATTING'] -second trial
	// table[@class='table batsman']//a[text()='Temba
	// Bavuma']/parent::td/following-sibling::td
}
