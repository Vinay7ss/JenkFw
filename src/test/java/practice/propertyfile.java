package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertyfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// step1 open the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommomData.properties");
		
		// step 2 create object of properties from java.util package
		Properties p = new Properties();
		
		// step 3 load the file input stream into properties
		p.load(fis);
		
		// step 4 access the value with keys
		String URL = p.getProperty("url");// keys are case sensitve
		String Password = p.getProperty("password");// if key is typed wrong then it will not throw any exception but it will print null
		
		System.out.println(URL);
		System.out.println(Password);
		
	
		

	}

}
