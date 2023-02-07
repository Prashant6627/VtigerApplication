package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheet {
	@Test
	public void readExcelData() throws EncryptedDocumentException, IOException {
		//Step-1 : Load the file into FileInputStream - Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2 : Create Workbook using workbook factory
		Workbook wb = WorkbookFactory.create(fis);
//(returns Workbook) (Abstract class) (static overloaded method)
		
		//Step 3 : Navigate to the required sheet
		Sheet sh = wb.getSheet("Organizations");
//(returns Sheet)     static method
		
		//Step 4 : Navigate to the required row
		Row row = sh.getRow(10);
//(returns Row)      static method
		
		//Step 5 : Navigate to the required cell
		Cell cell = row.getCell(1);
//(returns Cell)        static method
		
		//Step 6 : Read the respective cell value
		String value = cell.getStringCellValue();
//(returns String)          static method
		
		Reporter.log(value,true);
	}
	
}
