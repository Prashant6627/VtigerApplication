package vtiger.OrganizationsTestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
/**
 * 
 * @author Prashant
 *
 */
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreatingNewContactPage;
import vtiger.ObjectRepository.CreatingNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtility.ListenersImplementationClass.class)
public class CreateMultipleOrganizationsWithIndustryType extends BaseClass{	
	
	@Test(dataProvider="OrgData")
	public void createMultipleOrgTest(String ORG, String INDUSTRY) throws IOException {
		
		String ORGNAME = ORG+jUtil.getRandomNumber();
		
		//Navigate to Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		
		//Navigate to create org look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		
		//Create new organization with industry type
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createNewOrg(ORGNAME, INDUSTRY);
		
		//Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		System.out.println(orgHeader);
		Assert.assertTrue(orgHeader.contains(ORGNAME));
	}
	@DataProvider(name="OrgData")
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		Object[][] data = eUtil.readMultipleDataFromExcel("MultipleOrg");
		return data;
	}
	
}
