package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String readDataFromExcel(String a, int b, int c) throws IOException {
		
		Random r = new Random();// random class is used to handle the duplicate values
		int random = r.nextInt(1000);

		FileInputStream fi = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fi);
		String value = wb.getSheet(a).getRow(b).getCell(c).getStringCellValue()+random;
		wb.close();
		return value;
	}
	
	
	public int getRowCount(String sheet) throws IOException {
		FileInputStream fi = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh =wb.getSheet(sheet);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;
		
	}
	public void writeDataIntoExcel(String sheet, int row, int cel, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Row rw = wb.getSheet(sheet).getRow(row);
		rw.createCell(cel).setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantsUtility.ExcelFilePath);
		wb.write(fos);
		System.out.println(value+" --> data added");
		wb.close();
	}
	public Object[][] readfromDataprovider(String Sheetname) throws IOException {
		FileInputStream fi = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(Sheetname);
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRow][lastCel];  
		for(int i =0;i<lastRow;i++) 
		{
			for(int j =0;j<lastCel;j++) {
				data[i][j]= sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
