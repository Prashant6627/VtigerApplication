package vtiger.ContactsTestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import vtiger.ObjectRepository.CreatingNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrgTest {
	@Test
	public void createContactWithOrgTest() throws IOException {
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
		
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		
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
		
		//Navigate to Organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		
		//Navigate to create Org image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		
		//Create Organization with mandatory fields
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createNewOrg(ORGNAME);
		
		//Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		if(orgHeader.contains(ORGNAME)) {
			System.out.println("Organization Created");
		}
		else {
			System.out.println("Organization Not Created");
		}
		
		//Navigate to contact link
		hp.clickOnContactsLink();
		
		//Navigate to create contact image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateNewContactImg();
		
		//Create contact with Org details
		CreatingNewContactPage cnc = new CreatingNewContactPage(driver);
		cnc.createNewContact(LASTNAME, ORGNAME, driver);
		
		//Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if(contactHeader.contains(LASTNAME)) {
			System.out.println("Contact Created");
		}
		else {
			System.out.println("Contact Not Created");
		}
		
		//Logout Application
		hp.signOutOfApp(driver);
		driver.quit();
	}
}