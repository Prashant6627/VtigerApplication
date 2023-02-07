package vtiger.Practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	@Test
	public void sampleJDBC() throws SQLException {
		Driver driverRef = new Driver();  //This is MySQL driver
		
		//Step 1 : Register to the Driver/Database
		DriverManager.registerDriver(driverRef);
		
		//Step 2 : Get the connection with Database - use Database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1db","root","Pp@2020");
		
		//Step 3 : Issue create statement
		Statement statement = con.createStatement();
		
		//Step 4 : Execute the query - use Table name
		ResultSet result = statement.executeQuery("select * from candidateinfo;");
		
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		
		//Step 5 : Close the Database
		con.close();
	}
	
}
