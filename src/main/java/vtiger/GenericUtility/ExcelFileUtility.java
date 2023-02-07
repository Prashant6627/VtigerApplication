package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods related to Excel sheet
 * @author Prashant
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from Excel sheet and return the value
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		wb.close();
		return value;
	}
	/**
	 * This method will provide row count in particular sheet
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		int lastRow = s.getLastRowNum();
		wb.close();
		return lastRow;	
	}
	/**
	 * This method will write data into the Excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, int rownum, int cellnum, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rownum).createCell(cellnum);
		cell.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
	}
	/**
	 * This method is used for a test script with multiple set of data.
	 * Hence it will return 2 dimensional object[][] so that it can be directly used in
	 * dataprovider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data= new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		
	}

}
