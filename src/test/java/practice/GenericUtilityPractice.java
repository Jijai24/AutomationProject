package practice;

import genericUtilities.ExcelDataUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable {

    PropertyFileUtility putil= new PropertyFileUtility();
    String value = putil.readDataFromPropertyFile("url");
    String value1 = putil.readDataFromPropertyFile("username");
    String value2 = putil.readDataFromPropertyFile("password");
    
    System.out.println(value);
    System.out.println(value1);
    System.out.println(value2);
    
    ExcelDataUtility eutil = new ExcelDataUtility();
    String data = eutil.readDataFromExcel("sheet1", 1, 1);
    System.out.println(data);

    JavaUtility jutil = new JavaUtility();
    System.out.println(jutil.getSystemDate());
	}
}
