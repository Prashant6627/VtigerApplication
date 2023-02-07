package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WriteDataIntoExcelSheet {
	@Test
	public void writeDataIntoExcelSheet() throws EncryptedDocumentException, IOException {
		//Step-1 : Load the file into FileInputStream - Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step-2 : Create a Workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step-3 : Navigate to the required Sheet
		Sheet sheet = wb.getSheet("Organizations");
		
		//Step-4 : Navigate to the required Row
		Row row = sheet.getRow(4);
		
		//Step-5 : Navigate to the required Cell
		Cell cell = row.createCell(6);
		
		//Step-6 : Write the value in respective cell
		cell.setCellValue("Qspiders");
		
		//Step-7 : Write the data into the file using FileOutputStream
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		
		Reporter.log("Data is Added",true);
		
		
		
	}

}
