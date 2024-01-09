package contactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.ExcelDataUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContact {
@Test
	public void CreateContactWithMandatoryFields() throws Throwable {
		//Create Object of Required Utility Class
		PropertyFileUtility pUtil= new PropertyFileUtility();
		ExcelDataUtility eUtil= new ExcelDataUtility();
		SeleniumUtility sUtil= new SeleniumUtility();
		
		//Read Common Data from Property file
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//Read Test Data  From Excel File
		String LASTNAME = eUtil.readDataFromExcel("Sheet1", 1, 2);
	

		//step 1 Launch the Browser
	     WebDriver driver= new ChromeDriver();
	     sUtil.maximizeWindow(driver);
	     sUtil.addimplictlyWait(driver);
	     
	     //step 2 Load the Application
	     driver.get(URL);
	     
	     //step 3 Login the Application
	    LoginPage lp= new LoginPage (driver);
	    lp.loginToApp(USERNAME, PASSWORD);
	 	
	 	//step 4 Click on Contacts Link
	    HomePage hp = new HomePage(driver);
	 	hp.clickOnContactsLink();
	 	
	 	//step 5 Click on Create Contact Look Image
	 	ContactsPage cp= new ContactsPage(driver);
	 	cp.clickOnCreateContactLookUpImg();
	 	
	 	//step 6 Create New Contact
       CreateNewContactPage cncp = new CreateNewContactPage(driver);
       cncp.createNewContact(LASTNAME);
        
		//step 7 Validate
		ContactInfoPage cip= new ContactInfoPage(driver);
		String contactHeader = cip.captureHeaderText();
		if (contactHeader.contains(LASTNAME)) {
			 System.out.println(contactHeader);
		    	 System.out.println("PASS");
		     }
		     else
		     {
		    	 System.out.println("FAIL");
		     }
		
		//step 9 Logout of Application
		hp.logoutOfApp(driver);
		
	//step 10 Close the Browser
	driver.quit();
		}
	}


