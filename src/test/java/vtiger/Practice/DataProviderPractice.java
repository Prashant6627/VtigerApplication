package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtility.ExcelFileUtility;

public class DataProviderPractice {
	
	@Test(dataProvider="hardcodes") //Read from Hardcodes
	public void addProductToCartTest(String company, String model,int price, String feature, int quantity) {
		System.out.println(company+"-"+model+"-"+price+"-"+feature+"-"+quantity);
	}
	@Test(dataProvider="excelsheet") //Read from Excel sheet
	public void orgNamesWithIndustryTypesTest(String orgName, String industryType) {
			System.out.println(orgName+"-"+industryType);
	}
	
	
	@DataProvider (name="hardcodes")
	public Object[][] getData(){
		                     //Rows //Columns
		Object[][] d = new Object[4][5];
		
		d[0][0]="Apple";  //Company
		d[0][1]="A10";    //Model
		d[0][2]=25000;    //Price
		d[0][3]="Memory";  //Feature
		d[0][4]=14;       //Quantity
		
		d[1][0]="Vivo";  //Company
		d[1][1]="V23";    //Model
		d[1][2]=12000;    //Price
		d[1][3]="Camera";  //Feature 
		d[1][4]=6;       //Quantity
		
		d[2][0]="Samsung";  //Company
		d[2][1]="S10";    //Model
		d[2][2]=45000;    //Price
		d[2][3]="Look";  //Feature
		d[2][4]=17;       //Quantity
		
		d[3][0]="Sony";  //Company
		d[3][1]="S8";    //Model
		d[3][2]=8000;    //Price
		d[3][3]="Camera";  //Feature
		d[3][4]=2;       //Quantity
		return d;
	}
	@DataProvider(name="excelsheet")
	public Object[][] getData1() throws EncryptedDocumentException, IOException{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		Object[][] data = eUtil.readMultipleDataFromExcel("MultipleOrg");
		return data;
	}
}
