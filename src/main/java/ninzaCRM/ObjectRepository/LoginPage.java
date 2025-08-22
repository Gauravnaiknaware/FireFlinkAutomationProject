package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule no 1
	
	//Rule No 2:Identify webElements using @FindBy,@FindAll,@FindBys
	//@FindBy- Identify Single/Multiple Webelement using Single Login
	
	@FindBy(id="username")
	private WebElement usernameTF;
	

	@FindBy(name="password")
	private WebElement passwordTF;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement signBtn;
	
	
	//Rule 3 Create Constructor and intializing
    public LoginPage(WebDriver driver) {
           PageFactory.initElements(driver,this);;
           
    }


	public WebElement getUsernameTF() {
		return usernameTF;
	}


	public WebElement getPasswordTF() {
		return passwordTF;
	}


	public WebElement getSignBtn() {
		return signBtn;
	}
    
	public void loginToApp(String username,String password) {
		    usernameTF.sendKeys(username);
		    passwordTF .sendKeys(password);
		    signBtn.click();
	}
	
	 
    
	 
	
   
	
	
	


	
}
