package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws Throwable {
		
		 Driver driverRef = new Driver();
		 
		 //Step 1 Register the db
		 DriverManager.registerDriver(driverRef);
		 
		 //Step 2 Get the Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Orgnizationdb", "root", "root");
		 
		 //Step 3 Issue Create Statement
		 Statement state = con.createStatement();
		 
		 // Step 4 Execute a Query
		 ResultSet result = state.executeQuery("select * from orginfo");
		 while (result.next())
		 {
			 System.out.println(result.getString(1)+result.getInt(2) +result.getString(3));
		 }
		 
		 // Step 5 Close DB
		 con.close();
	}

}
