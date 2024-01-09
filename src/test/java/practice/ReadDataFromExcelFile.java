package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws Throwable {
	
	  //Step 1 Open the document in Java Readable Format
		FileInputStream fes = new FileInputStream(".\\src\\test\\resources\\Contacts.xlsx");
		
	//Step 2 Create a Workbook
	Workbook book = WorkbookFactory.create(fes);
	
	//Step 3 Navigate to required Sheet
	Sheet sheet = book.getSheet("Sheet1");
		
	//Step 4 Navigate to required Row
	Row row = sheet.getRow(4);
	
	//step 5 Navigate to required Cell
	Cell cel = row.getCell(3);
	
	//step 6 Capture the Data inside the Cell
	String ExcelData = cel.getStringCellValue();
	System.out.println(ExcelData);
	
	//step 7 Close the Workbook
	book.close();
		}
}
