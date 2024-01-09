package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility {
	
	@FindBy (name= "lastname")
	private WebElement LastNameEdt;
	
	@FindBy (xpath= "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy (name= "leadsource")
	private WebElement leadSourceDropDown;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	
	/**
	 * This method will Create a New Contact and Save It
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
	    SaveBtn.click();
	}
	
	/**
	 * This method will Create a New Contact using Lead Source Drop-Downand Save It
	 * @param LASTNAME
	 * @param LEADSOURCEVALUE
	 */
	public void createNewContact (String LASTNAME, String LEADSOURCEVALUE)
	{
		LastNameEdt.sendKeys(LASTNAME);
		handleDropDown1(leadSourceDropDown, LEADSOURCEVALUE);
	    SaveBtn.click();
	}
	

}
