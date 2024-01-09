package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Rule 1
	
	//Rule 2
	@FindBy (name="user_name")
	private WebElement usernameEdt;
	
	@FindBy (name="user_password")
	private WebElement passwordEdt;
	
    @FindBy (id="submitButton")
	private WebElement loginBtn;

	private CharSequence USERNAME;

	private CharSequence PASSWORD;
    
    //Rule 3 Create a Constructor to Initialize/ Intialization
    public LoginPage (WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
     //Rule 4 Utilization
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Library- Generic Method- Operate on Elements in Current POM Class Only
	/**
	 * This Method will perform Login Operation
	 */
	public void loginToApp (String USERNAME, String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
		
	}

}
