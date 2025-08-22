 package ninzaCRM.genericUtilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ninzaCRM.ObjectRepository.LoginPage;
import ninzaCRM.genricUtilities.FileUtility;
 

//import ninzaCRM.ObjectRepo.LoginPage;

public class BaseClass {
    

 FileUtility fu=new  FileUtility();
 //for listners
 public static WebDriver sdriver;
 public WebDriver wd;
     //@BeforeSuite
    @BeforeSuite(alwaysRun = true)
    public void dbconnection(){
        System.out.println("=======DB Connected Succesfully======");
    }
    @Parameters("browser")
    @BeforeTest()
    @BeforeClass(alwaysRun = true)
    public void bcConfiguration(String browser) throws IOException {
        //String browser = fu.readDataFromPropertyFile("browser");
        String URL = fu.readDataFromPropertyFile("url");
        if(browser.equals("Edge")) {
             wd=new EdgeDriver();
         }else {
             wd=new ChromeDriver();
         }
         wd.manage().window().maximize();
         sdriver=wd;
         wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
         wd.get(URL);
        System.out.println("=====App Launched======");
        
    }
    @BeforeMethod(alwaysRun = true)
    public void login() throws IOException {
        String un = fu.readDataFromPropertyFile("username");
        String pass = fu.readDataFromPropertyFile("password");
        LoginPage lp=new LoginPage(wd);
        lp.loginToApp(un, pass);
    }
    @AfterMethod(alwaysRun = true)
    public void logout(){
        
    }
    @AfterTest()
    public void  bcClose() {
        wd.close();
    }
    @AfterSuite(alwaysRun = true)
    public void dbClose() {
        System.out.println("====== DB CLOSED======");
    }
   
    
 
    

}
