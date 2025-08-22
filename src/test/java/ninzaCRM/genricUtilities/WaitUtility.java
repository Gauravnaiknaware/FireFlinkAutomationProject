package ninzaCRM.genricUtilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consist of genric methods related to 
 * waits
 * @author Gaurav Ganesh Naikna
 */
public class WaitUtility {

	
	/**
	 * this method is related to implicit wait
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void explicitWait(WebDriver driver,int seconds,WebElement element) {
		       WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		       wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is related to handledropdown actions
	 * @param element
	 * @param index
	 */
	public void handledropdown(WebElement element,int index) {
		      Select sel= new Select(element);
		      sel.selectByIndex(index);
		     
	}
	/**
	 * This method is related to mouse hovering actions
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
    public void mouseOveringAction(WebDriver driver,WebElement element,int x,int y) {
    	       Actions act=new Actions(driver);
    	       act.moveToElement(element).perform();;
    	       act.moveByOffset(x, y);
    	       act.moveToElement(element, x, y);
    	      
    }
    /**
      This method is related to drag and drop operations
     * @param driver
     * @param element
     * @param x
     * @param y
     */
    public void dragAnddropActions(WebDriver driver,WebElement element,int x,int y) {
    	 Actions act=new Actions(driver);
    	 act.dragAndDrop(element, element).perform();
    	 act.dragAndDropBy(element, x, y).perform();;
    	 
    
    }
    /**
     * THis method related to click and hold actions
     * @param driver
     * @param element
     */
    
    public void clickAndHold(WebDriver driver,WebElement element) {
    	            Actions act=new Actions(driver);
    	            act.clickAndHold().perform();
    	            act.clickAndHold(element).perform();
    	            act.clickAndHold(element).release();
    }
    /**
     * This method is related to doubleclick operations
     * @param driver
     * @param element
     */
    
    public void doubleclick(WebDriver driver,WebElement element) {
    	Actions act= new Actions(driver);
    	act.doubleClick().perform();
    	act.doubleClick(element).perform();
    }
    /**
     * This method is related to perform right click operations 
     * @param driver
     * @param element
     */
    public void contextclick(WebDriver driver,WebElement element) {
    	Actions act= new Actions(driver);
    	act.contextClick().perform();
    	act.contextClick(element).perform();
    }
    /**
     * This method is related to frames
     * @param driver
     * @param element
     */
    public void switchToFrame(WebDriver driver,WebElement element) {
    	
    	driver.switchTo().defaultContent();
    }
    /**
     * This method is related to switch to frame by using index
     * @param driver
     * @param Element
     * @param index
     */
    public void switchToFrame(WebDriver driver,WebElement Element,int index) {
    	driver.switchTo().frame(index);
    }
    /**
     * This method is related to switch to frame related to particular element
     * @param driver
     * @param Element
     */
    public void switchToFrameBasedonElement(WebDriver driver,WebElement Element) {
    	driver.switchTo().frame(Element);
    }
    /**
     * This method is related to switch to frame based on frame name
     * @param driver
     * @param Element
     * @param name
     */
    public void switchToFrameBasedonElement(WebDriver driver,WebElement Element,String name) {
    	driver.switchTo().frame(name);
    }
    /**
     **This method is related to handling the alert
     * @param driver
     */
    public void handleAlert(WebDriver driver) {
    	driver.switchTo().alert().accept();
    }
    /**
     * This method is related to handle
     * Confirmation alert
     * @param driver
     */
    public void handleConfirmationAlert(WebDriver driver) {
    	driver.switchTo().alert().dismiss();
    }
   /**
    * This method is related to handle prompt
    * alert popup
    * @param driver
    * @param key
    */
    public void handlepromptAlert(WebDriver driver,String key) {
    	driver.switchTo().alert().sendKeys(key);
    }
    /**
     * This method  is related to handle alert
     * and get Text of it
     * @param driver
     */
    public void handlealert(WebDriver driver) {
    	driver.switchTo().alert().getText();
    }
    /**
     *This method is related to window handle
     * @param driver
     */
    public void handleWindow(WebDriver driver) {
    	  String handleWindow=driver.getWindowHandle();
    	  Set<String> windowHandles = driver.getWindowHandles();
    }
  
    
    
    
    
}
