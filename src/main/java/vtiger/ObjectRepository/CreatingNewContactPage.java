package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility{
	//Declaration
	@FindBy(name="lastname")
	private WebElement contactNameEdt;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img[@title='Select']")
	private WebElement orgLookUpImg;
	
	@FindBy(id="search_txt")
	private WebElement searchBoxEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	//Initialization
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getContactNameEdt() {
		return contactNameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//Business Library
	/**
	 * This method will create new contact using last name and save
	 * @param lastName
	 */
	public void createNewContact(String lastName) {
		contactNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	/**
	 * This method will create new contact with last name and lead source drop down and save
	 * @param lastName
	 * @param leadSourceType
	 */
	public void createNewContact(String lastName,String leadSourceType) {
		contactNameEdt.sendKeys(lastName);
		handleDropDown(leadSourceType, leadSourceDropDown);
		saveBtn.click();
	}
	/**
	 * This method will create contact with last name and organization name
	 * @param lastName
	 * @param orgName
	 * @param driver
	 */
	public void createNewContact(String lastName, String orgName, WebDriver driver) {
		contactNameEdt.sendKeys(lastName);
		orgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		searchBoxEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
}
