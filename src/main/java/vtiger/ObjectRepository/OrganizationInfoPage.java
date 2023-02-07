package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	//Initialization
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	//Business Library
	/**
	 * This method will capture the header text for organization and return it to caller
	 * @return
	 */
	public String getOrgHeader() {
		return orgHeaderText.getText();
	}
}
