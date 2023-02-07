package vtiger.ClearOrganizationAndContacts;

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

public class ClearOrganizationsAndContactsTest {
	WebDriver driver=null;
	@Test
	public void clearAllTest() throws IOException {
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		wUtil.maximiseWindow(driver);
		wUtil.waitForDOMToLoad(driver, 25);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.name("selectall")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		wUtil.alertPopupAccept(driver);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.name("selectall")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		wUtil.alertPopupAccept(driver);
		wUtil.mouseHover(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
