package vtiger.ContactsTestScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreatingNewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * 
 * @author Prashant
 *
 */
public class CreateContactWithMandatoryFieldsTest {
	@Test
	public void createContactWithMandatoryFieldsTest() throws IOException {
		WebDriver driver=null;
		
		//Create object of utilities
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//Read all the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		//Launch Browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("-----Invalid Browser-----");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		wUtil.maximiseWindow(driver);
		wUtil.waitForDOMToLoad(driver, 25);
		driver.get(URL);
		
		//Login to App
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,  PASSWORD);

		//Navigate to contact link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		
		//Navigate to create contact img
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateNewContactImg();
		
		//Create contact with mandatory fields
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.createNewContact(LASTNAME);
		
		//Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if(contactHeader.contains(LASTNAME)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		//Logout Application
		hp.signOutOfApp(driver);
		driver.quit();
	}
}
