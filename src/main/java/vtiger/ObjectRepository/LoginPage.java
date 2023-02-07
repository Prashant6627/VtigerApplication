package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //Rule 1 : Create a separate class for every page
	
	//Rule 2 : Identify the element s using @FindBy, @FindAll, @FindBys and store it
	//Declaration
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	//Rule 3 : Create a constructor to initialize
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}
	
	//Rule 4 : Provide getters to access the web elements
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Step 5 : Business Library - Generic Methods - for this application
	/**
	 * This method will login to the application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD) {
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}

}
