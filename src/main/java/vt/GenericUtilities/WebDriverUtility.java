package vt.GenericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Set;

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

public class WebDriverUtility {
	
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	 public void getMaximizeWindow(WebDriver driver)
	 {
		 driver.manage().window().maximize();
	 }
	 /**
	  * this method is will minimize the window
	  * @param driver
	  */
	 public void getMinimizeWindow(WebDriver driver)
	 {
		 driver.manage().window().minimize();
	 }
	 /**
	  * this method will wait for page to be loaded
	  * @param driver
	  */
	 public void getWaitforPage(WebDriver driver)
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 }
	 /**
	  * This method will wait until the elemnet becomes visible
	  * @param driver
	  * @param element
	  */
	 public void getWaitForElementToBeVisible(WebDriver driver, WebElement element)
	 {
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 /**
	  * this method will wait till the element is clickable
	  * @param driver
	  * @param element
	  */
	 public void getWaitForElementToBeClickable(WebDriver driver, WebElement element)
	 {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	    
	 } 
	 /**
	  * This method will help u handle the dropdown based on index value
	  * @param element
	  * @param index
	  */
    public void getHandleDropDown(WebElement element, int index)
    {
    	Select select=new Select(element);
    	select.selectByIndex(index);
    }
    /**
     * this method will help u handle dropdown ased on value visible 
     * @param element
     * @param value
     */
    public void getHandledropDown(WebElement element,String value )
    {
    	Select select=new Select(element);
    	select.selectByValue(value);
    }
    /**
     * this methos will help u handle the dropsown based on text visible
     * @param text
     * @param element
     */
    public void getHandleDropDown(String text, WebElement element )
    {
    	Select select=new Select(element);
    	select.selectByValue(text);
    }
    public void getHandleDropDown(WebElement element, String text, String text1)
    {
    	Select select=new Select(element);
    	select.selectByVisibleText(text);
    	select.selectByVisibleText(text1);
    }
    /**
     * this method is to move to element
     * @param driver
     * @param element
     */
    public void getMouseHover(WebDriver driver, WebElement element)
    {
    	Actions action=new Actions(driver);
    	action.moveToElement(element).perform();
    }
    /**
     * this method will perform right click on webElement
     * @param driver
     * @param element
     */
    public void getRightClickaction(WebDriver driver, WebElement element)
    {
    	Actions action=new Actions(driver);
    	action.contextClick(element).perform();
    	
    }
    /**
     * this method will rigth click on webPage
     * @param driver
     */
    public void getRightClickaction(WebDriver driver)
    {
    	Actions action=new Actions(driver);
    	action.contextClick().perform();
    	
    }
    /**
     * this method will double click on the webelement 
     * @param driver
     * @param element
     */
    public void getDoubleClickaction(WebDriver driver, WebElement element)
    {
    	 Actions action =new Actions(driver);
    	 action.doubleClick(element).perform();
    }
    /**
     * this method is will double click on the webpage
     * @param driver
     */
    public void getDoubleClickaction(WebDriver driver)
    {
    	 Actions action =new Actions(driver);
    	 action.doubleClick().perform();
    }
    /**
     * this method will help u to drag and drop the element fro source to destination
     * @param driver
     * @param src
     * @param dest
     */
    public void getDragAndDropAction(WebDriver driver, WebElement src, WebElement dest)
    {
    	Actions action =new Actions(driver);
    	action.dragAndDrop(src, dest).perform();
    }
    /**
     * this method will handle the alert / accept the alert
     * @param driver
     */
    public void getAcceptAlert(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    /**
     * this method will help u to dissmiss the alert
     * @param driver
     */
    public void getDissmissAlert(WebDriver driver)
    {
    driver.switchTo().alert().dismiss();	
    }
    /**
     * this method will get  u the text which is available in alert pop up
     * @param driver
     * @return 
     */
    public String getAlertText(WebDriver driver)
    {
    	return driver.switchTo().alert().getText();
    }
    /**
     * this method will handle the frame based on index
     * @param driver
     * @param index
     */
    public void getHandleFarme(WebDriver driver, int index)
    {
    	driver.switchTo().frame(0);
    }
    /**
     * this method will help u handle farme based on name Or Id
     * @param driver
     * @param nameOrId
     */
    public void getHandleFrame(WebDriver driver, String nameOrId)
    {
    	driver.switchTo().frame(nameOrId);
    }
    /**
     * this method will help u handle the farme based on elemnet
     * @param driver
     * @param element
     */
    public void getHandleFrame(WebDriver driver,WebElement element)
    {
    	driver.switchTo().frame(element);
    }
    
   /**
    * this method will help u handle switch to parent window
    * @param driver
    */
      public void getSwitchToParentFrame(WebDriver driver)
    {
    	driver.switchTo().parentFrame();
    }
      /**
       * this method is to switch the frame to the default content
       * @param driver
       */
    public void getSwitchTodefaultContent(WebDriver driver)
    {
    	driver.switchTo().defaultContent();
    }
    /**
     * this method will help u to handle the multiple window
     * @param driver
     * @param partialWinTitle
     */
    public void getSwitchToWindow(WebDriver driver, String partialWinTitle)
    {
    	//Step 1 :  capture the window ids
    	Set<String> winIds = driver.getWindowHandles();
    	//Step 2 : navigate each window and compare title
    	for(String win : winIds)
    	{
    	  //	step 3 : switch to window n capture the title
    		String winTitle = driver.switchTo().window(win).getTitle();
    		
    		//step 4 : ompare the title with partial window title
    		    if(winTitle.contains(partialWinTitle))
    		    {
    		    	break;
    		    }
    		    }
           }
    /**
     * this method will take screenshot and save in required file
     * @param driver
     * @param screenshotName
     * @return
     * @throws Throwable
     */
    public String getTakeScreenShot(WebDriver driver,String screenshotName) throws Throwable
    {
    	   TakesScreenshot sshot=(TakesScreenshot)driver;
    	   File src = sshot.getScreenshotAs(OutputType.FILE);
    	  File dest=  new File(".\\Screenshots\\"+screenshotName+".png");
    	  FileUtils.copyFile(src, dest);
    	  return dest.getAbsolutePath();//used for extent reports
    }
    /**
     * this meyhod will scroll window downward vertically in DOM(document object model)
     * @param driver
     */
    public void getScrollAction(WebDriver driver)
    {
    	JavascriptExecutor jsc=(JavascriptExecutor)driver;
    	jsc.executeScript("window.scrollBy(0,500)", "");
    }
    /**
     * this method vill scroll the page till the particular element by using the element ref 
     * @param driver
     * @param element
     */
   public void getScrollAction(WebDriver driver, WebElement element)
    {
   JavascriptExecutor jsc=(JavascriptExecutor)driver;
    	int y = element.getLocation().getY();
    	jsc.executeScript("window.scrollBy(0,"+y+")", "element");
    }
    /**
     * 
     */
    public void getMaximizeAndWaitTillPageLoaded(WebDriver driver)
    {
    	getMaximizeWindow(driver);
    	getWaitforPage(driver);
    }

}
