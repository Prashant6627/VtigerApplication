package vtiger.OrganizationsTestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreatingNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtility.ListenersImplementationClass.class)
public class CreateNewOrganizationWithIndustryPOM extends BaseClass {
		
	@Test
	public void createNewOrganizationWithIndustryTest() throws IOException {
		
		//Step1 : Read all the required data			
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 4,2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcel("Organizations", 4,3);
		
		//Step-2 : Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
			
		//Step-3 : Click on create organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		
		//Step-4 Create new organization with industry type and save
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createNewOrg(ORGNAME, INDUSTRY);
		
		//Step-5 : Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		System.out.println(orgHeader);
		Assert.assertTrue(orgHeader.contains(ORGNAME));
	}
}
