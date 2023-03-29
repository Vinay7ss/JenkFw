package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class executeupdatemethod {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		// creating object for driver. Its driver for mysql database
				Connection con = null;
				try {
				Driver driveRef = new Driver();
				
				// Register the driver
				DriverManager.registerDriver(driveRef);
				
				// get the connection from database
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
				
				// issue create statement
				Statement state = con.createStatement();
				
				// execute query
				String query = "insert into candidateinfo values('kkk',90,'lahote');";// sql command within double quotes
				int result = state.executeUpdate(query);
				if(result>=1)
				{
					System.out.println("Data added");
				}
				ResultSet resul = state.executeQuery("select * from candidateinfo;");
				while(resul.next())
				{
					System.out.println(resul.getString(1)+" "+ resul.getInt(2)+" "+resul.getString(3));
					
				}
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				finally {
					// close database
					con.close();
					System.out.println("DB closed");
				}
				
				
				

	}

}
