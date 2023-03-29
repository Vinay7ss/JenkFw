package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class executequerymethod {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		// creating object for driver. Its driver for mysql database
		Driver driveRef = new Driver();
		
		// Register the driver
		DriverManager.registerDriver(driveRef);
		
		// get the connection from database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
		// issue create statement
		Statement state = con.createStatement();
		
		// execute query
		ResultSet result = state.executeQuery("select * from candidateinfo;");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+ result.getInt(2)+" "+result.getString(3));
			
		}
		// close database
		con.close();
		System.out.println("DB closed");
		

	}

}
