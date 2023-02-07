package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	//Auto healing Process (@FindAll)
	@FindAll({@FindBy(linkText="Sign Out"),@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")})
	private WebElement signOutLink;
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
		
	//Business Library
	/**
	 * This method will perform sign out operation
	 * @param driver
	 */
	public void signOutOfApp(WebDriver driver) {
		mouseHover(driver, administratorImg);
		signOutLink.click();
	}
	/**
	 * This method will click on Organizations Link
	 */
	public void clickOnOrgLink() {
		organizationsLink.click();
	}
	/**
	 * This method will click on Contacts Link
	 */
	public void clickOnContactsLink() {
		contactsLink.click();
	}
}
