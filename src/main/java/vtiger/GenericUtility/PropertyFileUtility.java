package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains generic methods related to Property File
 * * @author Prashant
 *
 */
public class PropertyFileUtility {
	/**
	 * This method will read the data from the Property File and return the value
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		
		//Step-1 : Read the file in Java readable format using FileInputStream
		FileInputStream fis = new FileInputStream(IConstantsUtility.PropertyFilePath);
		
		//Step-2 : Create object of Properties class from java.util package
		Properties pObj=new Properties();
		
		//Step-3 : Load the FileInputStream to Properties object
		pObj.load(fis);
		
		//Step-4 : Provide the key and read the value
		String value = pObj.getProperty(key);
		
		return value;
	}
}
