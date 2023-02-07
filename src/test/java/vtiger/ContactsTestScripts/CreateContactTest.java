package vtiger.ContactsTestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
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

public class CreateContactTest {
	@Test
	public void createContactTest() throws IOException {
		WebDriver driver = null;
		//Step 1 : Create object for all the utilities
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//Step 2 : Read all the necessary data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2)+jUtil.getRandomNumber();
		String LEADSOURCE = eUtil.readDataFromExcel("Contacts", 4, 3);
		
		//Step 3 : Launch the browser     Run time Polymorphism
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Invalid browsr name");
		}
		wUtil.maximiseWindow(driver);
		wUtil.waitForDOMToLoad(driver, 25);
		driver.get(URL);
		
		//Step 4 : Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5 : Navigate to Contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Step 6 : Click on create contact
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		//Step 7 : Create new contact with mandatory information and save
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		WebElement lead = driver.findElement(By.name("leadsource"));
		wUtil.handleDropDown(LEADSOURCE, lead);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		//Step 8 : Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains(LASTNAME))
			{
				System.out.println(contactHeader);
				System.out.println("PASS");
			}
			else {
				System.out.println("FAIL");
			}
		
		//Step 9 : Logout
		WebElement user = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		wUtil.mouseHover(driver, user);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}
	
	
}
