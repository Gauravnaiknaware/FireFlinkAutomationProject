package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ninzaCRM.genericUtilities.BaseClass;

public class AssertionPractice extends BaseClass {

	@Test
	public void sampleTest() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(0, 1);
		//Assert.assertEquals(1, 1); //Match 
	      Assert.assertTrue(true);
		
		
		System.out.println("Step 4");
		
		//Assert.assertEquals("b","a"); //Not match
		
		System.out.println("Step 5");
		
		sa.assertAll();// Log the assertions
		
       
		
		



		
	}
}
