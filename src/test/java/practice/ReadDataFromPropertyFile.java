package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		
	//step1 Open the Document in Java Readable Format
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

	//step2 Create Object of Properties Class from Java.Util
	Properties pro = new Properties();
	
	//step3 Load the File Input Stream to Properties File
	pro.load(fis);
	
	//step4 Provide Key & Read the Value
	String value = pro.getProperty("url");
	      String value1 = pro.getProperty("username");
	      String value2 = pro.getProperty("password");
	 System.out.println(value);
   	System.out.println(value1);
	System.out.println(value2);
	
}

}
