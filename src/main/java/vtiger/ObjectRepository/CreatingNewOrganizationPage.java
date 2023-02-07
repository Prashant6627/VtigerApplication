package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreatingNewOrganizationPage extends WebDriverUtility{
	//Declaration
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	//Initialization
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//Business Library
	/**
	 * This method will create Organization with Organization name and save
	 * @param orgName
	 */
	public void createNewOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	/**
	 * This method will create Organization with industry drop down and save
	 * @param orgName
	 * @param industryType
	 */
	public void createNewOrg(String orgName, String industryType) {
		orgNameEdt.sendKeys(orgName);
		handleDropDown(industryType, industryDropDown);
		saveBtn.click();
	}
	/**
	 * This method will create Organization with industry and type drop downs and save
	 * @param orgName
	 * @param industryType
	 * @param type
	 */
	public void createNewOrg(String orgName, String industryType, String type) {
		orgNameEdt.sendKeys(orgName);
		handleDropDown(industryType, industryDropDown);
		handleDropDown(type, typeDropDown);
		saveBtn.click();
	}

}
    