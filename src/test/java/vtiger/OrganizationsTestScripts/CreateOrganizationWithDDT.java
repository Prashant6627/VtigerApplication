package vtiger.OrganizationsTestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;

public class CreateOrganizationWithDDT extends BaseClass{
	@Test
	public void createOrganizationWithDDT() throws IOException {
		WebDriver driver=null;
		
		//Generate random number to avoid duplicate data
		Random r = new Random();
		int RANDOM = r.nextInt(1000);
				
		//Step 1 : Read the necessary Data
		//-----------Property File --> Common Data-----
		FileInputStream fisp = new  FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fisp);
		Object BROWSER = pObj.get("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
				
		//----------Excel Sheet --> Test Data-------
		FileInputStream fise = new  FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sheet = wb.getSheet("Organizations");
		String ORGNAME = sheet.getRow(1).getCell(2).getStringCellValue()+RANDOM;
				
		//Step 2 : Launch the browser ----> Run time Polymorphism
		if(BROWSER.equals("Chrome")) { //Use equalsIgnoreCase() method instead of equals() method
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("-----Chrome Browser launched successfully-----");
			}
		else if(BROWSER.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("-----Firefox Browser launched successfully-----");
			}
		else {
			System.out.println("Browser invalid");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("-----Chrome Browser launched successfully-----");
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		driver.get(URL);
		
		//Step 3 : Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
				
		//Step 4 : Click on Organizations link
		driver.findElement(By.linkText("Organizations")).click();
				
		//Step 5 : Click on Create Organization look up image
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
				
		//Step 6 : Create Organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
		//Step 7 : Save
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		//Step 8 : Validate
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(ORGNAME)) {
			Reporter.log(ORGNAME+" PASS");
		}
		else {
			Reporter.log("FAIL");
		}
		
		//Step 8 : Logout
		WebElement user = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions a = new Actions(driver);
		a.moveToElement(user).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("-----Scenario executed successfully-----");
		
		//Step 9 : Close the Browser
		driver.quit();
	}
}
