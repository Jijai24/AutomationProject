package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This Class consists of reusable methods related to Properties File
 * @author Jija
 */
public class PropertyFileUtility {
	/**
	 * This method will read data from Property File and return the value to the caller
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
        Properties p = new Properties();
	    p.load(fis);
	   String value = p.getProperty(key);
	   return value;
	}
}
