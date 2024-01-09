package practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelDataUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class ScenarioWithDDtAndUtils {

	public static void main(String[] args) throws Throwable {
		//Create Object of Required Utility Class
		PropertyFileUtility pUtil= new PropertyFileUtility();
		ExcelDataUtility eUtil= new ExcelDataUtility();
		SeleniumUtility sUtil= new SeleniumUtility();
		
		//Read Common Data from Property file
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//Read Test Data  From Excel File
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);

		//step 1 Launch the Browser
	     WebDriver driver= new ChromeDriver();
	     sUtil.maximizeWindow(driver);
	     sUtil.addimplictlyWait(driver);
	     
	     //step 2 Load the Application
	     driver.get(URL);
	     
	     //step 3 Login the Application
	 	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	 	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	 	driver.findElement(By.id("submitButton")).click(); 
	 	
	 	
	 	//step 4 Click on Contacts Link
	 	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	 	
	 	//step 5 Click on Create Contact Look Image
	 	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	 	
	 	//step 6 Create New Contact
        driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
        
        //step 7 Save
		driver.findElement(By.name("button")).click();
		
		//step 8 Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (contactHeader.contains(LASTNAME)) {
			 System.out.println(contactHeader);
		    	 System.out.println("PASS");
		     }
		     else
		     {
		    	 System.out.println("FAIL");
		     }
		
		//step 9 Logout of Application
		WebElement el = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		sUtil.mouseAction(driver, el);
		Thread.sleep(2000);
		
    	driver.findElement(By.linkText("Sign Out")).click();
	
	//step 10 Close the Browser
	driver.quit();
		}
		
}

