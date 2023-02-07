package vtiger.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This class contains basic configuration annotations for common functionalities like
 * connection to database, launch the browser etc
 * @author Prashant
 *
 */
public class BaseClass {
	public DatabaseUtility dUtil = new DatabaseUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver;  //This is used for taking Screenshots in Listeners
	
	@BeforeSuite
	public void bsConfig() throws SQLException {
		dUtil.connectToDatabase();
		Reporter.log("--Database Connection Successful--",true);		
	}
	@BeforeClass
	public void bcConfig() throws IOException {
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("CHROME")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			sdriver = driver;  //This is used for taking Screenshots in Listeners
			Reporter.log("--Browser "+BROWSER+" Launched Successfully",true);
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			sdriver = driver;  //This is used for taking Screenshots in Listeners
			Reporter.log("--Browser "+BROWSER+" Launched Successfully",true);
		}
		else {
			System.out.println("Invalid Browser");
		}
		wUtil.maximiseWindow(driver);
		wUtil.waitForDOMToLoad(driver, 25);
		driver.get(URL);
	}
	@BeforeMethod
	public void bmConfig() throws IOException {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("--Login Successful--",true);
	}
	@AfterMethod
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("--Signout Successful--",true);
	}
	@AfterClass
	public void acConfig() {
		driver.quit();
		Reporter.log("--Browser Closed Successfully--",true);
	}
	@AfterSuite
	public void asConfig() throws SQLException {
		dUtil.closeDatabase();
		Reporter.log("--Database Closed Successfully--",true);
	}
	
	
	

}
