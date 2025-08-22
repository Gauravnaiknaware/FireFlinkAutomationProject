package ninza.CRMCampaign;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.CreateCampaignsPage;
import ninzaCRM.ObjectRepository.DashboardPage;
import ninzaCRM.genericUtilities.BaseClass;

public class CampaignTest2 extends  BaseClass {



	@Test(groups = "SmokeSuite")
	public void createampaign() throws EncryptedDocumentException, IOException, InterruptedException {
		
		 DashboardPage dh= new DashboardPage(wd);
		    dh.getCampaign().click();
		    
		   CampaignPage ch= new CampaignPage(wd);
		   ch.clickOnCreateCampaignBtn();
		  CreateCampaignsPage create= new CreateCampaignsPage(wd);
		   
		    
		  FileInputStream Exel=new FileInputStream("src\\test\\resources\\TestData (1).xlsx");	
		    Workbook wb = WorkbookFactory.create(Exel);
			Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.getRow(34);
			
			 String campaignname = row.getCell(1).getStringCellValue();
			 String targetsize = row.getCell(2).getStringCellValue();
			 
			 create.createCampaign(campaignname, targetsize);
			
			 dh.logoutOfApp(wd);
	}
}
