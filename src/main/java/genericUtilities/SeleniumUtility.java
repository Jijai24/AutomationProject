package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of reusable methods related to Selenium Tool
 * @author Jija
 */

public class SeleniumUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */

	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 *  This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow (WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 *  This method will launch the browser in full screen mode
	 * @param driver
	 */
	public void fullScreenWindow (WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	/**
	 * This method will wait for 10 seconds for all the web elements to Load
	 * @param driver
	 */
	
	public void addimplictlyWait (WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for a particular web element to become Visible
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeVisible(WebDriver driver, WebElement element)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	/**
	 *  This method will wait for 10 seconds for a particular web element to be Clicked
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeClickable(WebDriver driver, WebElement element)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 *  This method will wait for 10 seconds for a particular web element to be Clicked
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeSelected(WebDriver driver, WebElement element)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	/**
	 * This method will handle DropDown By Index
	 * @param element
	 * @param lEADSOURCEVALUE
	 * @param value
	 * @param value1
	 */
	public void handleDropDown (WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);		
	}
	
	/**
	 * This method will handle DropDown By Value
	 * @param element
	 * @param value
	 */
	public void handleDropDown1 (WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
		}
	
	/**
	 * This method will handle DropDown By Visible Text
	 * @param text
	 * @param element
	 */
	public void handleDropDown (String text,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse Hovering action on a Web Element
	 * @param driver
	 * @param element
	 */
	public void mouseAction (WebDriver driver, WebElement element)
	{
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform double click action on a Web Element
	 * @param element
	 * @param driver
	 */
	public void doubleClickAction ( WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform right click action on a Web Element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction ( WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param srcele
	 * @param dstele
	 */
	public void dragAndDropAction (WebDriver driver, WebElement srcele, WebElement dstele)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcele, dstele);	
	}
	
	/**
	 * This method will scroll down for 500 units 
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,500);", "");
	}
	
	/**
	 * This method will scroll up for 500 units 
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,-500);", "");
	}
	
	/**
	 * This method will accept the Alert Popup
	 * @param driver
	 */
	public void acceptAlert (WebDriver driver)
    
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the Alert Popup
	 * @param driver
	 */
	public void cancelAlert (WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will capture the text in Alert Popup and return it to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText (WebDriver driver)
	{
	return	driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle Frame by Frame Index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame (WebDriver driver ,int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This method will handle Frame by Frame Name or ID
	 * @param driver
	 * @param frameNameID
	 */
	public void handleFrame (WebDriver driver, String frameNameID)
	{
		driver.switchTo().frame(frameNameID);
	}
	
	/**
	 * This method will handle Frame by Frame Element
	 * @param driver
	 * @param frameNameID
	 */
	public void handleFrame (WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method will capture the ScreenShot and return the path to caller
	 * @param driver
	 * @param screenShotname
	 * @return
	 * @throws Throwable
	 */
	public String captureScreenShot (WebDriver driver, String screenShotname) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE); //temporary location
		File dst = new File(".\\Screenshots\\"+screenShotname+".png"); //createContact-08-12-23-17-56.png
		Files.copy(src, dst);
		
		return dst.getAbsolutePath(); //d://mavenProjects/E4/Screenshots/create.png
		//attaching this screenshot to extent reports
	}
	
	/**
	 * This method will switch the control to required window based on Title
	 * @param driver
	 * @param expPartialTitle
	 */
	public void handleWindows (WebDriver driver, String expPartialTitle)
	{
		//Capture all Window IDs
		Set<String> allWindIDs = driver.getWindowHandles();
		
		//Navigate through each Window ID
		for (String winId: allWindIDs)
		{
			//Switch to each Window ID and Capture the Title
		String actTitle=driver.switchTo().window(winId).getTitle();
		
		//Compare the Window Titles
		if (actTitle.contains(expPartialTitle))
		{
			break;
		}
		}
	}

}