package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	@Test
	public void sampleJDBC() throws SQLException {
		Driver driverRef = new Driver();  //This is MySQL driver
		Connection con=null;
		try {
		
		//Step 1 : Register to the Driver/Database
		DriverManager.registerDriver(driverRef);
		
		//Step 2 : Get the connection with Database - use Database name
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1db","root","Pp@2020");
		
		//Step 3 : Issue create statement
		Statement statement = con.createStatement();
		
		//Step 4 : Update the query - use Table name
		String query = "insert into candidateinfo values('Pihu',10,'Ahmedabad')";
		int result = statement.executeUpdate(query);
		if(result==1) {
			System.out.println("Data is inserted");
		}
		else {
			System.out.println("Data is not inserted");
		}
		ResultSet r = statement.executeQuery("select * from candidateinfo;");
		while(r.next()) {
			System.out.println(r.getString(1)+" "+r.getString(2)+" "+r.getString(3));
		}
		}
		catch(Exception e) {
			//Handle Exception
		}
		finally {
			//Step 5 : Close the Database
			con.close();
			System.out.println("Database is closed");
		}
	}

}
