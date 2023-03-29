package vtiger.GenericUtilities;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consists of generic methods related to webdriver actions
 * @author Vinay
 *
 */
public class WebDriverUtility {
	
	// Manage()
	public void maximisewindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void minimisewindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	// Wait and Manage()
	
	public void waitForPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void waitForElementToBeWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void waitForElementToClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	// Select
	
	public void handleDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public void handleDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	public void handleDropdown(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	// Actions
	
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();// right click on webpage
	}
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();// right click on particular webeleemnt
	}
	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();// double click on webpage
	}
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();// double click on webpage
	}
	public void dragAndDropAction(WebDriver driver, WebElement srcElement,  WebElement dstElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement,dstElement).perform();// double click on particular webeleemnt
	}
	// ALERT
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	// Frame
	
	public void handleFrame(WebDriver driver, int index ) {
		driver.switchTo().frame(index);
	}
	public void handleFrame(WebDriver driver, String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}
	public void handleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	// Window Handling
	
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		//step1 capture all the window ids
		Set<String> winIDs = driver.getWindowHandles();
		
		// step 2 navigate to each window using for each loop
		for(String win:winIDs) 
		{
			// step3 switch to window and get title of the child window
			String winTitle = driver.switchTo().window(win).getTitle();
			
			
			// step 4 compare the title
			if(winTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}
	
	// ScreenShot
	
	/*public String takeScreenShot(WebDriver driver, String screenshotName ) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver; // TakesScreenshot is interface
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenshotName+".png");
		Files.copy(src, dst); // add common io dependancy
		
		return dst.getAbsolutePath(); //used for extent report
		 
	}*/
	
	// scrollAction using JavascriptExecutor
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", ""); // x represents horizontal scroll and y represents vertical scroll
	}
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY(); // getting y coordinate
		js.executeScript("window.scrollBy(0,"+y+")",element );
	}
	
	
	
	
	
	
	
	
}
