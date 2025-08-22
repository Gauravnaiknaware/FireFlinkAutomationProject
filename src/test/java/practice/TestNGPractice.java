package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	

	@Test(enabled = true)
	public void sampleTest() {
		Assert.fail();
		System.out.println("create");
		
		
	}
	@Test(priority = -2,invocationCount = 2)
	public void sampleTest1() {
		System.out.println("modify");
		
		
	}
	@Test(invocationCount = 2)
	public void sampleTest2() {
		System.out.println("delete");
		
		
	}
}
