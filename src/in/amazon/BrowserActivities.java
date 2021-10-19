package in.amazon;

import java.io.File;
//import java.util.logging.FileHandler;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class BrowserActivities {
	
	WebDriver driver;	
	
	void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "C://Users//venky//workspace//AmazonAutomation//lib//chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Chrome Browser has been opened.");
	}
	
	void openWebPage(String webPage){
		driver.get(webPage);
		System.out.println("Website: " + webPage + " has been Opened.");
	}
	
	void maximizePage(){
		driver.manage().window().maximize();
		System.out.println("The page has been maximized.");
	}
	
	void waitFor(int seconds) throws InterruptedException{
		//Wait for 3 seconds
		System.out.println("We are going for "+ seconds + " seconds wait" );
		
		Thread.sleep(seconds * 1000);
		System.out.println("Waiting is over");
	}
	
	void closeBrowser(){
		//3. close the browser
		driver.quit();
		System.out.println("Browser has been closed.");
	}
	
	void displayPageTitle(){
		System.out.println("The Page Title is: " + driver.getTitle());
	}
	
	void search(String product){
		//search box
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(product);
		
		WebElement searchButton =  driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		System.out.println("Search has been completed");
	}
	
	void clickLinkText(String textType, String text){
		if(textType == "Link")
			driver.findElement(By.linkText(text)).click();
		else if(textType == "Partial Link Text")
			driver.findElement(By.partialLinkText(text)).click();
		else
			System.out.println("Please give proper text type.");
	}
	
	void takeScreenshot() throws IOException{
//		TakesScreenshot scrShot = ((TakesScreenshot)driver);
//		File file = scrShot.getScreenshotAs(OutputType.FILE);
//		File destFile = new File("C://Users//venky//Pictures//ScreenShots//screenshot01.jpg");
//		FileHandler.copy(file, destFile);
		
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File("C:/Users/venky/workspace/AmazonAutomation/screenshots/screen01.png"));
	}
	
	void checkLinkExists(String linkName){
		if(driver.findElement(By.linkText(linkName)).isDisplayed())
			System.out.println(linkName + " Link is Exist.");
		else
			System.out.println(linkName + " Link is not Exist.");
	}
	
	void selectSearchDropDown(String item){
		Select searchDropDown = new Select(driver.findElement(By.name("url")));
		searchDropDown.selectByVisibleText(item);
	}
}





