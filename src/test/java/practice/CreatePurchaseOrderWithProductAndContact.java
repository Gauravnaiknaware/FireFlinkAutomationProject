package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePurchaseOrderWithProductAndContact {
                

		 static WebDriver wd=null;
		    public static void Check(String path,String msg) {
		        WebDriverWait wait=new WebDriverWait(wd,Duration.ofSeconds(10));
		        try {
		             WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		             if(until.isDisplayed()) {
		                 System.out.println("Passed "+msg+ " is displayed");
		             }
		             
		        } catch (Exception e) {
		            System.out.println("failed "+msg+ " is not displayed");
		        }
		    }
		public static void main(String[] args) throws IOException {
		    FileInputStream fis= new FileInputStream("src/test/resources/CommonData.properties");
		    Properties p= new Properties();
		    p.load(fis);
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
		 String windowHandle = wd.getWindowHandle();
		 WebElement username = wd.findElement(By.id("username"));

		 username.sendKeys(un);
		 
		 WebElement password = wd.findElement(By.id("inputPassword"));
		 password.sendKeys(pass);
		 
		 wd.findElement(By.xpath("//button[.='Sign In']")).click();
		 
		Check("//b[.='Campaigns']","Campaign");

		wd.findElement(By.xpath("//a[.='Contacts']")).click();

		Check("//b[.='Contacts']","Contact");

		wd.findElement(By.xpath("//span[.='Create Contact']")).click();

		FileInputStream Exel=new FileInputStream("src/test/resources/TestData (1).xlsx");	
	    Workbook wb = WorkbookFactory.create(Exel);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(4);

		 String Contactname = row.getCell(2).getStringCellValue();
		 String organization = row.getCell(3).getStringCellValue();
		 String mobileno = row.getCell(4).getStringCellValue();
		 String title = row.getCell(5).getStringCellValue();
		 String CampaignId = row.getCell(6).getStringCellValue();
		 String quantity = row.getCell(7).getStringCellValue();
		 //Product Name    PricePerUnit    Category    Vendor    Due Date    Subject
		 String productname = row.getCell(8).getStringCellValue();
		 String Priseperunit = row.getCell(9).getStringCellValue();
		 String category = row.getCell(10).getStringCellValue();
		 String Vendor = row.getCell(11).getStringCellValue();
		 String Duedate = row.getCell(12).getStringCellValue();
		 String Subject = row.getCell(13).getStringCellValue();
		 
		 wd.findElement(By.xpath("//input[@name='contactName']")).sendKeys(Contactname);
		 wd.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(organization);
		 wd.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobileno);
		 wd.findElement(By.xpath("//input[@name='title']")).sendKeys(title);
		 wd.findElement(By.xpath("(//button[@type='button'])[2]")).click();


		 Set<String> windowHandles = wd.getWindowHandles();
		 for(String window:windowHandles) {
		     if(!window.equals(windowHandle)) {
		        
		         wd.switchTo().window(window);
		     }
		 }
		 try {
		    Thread.sleep(2000);
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		 wd.findElement(By.id("search-input")).sendKeys(CampaignId);
		 wd.findElement(By.xpath("//button[.='Select']")).click();

		 //wd.manage().window().minimize();
		 wd.switchTo().window(windowHandle);
		wd.findElement(By.xpath("//button[.='Create Contact']")).click();
		Check("//div[contains(text(), 'Successfully')]", "Contact Added Successfully");

		wd.findElement(By.xpath("//a[.='Products']")).click();

		Check("//b[.='Products']","Product");
		WebElement AddPro = wd.findElement(By.xpath("//span[.='Add Product']"));
		WebDriverWait  wait=new WebDriverWait(wd, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(AddPro));

		AddPro.click();



		wd.findElement(By.xpath("//input[@name='quantity']")).sendKeys(quantity);
		wd.findElement(By.xpath("//input[@name='productName']")).sendKeys("Notes");
		wd.findElement(By.xpath("//input[@name='price']")).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Priseperunit);
		WebElement Select = wd.findElement(By.xpath("//select[@name='productCategory']"));
		Select s=new Select(Select);
		s.selectByContainsVisibleText(category);
		WebElement ven = wd.findElement(By.xpath("//select[@name='vendorId']"));
		ven.click();
		Select s1=new Select(ven);
		s1.selectByContainsVisibleText(Vendor);
		wd.findElement(By.xpath("//button[.='Add']")).click();

		Check("//div[contains(text(),'Successfully Added')]","Product Added Successfully");
		WebElement Purchase = wd.findElement(By.xpath("//a[.='Purchase Order']"));
		 wait.until(ExpectedConditions.elementToBeClickable(Purchase));
		 Purchase.click();
		 Check("//b[.='Purchase Orders']", "Purchase Orders Page");
		 
		 WebElement createOrder = wd.findElement(By.xpath("//span[.='Create Order']"));
		 wait.until(ExpectedConditions.elementToBeClickable(createOrder));
		 createOrder.click();
		 Check("//h3[.='Create Purchase-Order']","Create Purchase Order Page");
		 
		 wd.findElement(By.xpath("//input[@name='dueDate']")).sendKeys(Duedate);
		 wd.findElement(By.xpath("//input[@name='subject']")).sendKeys(Subject);
		 wd.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		 
		 Set<String> windowHandles2 = wd.getWindowHandles();
		 for(String w2:windowHandles2) {
		     if(!w2.equals(windowHandle)) {
		         wd.switchTo().window(w2);
		     }
		 }
		Check("//h3[.='Select a Contact']", "select Contact Page");
		 wd.findElement(By.id("search-input")).sendKeys(organization);
		 wd.findElement(By.xpath("//button[@class='select-btn']")).click();
		  wd.switchTo().window(windowHandle);

		Actions act=new Actions(wd); 
		  WebElement AddP = wd.findElement(By.xpath("(//button[@class='action-button'])[last()]"));
		act.scrollToElement(AddP);
		AddP.click();

		Set<String> w3 = wd.getWindowHandles();
		for(String win:w3) {
		    if(!win.equals(windowHandle)) {
		    wd.switchTo().window(win);
		    }
		}
		Check("//h3[.='Select a Product']","select page ");

		wd.findElement(By.id("search-input")).sendKeys("Notes");
		wd.findElement(By.xpath("//button[@class='select-btn']")).click();

		wd.switchTo().window(windowHandle);
		WebElement user = wd.findElement(By.xpath("//div[@class='user-icon']"));
		act.moveToElement(user).perform();

		wd.findElement(By.xpath("//div[.='Logout ']")).click();
		Check("//h2[.='Sign In']","Log Out");
		    
	}
}
