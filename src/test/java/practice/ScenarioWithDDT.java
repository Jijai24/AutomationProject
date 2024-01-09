package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import objectRepository.LoginPage;



public class ScenarioWithDDT {

	public static void main(String[] args) throws Throwable {
	
		//Read Common Data from Properties File
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		String URL = pro.getProperty("url");
	      String USERNAME = pro.getProperty("username");
	      String PASSWORD = pro.getProperty("password");
	      
	      //Read Data From Excel File
	      FileInputStream fes = new FileInputStream(".\\src\\test\\resources\\Contacts.xlsx");
	      Workbook book = WorkbookFactory.create(fes);
	     String LASTNAME = book.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		
	     //step 1 Launch the Browser
	     WebDriver driver= new ChromeDriver();
	     
	     //step 2 Load the Application
	     driver.get(URL);
	     
	     //step 3 Login the Application
	 /*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	 	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	 	driver.findElement(By.id("submitButton")).click();     */
	     
	     LoginPage lp= new LoginPage(driver);
	     lp.loginToApp(USERNAME, PASSWORD);
	     
	 /*  lp.getUsernameEdt().sendKeys(USERNAME);
	     lp.getPasswordEdt().sendKeys(PASSWORD);
	     lp.getLoginBtn().click();       */
	     
	  
	 	
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
		Actions act = new Actions(driver);
		act.moveToElement(el).perform();
		Thread.sleep(2000);
		
	driver.findElement(By.linkText("Sign Out")).click();
	
	//step 10 Close the Browser
	driver.quit();
		}
	}


