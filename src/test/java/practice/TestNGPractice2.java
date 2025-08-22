package practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice2 {

	@Test(dataProvider = "customerInfo")
	public void create(String name,int id) {
		//Assert.fail();
		System.out.println(name+" and "+id+" created");
		
		
	}
	
	@Test(dependsOnMethods = "create")
	public void modify() {
		//Assert.fail();
		System.out.println("modify");
		
		
	}
	
	@Test
	public void delete() {
		//Assert.fail();
		System.out.println("modify");
		
		
	}
	@DataProvider(name="customerInfo")
	public Object[][] getdata(){
		    Object[][]data=new Object[4][2];
		    
		    data[0][0]="Batman";
		    data[0][1]=1;
		    
		    data[1][0]="Spiderman";
		    data[1][1]=2;
		    
		    data[2][0]="Hulk";
		    data[2][1]=3;
		    
		    data[3][0]="Tom";
		    data[3][1]=4;
		    
		    return data;
		    
	}
}
