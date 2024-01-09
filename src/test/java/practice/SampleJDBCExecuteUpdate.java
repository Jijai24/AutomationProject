package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	public static void main(String[] args) throws Throwable {
		
		 Driver driverRef = new Driver();
		 
		 //Step 1 Register the db
		 DriverManager.registerDriver(driverRef);
		 
		 //Step 2 Get the Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Orgnizationdb", "root", "root");
		 
		 //Step 3 Issue Create Statement
		 Statement state = con.createStatement();
		 
		 // Step 4 Execute a Query
		String query = "insert into orginfo values ('Amdocs', 20, 'Banglore')";
		int result = state.executeUpdate(query);
		if (result==1)
		{
			System.out.println("Data is Added");
		}
		 
		 // Step 5 Close DB
		 con.close();
	}

}



