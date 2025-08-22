package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ninzaCRM.genricUtilities.FileUtility;

public class TestDataProvider {

	@Test(dataProvider = "NameInfo")
	public void create(String name,int id) {
		//Assert.fail();
		System.out.println(name+" and "+id+" created");
		
		
	}
	
	@DataProvider(name="NameInfo")
	public Object[][] getdata() throws EncryptedDocumentException, IOException{
		
		FileUtility fis=new FileUtility();
		
	  Object[][]data=new Object[4][2];
		    
		    data[0][0]= fis.readDataFromExcel("sheet1", 37, 0);
		    data[0][1]=fis.readDataFromExcel("sheet1", 37, 1);
		    
		    
		    data[1][0]=fis.readDataFromExcel("sheet1", 38, 0);
		    data[1][1]=fis.readDataFromExcel("sheet1", 38, 1);
		    
		    data[2][0]=fis.readDataFromExcel("sheet1", 39, 1);
		    data[2][1]=fis.readDataFromExcel("sheet1", 39, 1);
		    
		    
		    
		    data[3][0]=fis.readDataFromExcel("sheet1", 40, 1);
		    data[3][1]=fis.readDataFromExcel("sheet1", 40, 1);
		    
		    return data;
		    
	}
}

