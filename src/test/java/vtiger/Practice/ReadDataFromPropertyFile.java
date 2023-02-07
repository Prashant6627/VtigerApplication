package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReadDataFromPropertyFile {
	@Test
	public void readPropertyFileData() throws IOException {
		//Step-1 : Load the file into FileInputStream - Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//Step-2 : Create object of Properties class from java.util package
		Properties pObj = new Properties();
		
		//Step-3 : Load the FileInputStream to Properties object
		pObj.load(fis);
		
		//Step-4 : Provide the key and read the value
		String BROWSER = pObj.getProperty("browser");
		Reporter.log(BROWSER,true);
		
		String URL = pObj.getProperty("url");
		Reporter.log(URL,true);
		
		String USERNAME = pObj.getProperty("username");
		Reporter.log(USERNAME,true);
		
		String PASSWORD = pObj.getProperty("password");
		Reporter.log(PASSWORD,true);
	}

}
