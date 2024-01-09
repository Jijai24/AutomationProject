package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario_1 {

	public static void main(String[] args) throws Throwable {
		
		//step 1 Launching the Browser
		WebDriver driver=new EdgeDriver();
	//	WebDriver driver1=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step 2 Load the Application
	    driver.get("http://localhost:8888");
	    
	    //step 3 Login to Application
      driver.findElement(By.name("user_name")).sendKeys("admin");
      driver.findElement(By.name("user_password")).sendKeys("admin");
      driver.findElement(By.id("submitButton")).click();
      
      //step 4 Click on Contact Link
     driver.findElement(By.linkText("Contacts")).click();
     
     //step 5 Click on Create Contact LookUp Image
     driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
     
     //step 6 Create New Contact
     driver.findElement(By.name("lastname")).sendKeys("Batman");
     
     //step 7 save
     driver.findElement(By.name("button")).click();
     
     //step 8 Validate
     String contactheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
     if (contactheader.contains("Batman"))
     {
    	 System.out.println(contactheader);
    	 System.out.println("PASS");
     }
     else
     {
    	 System.out.println("FAIL");
     }
     //step 9 LogOut of App
     WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
     
     Actions act = new Actions(driver);
     act.moveToElement(ele).perform();
     
     Thread.sleep(1000);
     driver.findElement(By.linkText("Sign Out")).click();
     
     //step 10 Close the Browser
     driver.quit();
     
     
     
     
     
     
	}

}
