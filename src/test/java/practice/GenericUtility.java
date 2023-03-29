package practice;

import java.io.IOException;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtility {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PropertyFileUtility pUtil = new PropertyFileUtility ();
		String value = pUtil.readDataFromPropertyFile("username");
		System.out.println(value);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String value1 = eUtil.readDataFromExcel("Organization", 1,2);
		System.out.println(value1);
		
		System.out.println(eUtil.getRowCount("Organization"));
		
		eUtil.writeDataIntoExcel("Contacts", 1, 6, "Bat");
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDate());
		System.out.println(jUtil.getSystemDateInFormat());
		System.out.println(jUtil.getRandomNumber());
		
		

	}

}
