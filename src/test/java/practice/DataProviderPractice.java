package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.IConstantsUtility;

public class DataProviderPractice {
	
	@Test(dataProvider = "xl" )// can be called by  method name or dataprovider name
	public void dataProviderdemo(String rw, String col) {
		System.out.println(rw+"...."+col);
		//System.out.println(phone);
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2]; // rows and cols
		data[0][0] = "Samsung";
		data[0][1] = 2222;
		
		data[1][0] = "Nokia";
		data[1][1] = 3222;
		
		data[2][0] = "abc";
		data[2][1] = 4222;
		
		return data;
		//can create multiple data providers for same @test but can be called only one dataprovider at a time.
	}@DataProvider (name = "xyz")
	public Object[][] getDat1a() {
		
		Object[][] data = new Object[2][1]; // rows and cols
		data[0][0] = "Samsung";
		
		
		data[1][0] = "Nokia";
		
		
		return data;
	}
	
	@DataProvider (name = "xl")
	public Object[][] getDaa() throws IOException {
	FileInputStream fi = new FileInputStream(IConstantsUtility.ExcelFilePath);
	Workbook wb = WorkbookFactory.create(fi);
	Object[][] data = new Object[1][2]; 
	 data [0][0]= wb.getSheet("DP").getRow(0).getCell(0).getStringCellValue();
	 data [0][1]= wb.getSheet("DP").getRow(0).getCell(1).getStringCellValue();
	 
	
	return data;
	}
	
}
