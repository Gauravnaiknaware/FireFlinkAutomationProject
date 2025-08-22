 package practice;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;

	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.testng.annotations.Test;

	import ninzaCRM.ObjectRepository.CreateCampaignsPage;
	import ninzaCRM.ObjectRepository.DashboardPage;
	import ninzaCRM.ObjectRepository.LoginPage;

	public class Praticete{
        
	 

		   static WebDriver wd=null;
	     
		   
			
	    	FileInputStream fis= new FileInputStream("src/test/resources/CommonData.properties");
		    Properties p= new Properties();
		   p.load(fis)
		   String url = p.getProperty("url");
		   String un = p.getProperty("username");
		   String pass = p.getProperty("password");
		   String browser = p.getProperty("browser");


		 if(browser.equals("Edge")) {
		     wd=new EdgeDriver();
		 }else {
		     wd=new ChromeDriver();
		 }
		 wd.manage().window().maximize();
		 wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		 wd.get(url);
		
	 
	    LoginPage lp = new LoginPage(wd);
	    lp.loginToApp(un, pass);
	    
    DashboardPage dh= new DashboardPage(wd);
	    dh.getCampaign().click();
	    
	    CreateCampaignsPage create= new CreateCampaignsPage(wd);
	    create.clickCampaignbtn();
	    
	    FileInputStream Exel=new FileInputStream("src/test/resources/TestData (1).xlsx");	
	    Workbook wb = WorkbookFactory.create(Exel);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(34);

		 String date = row.getCell(0).getStringCellValue();
		 String campaignname = row.getCell(1).getStringCellValue();
		 String audience = row.getCell(2).getStringCellValue();
		 String status = row.getCell(3).getStringCellValue();
		 String description = row.getCell(4).getStringCellValue();
		 String targetsize = row.getCell(5).getStringCellValue();
	    
	      create.fillData(date, campaignname, audience, description, targetsize, campaignname);	
	 }
}



