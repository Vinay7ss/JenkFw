package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritedataExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		// TODO Auto-generated method stub
		
		//step1 open the doc in java readable format
		FileInputStream fi = new FileInputStream(".//src/test/resources/Book1.xlsx");
		
		// step 2 create a workbook
		Workbook workbook1 = WorkbookFactory.create(fi);
		
		// step 3 get control of sheet
		Sheet sh = workbook1.getSheet("Sheet1");
		
		// step4 get control of row
		Row row = sh.getRow(1);
		
		//step 5 create cell in that row
		Cell cel = row.createCell(6);
		
		// step 6 set value to the cell
		cel.setCellValue("tt");
		
		// step 7 open doc in write mode
		FileOutputStream fos = new FileOutputStream(".//src/test/resources/Book1.xlsx");
		
		//step 8 write the data in cell
		
		workbook1.write(fos);
		System.out.println("data added");

	}

}
