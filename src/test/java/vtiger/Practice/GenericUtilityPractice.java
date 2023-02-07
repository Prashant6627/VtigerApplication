package vtiger.Practice;

import java.io.IOException;

import org.testng.annotations.Test;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;

public class GenericUtilityPractice {
	@Test
	public void javaUtilityPractice() throws IOException {
		JavaUtility jUtil=new JavaUtility();
		int ra = jUtil.getRandomNumber();
		System.out.println(ra);
		String date = jUtil.getSystemDate();
		System.out.println(date);
		String currentDate = jUtil.getSystemDateInFormat();
		System.out.println(currentDate);
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		System.out.println(BROWSER);
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		int rowCount = eUtil.getRowCount("Organizations");
		System.out.println(rowCount);
		eUtil.writeDataIntoExcel("Organizations",1, 8, "Shruti");
		System.out.println("Data added");
	}

}
