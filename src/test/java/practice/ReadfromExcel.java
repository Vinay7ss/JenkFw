package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadfromExcel {

	public static void main(String[] args) throws Throwable   {
		// TODO Auto-generated method stub
		
		//step1 open the doc in java readable format
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		// step 2 create a workbook
		Workbook workbook1 = WorkbookFactory.create(fi);
		
		// step 3 get control of sheet
		Sheet sh = workbook1.getSheet("Contacts");
		
		// step4 get control of row
		Row row = sh.getRow(4);
		
		//step 5 get control of cell
		Cell cel = row.getCell(1);
		
		// step 6 read the data inside the cell
		
		String value = cel.getStringCellValue();
		System.out.println(value);
		
		

	}

}
