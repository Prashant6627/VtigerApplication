package vtiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;

public class POMPractice {
	@Test
	public void pomPractice() {
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		//Login to Application
		LoginPage lp = new LoginPage(driver);
		/*lp.getUserNameEdt().sendKeys("admin");
		lp.getPasswordEdt().sendKeys("admin");
		lp.getLoginBtn().click();*/
		
		lp.loginToApp("admin", "admin");
	}

}
