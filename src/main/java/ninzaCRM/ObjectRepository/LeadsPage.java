package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsPage {

	  @FindBy(xpath="//span[.='Create Lead']")
      private WebElement createlead;
	  
	  @FindBy(name="leadStatus")
      private WebElement leadstatus;
	  
	  @FindBy(name="name")
      private WebElement leadname;
	  
	  
	  
	  
}
