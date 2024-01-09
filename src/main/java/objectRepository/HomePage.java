package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility {
	
	//Declaration - WebElements - DropDowns, Windows,Frames, MouseHouvering
	
	@FindBy (linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy (linkText = "Products")
	private WebElement productLnk;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy (linkText = "Sign Out")
	private WebElement signoutLnk;
	
	//Initialization
	public HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductLnk() {
		return productLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
	//Business Library
	/**
	 * This method will Click on Contacts Link
	 */
	 public void clickOnContactsLink() 
	 {
		contactsLnk.click(); 
	 }
	
	 //Business Library
	/**
	 * This method will perform sign-out operation
	 * @param driver
	 * @throws Throwable
	 */
	public void logoutOfApp (WebDriver driver) throws Throwable
	{
		mouseAction(driver, administratorImg);
		Thread.sleep(1000);
		signoutLnk.click();
	}
	
}