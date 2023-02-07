package vtiger.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the generic methods related to web driver actions
 * @author Prashant
 *
 */
public class WebDriverUtility {
	/**
	 *  1) This method is used to maximize the window
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * 2) This method will wait for user given time for the entire DOM (Document Object Model)
	 * structure to load
	 * @param driver
	 * @param seconds
	 */
	public void waitForDOMToLoad(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	/**
	 * 3) This method will wait for particular element to be visible
	 * @param driver
	 * @param seconds
	 * @param ele
	 */
	public void waitForElementToLoad(WebDriver driver, Duration seconds, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	/**
	 * 4) This method will wait for particular element to be clickable
	 * @param driver
	 * @param seconds
	 * @param ele
	 */
	public void waitForElementToBeClickable(WebDriver driver, Duration seconds, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	/**
	 * 5) This method is a custom wait where it will wait for a particular element to perform click operation
	 * If the element is not interactive it will wait for 1 second
	 * @param ele
	 * @throws InterruptedException
	 */
	public void customWaitAndClickOnElement(WebElement ele) throws InterruptedException {
		int count = 0;
		while(count<10) {
			try {
				ele.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * 6) This method will handle Dropdown by select class using Index
	 * @param ele
	 * @param index
	 */
	public void handleDropDown(WebElement ele, int index) {
		Select s = new Select(ele);
		s.selectByIndex(index);
	}
	/**
	 * 7) This method will handle Dropdown by select class using Visible Text
	 * @param ele
	 * @param text
	 */
	public void handleDropDown(WebElement ele, String text) {  // Method Overloading
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}
	/**
	 * 8) This method will handle Dropdown by select class using Value
	 * @param value
	 * @param ele
	 */
	public void handleDropDown(String value,WebElement ele) {  // Method Overloading
		Select s = new Select(ele);
		s.selectByValue(value);
	}
	/**
	 * 9) This method will perform mouse hover action on a particular element
	 * @param driver
	 * @param ele
	 */
	public void mouseHover(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	/**
	 * 10) This method will perform double click on the page
	 * @param driver
	 */
	public void doubleClickOn(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * 11) This method will perform double click on a particular element
	 * @param driver
	 * @param ele
	 */
	public void doubleClickoN(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}
	/**
	 * 12) This method will perform right click on the page
	 * @param driver
	 */
	public void rightClickOn(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * 13) This method will perform right click on a particular element
	 * @param driver
	 * @param ele
	 */
	public void rightClickOn(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}
	/**
	 * 14) This method will perform drag and drop from source element location
	 * to target element location
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}
	/**
	 * 15) This method will press the Enter key and release
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);	
	}
	/**
	 * 16) This method will accept the alert pop up
	 * @param driver
	 */
	public void alertPopupAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * 17) This method will cancel the alert pop up
	 * @param driver
	 */
	public void alertPopupDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * 18) This method will get the text of alert pop up
	 * @param driver
	 * @return
	 */
	public String alertPopupGetText(WebDriver driver) {
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	/**
	 * 19) This method will handle frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * 20) This method will handle frame based on name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * 21) This method will handle frame based on frame element
	 * @param driver
	 * @param ele
	 */
	public void switchToFrame(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}
	/**
	 * 22) This method will switch the control back to immediate parent
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * 23) This method will come out of all the frames
	 * @param driver
	 */
	public void switchBackFromFrames(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * 24) This method will switch from one window to another based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		//Step 1 : Get all the window ids
		Set<String> windowIds = driver.getWindowHandles();
		
		//Step 2 : Iterate through all the window ids
		Iterator<String> it = windowIds.iterator();
		
		//Step 3 : Navigate to each window and check the title
		while(it.hasNext()) {
			// Capture the Individual window id
			String winId = it.next();
			String currentTitle = driver.switchTo().window(winId).getTitle();
			if(currentTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}
	/**
	 * 25) This method will take Screenshot and save it in Screenshots folder
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver, String screenShotName) throws IOException {
		JavaUtility jUtil = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);		
		File destFile = new File(IConstantsUtility.ScreenshotsPath+screenShotName+"-"+jUtil.getSystemDateInFormat()+".png");
		FileUtils.copyFile(srcFile, destFile);
		return destFile.getAbsolutePath(); // Used for Reporting
	}
	/**
	 * 26) This method will scroll down page for 500 units
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**
	 * 27) This method will scroll until the element
	 * @param driver
	 * @param ele
	 */
	public void scrollAction(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView()", ele);
		int y = ele.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", ele);
	}
	/**
	 * 28) This method will scroll until the element and click on the element
	 * @param driver
	 * @param ele
	 */
	public void javascriptClick(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		
	}
}
