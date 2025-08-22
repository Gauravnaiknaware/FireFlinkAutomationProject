package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.genricUtilities.WebdriverUtility;

public class DashboardPage extends WebdriverUtility	{
	
	@FindBy(xpath="//a[.= 'Campaigns']")
	private WebElement campaign;
	
	@FindBy(xpath="//a[.= 'Contacts']")
	private WebElement contact;
	
	@FindBy(xpath="//a[.= 'Leads']")
	private WebElement leads;
	
	@FindBy(xpath="//a[.= 'Opportunities']")
	private WebElement opportunities;
	
	@FindBy(xpath="//a[.= 'Products']")
	private WebElement products;
	
	@FindBy(xpath="//a[.= 'Quotes']")
	private WebElement quotes;
	
	@FindBy(xpath="//a[.='Purchase Order']")
	private WebElement purchaseorder;
	
	@FindBy(xpath="//a[.='Sales Order']")
	private WebElement salesorder;
	
	@FindBy(xpath="//a[.='Invoice']")
	private WebElement invoice;
	
	@FindBy(xpath="//div[@class=\"nav-link\"]/li")
	private WebElement adminconsole;
	
	@FindBy(xpath = "//div[@class='user-icon']")
	private WebElement userIcon;

	@FindBy(xpath = "//div[@class='dropdown-item logout']")
	private WebElement logoutLnk;
	
	
	 public DashboardPage(WebDriver driver) {
         PageFactory.initElements(driver,this);;
         
  }

	 public WebElement getCampaign() {
		 return campaign;
	 }

	 public WebElement getContact() {
		 return contact;
	 }

	 public WebElement getLeads() {
		 return leads;
	 }

	 public WebElement getOpportunities() {
		 return opportunities;
	 }

	 public WebElement getProducts() {
		 return products;
	 }

	 public WebElement getQuotes() {
		 return quotes;
	 }

	 public WebElement getPurchaseorder() {
		 return purchaseorder;
	 }

	 public WebElement getSalesorder() {
		 return salesorder;
	 }

	 public WebElement getInvoice() {
		 return invoice;
	 }

	 public WebElement getAdminconsole() {
		 return adminconsole;
	 }
	 
	 public WebElement getuserIcon() {
			return userIcon;
	}

	 public WebElement getLogout() {
		 return logoutLnk;
	 }
	
	 
	 
	 
		// Business Library
		/**
		 * This method will click on leads link
		 * 
		 */
		public void clickOnCampaignsLnk() {
			campaign.click();
		}

		
		/**
		 * This method will click on leads link
		 * 
		 */
		public void clickOnLeadsLnk() {
			leads.click();
		}

		/**
		 * This method will click on contacts link
		 * 
		 */
		public void clickOnContactsLnk() {
			contact.click();

		}

		/**
		 * This method will click on opportunities link
		 * 
		 */
		public void clickOnOppotunitiesLnk() {
			opportunities.click();
		}

		
		/**
		 * This method will logout of Application
		 * @param driver
		 * @throws InterruptedException
		 */
		public void logoutOfApp(WebDriver driver) throws InterruptedException
		{
			
			
			Thread.sleep(6000);
			mouseOverAction(driver, getuserIcon());
			getuserIcon().click();
			logoutLnk.click();
		}

		
		
		
	}
	
	
	
	
	
	
	
	
	
    
	

	
	
	
	

	


