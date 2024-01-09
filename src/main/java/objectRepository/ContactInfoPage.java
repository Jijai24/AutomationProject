package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	public ContactInfoPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getContactHeaderText () {
		return ContactHeaderText;
		
	}
	
	//Business Library
	/**
	 * This method will Capture the Header Text and return it to Caller
	 * @return
	 */
	public String captureHeaderText()
	{
		return ContactHeaderText.getText();
	}
}
