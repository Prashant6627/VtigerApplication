package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//Declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createNewContactLookUpImg;

	//Initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateNewContactLookUpImg() {
		return createNewContactLookUpImg;
	}
	//Business Library
	/**
	 * This method will click on contact look up image
	 */
	public void clickOnCreateNewContactImg() {
		createNewContactLookUpImg.click();
	}
}
