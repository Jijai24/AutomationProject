package contactsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelDataUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

@Listeners (genericUtilities.ListenersImplementation.class)
public class CreateContactTest extends BaseClass{
	
	@Test (groups = "SmokeSuite")
	public void cretaeContactWithMandatoryFields() throws Throwable
	{
		//Create Object of Required Utility Classes
	PropertyFileUtility pUtil = new PropertyFileUtility();
	ExcelDataUtility eUtil= new ExcelDataUtility();
	SeleniumUtility sUtil= new SeleniumUtility();
	
	//Read Common Data from Property File 
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
    String PASSWORD = pUtil.readDataFromPropertyFile("password");
    
    //Read Test Data From Excel File 
    String LASTNAME = eUtil.readDataFromExcel("Sheet1", 1, 2);
    
    //Step Click on Contact Link
    HomePage hp = new HomePage(driver);
    hp.clickOnContactsLink();
    
    //Step Click on Create Contact LookUp Image
    ContactsPage cp = new ContactsPage(driver);
    cp.clickOnCreateContactLookUpImg();
    
    //Step Create New Contact
    CreateNewContactPage cncp = new CreateNewContactPage(driver);
    cncp.createNewContact(LASTNAME);
    
    //   Assert.fail();
    //Step Validate
    ContactInfoPage cip = new ContactInfoPage(driver);
    String contactHeader = cip.captureHeaderText();
    Assert.assertTrue(contactHeader.contains(LASTNAME));
    System.out.println(contactHeader);
    
	}

}
