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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyPurchaseOrderWithUpdatedProduct {

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
	 
	 wd.findElement(By.xpath("//a[.='Purchase Order']")).click();
	 
	 wd.findElement(By.xpath("//span[.='Create Order']")).click();
	 
	 FileInputStream Exel=new FileInputStream("src/test/resources/TestData (1).xlsx");	
	  Workbook wb = WorkbookFactory.create(Exel);
     Sheet sheet = wb.getSheet("Sheet1");
	 Row row = sheet.getRow(7);
	 
	  String duedate=row.getCell(2).getStringCellValue();
	  String subject=row.getCell(3).getStringCellValue();
	  String conatctname=row.getCell(4).getStringCellValue();

	 

	 
	 wd.findElement(By.xpath("//input[@name=\"dueDate\"]")).sendKeys(duedate);
	 
	 wd.findElement(By.xpath("//input[@name=\"subject\"]")).sendKeys(subject);
	 
	 wd.findElement(By.xpath("(//button[@class=\"action-button\"])[1]")).click();
	 Set<String> windowHandles = wd.getWindowHandles();
	 for(String window:windowHandles) {
	     if(!window.equals(windowHandle)) {
	        
	         wd.switchTo().window(window);
	     }
	 }
	 
	  wd.findElement(By.xpath("//input[@id=\"search-input\"]")).sendKeys(conatctname);
	}
}
