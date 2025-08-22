 package ninzaCRM.genricUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class consists of generic methods related to WebDriver
 * 
 * @author Gaurav Ganesh Naikna
 *
 */
public class WebdriverUtility {

	// maximize, minimize, full screen

	/**
	 * This method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will minimize the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method will fullScreen the window
	 * 
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}

	// implicitlywait, explicitly - visible,clickable

	// handle drop down - list box

	// Actions class - mouseOvering, drag and drop, click n hold, release
	// move by offset, double clcik, contextClick

	// handleFrames - 5
	// handling Alert - 4
	// handle window - 2

	/**
	 * This method will add 10s of implicitly wait
	 * 
	 * @param driver
	 */
	public void addimplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method will wait for 10s for element to be visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will handle drop down by index
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method will handle drop down by value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This method will handle drop down by visible text
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropdown(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method will perform mouse hovering action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method will perform right Click action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This method will perform double Click action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method will perform drag and drop action
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver, WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}

	/**
	 * This method will perform scroll down action by 500 units
	 * 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,500);", "");

	}

	/**
	 * This method will handle Frame by using frame index
	 * 
	 * @param driver
	 * @param frameindex
	 */
	public void handleFrame(WebDriver driver, int frameindex) {
		driver.switchTo().frame(frameindex);

	}

	/**
	 * This method will handle Frame by using frame Name or ID
	 * 
	 * @param driver
	 * @param frameNameorID
	 */
	public void handleFrame(WebDriver driver, String frameNameorID) {
		driver.switchTo().frame(frameNameorID);
	}

	/**
	 * This method will handle Frame by using Frame Element
	 * 
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver, WebElement FrameElement) {
		driver.switchTo().frame(FrameElement);
	}

	/**
	 * This method will switch to window based on window title
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		// Step 1: Capture all the window IDs
		Set<String> allWinIDs = driver.getWindowHandles();

		// Step 2: Navigate to each window ID
		for (String winID : allWinIDs) {
			// Step 3: switch to each window and capture the title
			String actTitle = driver.switchTo().window(winID).getTitle();

			// Step 4: compare the title with required title
			if (actTitle.contains(partialWinTitle)) {
				break;
			}
			

		}
	}

	/**
	 * This method will capture screenshot and store it in a folder
	 * 
	 * @param driver
	 * @param screenShotName
	 * @return
	 *
	 *

	 *@throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots" + screenShotName + ".png");

		FileHandler.copy(src, dst);

		return dst.getAbsolutePath(); // for extent reports

	}
	

}


