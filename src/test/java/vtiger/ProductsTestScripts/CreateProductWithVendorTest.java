package vtiger.ProductsTestScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

public class CreateProductWithVendorTest {
	@Test
	public void createProductWithVendor() throws IOException {
		WebDriver driver=null;
		
		//Create object of Generic Utilities
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//Read all the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSSWORD = pUtil.readDataFromPropertyFile("password");
		
		String PRODUCTNAME = eUtil.readDataFromExcel("Product", 1, 0);
		String VENDORNAME = eUtil.readDataFromExcel("Vendor", 1, 0);
	}

}
