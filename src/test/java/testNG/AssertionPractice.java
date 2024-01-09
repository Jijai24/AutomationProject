package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionPractice {

	@Test
	public void sample()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		Assert.assertEquals(false, true);
		System.out.println("Step 3");
		System.out.println("Step 4");
	}
}
