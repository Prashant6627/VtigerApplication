package vtiger.ContactsTestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreatingNewContactPage;
import vtiger.ObjectRepository.CreatingNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtility.ListenersImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass{
	@Test
	public void createContactWithOrganizationTest() throws IOException {
		
		//Step 1 : Read all the required data		
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2)+jUtil.getRandomNumber();
		
		//Step 2 : Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		Reporter.log("===== Organization Link Clicked =====");
		
		//Step 6 : Click on Organizations look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		Reporter.log("===== Organization Lookup Image Clicked =====");
		
		//Step 7 : Create new Organization with mandatory fields and save
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createNewOrg(ORGNAME);
		Reporter.log("===== Organization Created - "+ORGNAME+" =====");
		
		//Step 8 : Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		
		//Step 9 : Click on Contacts link
		hp.clickOnContactsLink();
		Reporter.log("===== Contact Link Clicked =====");
		
		//Step 10 : Click on Create Contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateNewContactImg();
		Reporter.log("===== Contact Lookup Image Clicked =====");
		
		//Step 11 : Create new Contact
		CreatingNewContactPage cnc = new CreatingNewContactPage(driver);
		cnc.createNewContact(LASTNAME, ORGNAME, driver);
		Reporter.log("===== Contact Created - "+LASTNAME+" =====");
		
		//Step 12 : Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		Assert.assertTrue(contactHeader.contains(LASTNAME));	
	}

}
