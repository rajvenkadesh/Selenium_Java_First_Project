package in.amazon;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonDemo {

	static BrowserActivities chromeBrowser;
	public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {

		System.out.println("Welcome to Amazon Webpage Automation: ");
		System.out.println("------------------------------------- ");

		chromeBrowser = new BrowserActivities();
		// 1. Open the chrome browser
		chromeBrowser.openBrowser();
		// 2. Open the www.amazon.in website
		chromeBrowser.openWebPage("https://www.amazon.in");
		// 3. Maximize the webpage
		chromeBrowser.maximizePage();
		// get page title
		chromeBrowser.displayPageTitle();
		// search for Apple ipad
		//chromeBrowser.takeScreenshot();
	
		connectDB();
		
		chromeBrowser.selectSearchDropDown("Electronics");
		
		chromeBrowser.search("Apple Ipad");
		chromeBrowser.displayPageTitle();
		chromeBrowser.takeScreenshot();
		chromeBrowser.clickLinkText("Partial Link Text", "2020 Apple iPad");
		//chromeBrowser.takeScreenshot();
		// 4. wait for some time
		chromeBrowser.waitFor(3);
		// 5.close the browser
		chromeBrowser.closeBrowser();
	}

	private static void connectDB() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String dbUrl = "jdbc:mysql://localhost:3306/amazon";
		String username = "root";
		String password = "root";
		String query = "select * from menu;";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			//System.out.println(rs.getString("name"));
			chromeBrowser.checkLinkExists(rs.getString("name"));
		}
		
	}
	

}












