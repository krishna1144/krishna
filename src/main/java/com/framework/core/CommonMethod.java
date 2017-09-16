	
 package com.framework.core;
 import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
 import java.util.List;
 import java.util.Set;
 import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
 import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
 import org.openqa.selenium.support.ui.Select;
 import org.openqa.selenium.support.ui.WebDriverWait;

 public class CommonMethod extends BaseClass   {
 	
 	
 	/**
 	 * Return WebElement
 	 * @param driver
 	 * @param objLocator
 	 * @return
 	 */
 	public static WebElement findElement(By objLocator){
 		
 		
 		return driver.findElement(objLocator);
 		
 	}
 	
 	
 	/**
 	 * Clear Method
 	 * @param driver
 	 * @param objLocator
 	 * @throws IOException 
 	 */
 	public static void clear(By objLocator) throws IOException{
 		
 		if(isElementPresent(objLocator)){
 	 		findElement( objLocator).clear();
 	 		log.info("clearing locator "+objLocator);
 		}
 		else{
 			log.error("unable to find locator "+objLocator);
 		}
 		
 	}
 	
 	/**
 	 * SendKeys Method
 	 * @param driver
 	 * @param objLocator
 	 * @throws IOException 
 	 */
 	public static void click(By objLocator) throws IOException{
 		
 		if(isElementPresent(objLocator)){
 	 		findElement( objLocator).click();
 	 		log.info("clicking on locator "+objLocator);
 		}
 		else{
 			log.error("unable to find locator "+objLocator);
 		}
 	}
 	
 	/**
 	 * Click method
 	 * @param driver
 	 * @param objLocator
 	 * @param data
 	 * @throws IOException 
 	 */
 	public static void sendKeys(By objLocator,String data) throws IOException{
 		
 		
 		if(isElementPresent(objLocator)){
 			findElement( objLocator).sendKeys(data); 	 		
 			log.info("passing data to locator "+objLocator);
 		}
 		else{
 			log.error("unable to find locator "+objLocator);
 		}
 	}
 	
 	/**
 	 * 'GetText Method
 	 * @param driver
 	 * @param objLocator
 	 * @return
 	 */
 	public static String getText(By objLocator){
 		
 		String out =findElement( objLocator).getText();
 		return out;
 	}
 	
 	

 	
 	/**
 	 * Select drop down
 	 * 
 	 * @param driver
 	 * @param by
 	 * @param value
 	 * @throws IOException 
 	 * 
 	 */
 	public static void selectDropdown( By elementBy, String value) throws IOException{
 		new Select (findElement(elementBy)).selectByVisibleText(value); 
 		
 	}
 	/**
 	 * Handling New Tab from Parent
 	 * @param driver
 	 */
 	public static void handleNewTab(WebDriver driver)
 	{
 		Set<String> allWindowHandles = driver.getWindowHandles();
 		Iterator<String> iter=allWindowHandles.iterator();
 		int size=allWindowHandles.size();
 		String window0 = null;
 		for(int i=0;i<size;i++){
 			window0=iter.next();
 		}
 		
 		driver.switchTo().window(window0);
 	}
 	
 	/**
 	 * Handling Parent tab
 	 * @param driver
 	 */
 	public static void handleParentTab(WebDriver driver){
 		
 		Set<String> allWindowHandles = driver.getWindowHandles();
 		String window0 = (String) allWindowHandles.toArray()[0];
 		driver.switchTo().window(window0);

 	}
 	/**
 	 * Handling childParent tab
 	 * @param driver
 	 */
 	public static void handleChildParentTab(WebDriver driver){
 		
 		Set<String> allWindowHandles = driver.getWindowHandles();
 		String window1 = (String) allWindowHandles.toArray()[1];
 		driver.switchTo().window(window1);

 	}
 	
 /**
  * For getting get attribut value from field
  * @param driver
  * @param objectLocater
  * @return
  * @throws IOException
  */
 	public static String getValue(By elementBy) throws IOException{
 		return findElement( elementBy).getAttribute("value");
 	}

 	//Explicit wait for perticular object locator
 	/**
 	 * Explicit wait for perticular object locator
 	 * @param driver
 	 * @param timeOutInSeconds
 	 * @param objectLocater
 	 * @throws IOException
 	 */
 	public static void explicitWait(int timeOutInSeconds,By elementBy) throws IOException{
 		WebDriverWait wait=new WebDriverWait( driver,timeOutInSeconds);
 		wait.until(ExpectedConditions.elementToBeClickable(elementBy));

 		}
 	
 	/**
 	 * Handling alerts and popups
 	 * @param WebDriver
 	 * @return
 	 */
 	public static void acceptAlert(final WebDriver driver) {
 		try {
 			Alert alert = driver.switchTo().alert();
 			alert.accept();

 			
 		} catch (Exception e) {
 			
 		}
 		
 	}
 	public static String cancelAlert(final WebDriver driver) {
 		String message = null;
 		try {
 			Alert alert = driver.switchTo().alert();

 			message = alert.getText();
 			alert.dismiss();
 			
 		} catch (Exception e) {
 		  message = null;
 		}

 		return message;
 	}
 	
 	/**
 	 * Compact way to verify if an element is on the page 
 	 * @param driver
 	 * @throws IOException 
 	 */
 	public static boolean isElementPresent(final  By elementBy) throws IOException  {
 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 			if(findElements(elementBy).size()!=0){
 				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 				return true;
 				
 			}
 			else{
 				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 				return false;
 			}
 			
 			
 			
 			
 	}
 	
 	/**
 	 * List Web elements 
 	 * @param driver
 	 * @param object
 	 * @return
 	 * @throws IOException 
 	 */
 	public static List<WebElement> findElements(final By elementBy) throws IOException{
 		  
 			return driver.findElements(elementBy);

  			}
 		
 	/**
 	 * Upload file
 	 * @param driver
 	 * @param value
 	 * @throws IOException 
 	 * 
 	 */
 	public static void uploadFile( By elementBy, String value) throws IOException{
 		findElement(elementBy).sendKeys(value);		  
 	}


 
  
 	
 public static void takesScreenshot(String ScreenshotName) throws IOException{
     
	    //Creating Object for Date
		Date date = new Date();
		//Creating object for time stamp
		Timestamp timestamp= new Timestamp(date.getTime());
		//converting date format to String
		String time=timestamp.toString();
		//replacing all spaces with '-'
		time = time.replace(' ', '-');
		//replacing all colons with '-'
		time = time.replace(':', '-'); 
		
		//Capturing screenshot as File output type 
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copying screenshot to local machine directory
		FileUtils.copyFile(screen, new File(System.getProperty("user.dir")+"\\Screenshots\\"+"_"+ScreenshotName+"_"+time+"_"+"_"+".jpg"));	

	}
 	
 	

	public static void handleMouseHover(WebDriver driver,By MouseHoverObject) throws IOException{
		
		
		Actions action = new Actions(driver);
		action.moveToElement(findElement(MouseHoverObject)).build().perform();
		
	}
	
	public static void handleDragAndDrop(WebDriver driver,By dragLocator,By dropLocator) throws IOException{
		
		Actions action = new Actions(driver);
		action.dragAndDrop(findElement(dragLocator), findElement(dropLocator)).build().perform();
		
		
	}
 
 
 
 
 }
 
 
 
 
 
 
 
 
 
 
 
 
 	
 	
 	
 	
 
