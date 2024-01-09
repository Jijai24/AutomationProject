package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class consists of reusable methods related to Excel Data
 * @author Jija
 */
public class ExcelDataUtility {
	/**
	 * This Method will read data from given excel file and return the value to caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return value
	 * @throws Throwable
	 */
	
	public String readDataFromExcel(String sheetName ,int rowNo, int cellNo) throws Throwable {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Contacts.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
}