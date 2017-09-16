package com.framework.core;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.framework.readers.ExcelReader;
import com.framework.readers.PropertyFileReader;

public class BaseClass {
 
 public static WebDriver driver;
 public static ExcelReader excel ;
 public Properties prop ;
 public static Logger log;
 
 @BeforeClass
 @Parameters("browserName")
 public void setup(String browserName) throws IOException, InterruptedException{
	 
	 
	 //logs
	 
	    log = Logger.getLogger(getClass());
		
		prop = new Properties();
		FileInputStream file = new FileInputStream("E:/Workspace/Framework/src/main/resources/configuration/log4j.properties");
		prop.load(file);
		
		PropertyConfigurator.configure(prop);
	 
  log.info("initializing configuration");
  log.info("Choosen browser as "+browserName);

  //open Firefox Browser 
  //open the browser based on parameter passed in .xml file.
  if(browserName.equalsIgnoreCase("firefox")){
   

   //if you are using selenium 2.0
   driver = new FirefoxDriver();
   
   //if you are using selenium 3.0
   //System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");
   //driver = new FirefoxDriver(); 
  }
  else if(browserName.equalsIgnoreCase("chrome")){
   
   //open chrome browser
   System.setProperty("webdriver.chrome.driver", "E:\\Workspace\\Drivers\\chromedriver.exe");
   driver= new ChromeDriver();
  }
  
  else if(browserName.equalsIgnoreCase("ie")){
   //open Internet Explorer Browser
   System.setProperty("webdriver.ie.driver", "E:/Selenium Training/Driver Files/IEDriverServer.exe");
   driver= new InternetExplorerDriver();
   
  }
  else if(browserName.equalsIgnoreCase("opera")){
   //open opera Browser
   System.setProperty("webdriver.opera.driver", "E:/Selenium Training/Driver Files/operadriver.exe");
   driver= new OperaDriver();
   
  }
  else{
	  
	  log.error("Incorrect browser");
  }
  
  
  //maximizing window
  driver.manage().window().maximize();
  log.info("Maximizing window");
  
  String URL = PropertyFileReader.getData("HMS_URL");
  
  //Navigating URL
  driver.get(URL);
  
  log.info("Navigating URL "+URL);
  
  log.info("Loading config data from excel");
 //configuration of testdata
   excel = new ExcelReader(System.getProperty("user.dir")+"/src/main/resources/configuration/TestData.xlsx");
  
  
  
  

  }
 
 
 
 
 
 @AfterClass
 public void quit(){
	 
	 driver.quit();
	 log.info("Closing browser");
 }
 
 
 
 
 
 
 
}









