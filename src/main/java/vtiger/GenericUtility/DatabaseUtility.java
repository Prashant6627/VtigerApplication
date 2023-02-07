package vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * This class contains all the generic methods related to Database
 * @author Prashant
 *
 */
public class DatabaseUtility {
	Driver driverRef;
	Connection con=null;
	/**
	 * This method will establish the connection with Database
	 * @throws SQLException
	 */
	public void connectToDatabase() throws SQLException {
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IConstantsUtility.DatabaseUrl,IConstantsUtility.DatabaseUsername,IConstantsUtility.DatabasePassword);
		
	}
	/**
	 * This method will execute the query and verify the expected data in the database 
	 * and return the data only if expected data and actual data are matching 
	 * else it will return an empty String
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryVerifyDataAndReturn(String query, int columnIndex, String expData) throws SQLException {
		//Execute a Query
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next()) {
			String actData = result.getString(columnIndex);
			
		//Verify the expected data with actual data from the database
			if(actData.equals(expData)) {
				flag = true; //flag raising
				break;
			}
		}
		//Return if expected data and actual data is matching
		if(flag) {
			System.out.println("Data Verified");
			return expData;
		}
		else {
			System.out.println("Data not Verified");
			return "";
		}
	}
	/**
	 * This method will close the Database connection
	 * @throws SQLException
	 */
	public void closeDatabase() throws SQLException {
		con.close();
	}

}
