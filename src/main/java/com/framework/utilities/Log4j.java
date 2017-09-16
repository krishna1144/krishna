package com.framework.utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log4j {
	
	Properties prop ;
	public static Logger log;
	
	
	public void setup() throws IOException{
		
		log = Logger.getLogger(getClass());
		
		prop = new Properties();
		FileInputStream file = new FileInputStream("E:/Workspace/Framework/src/main/resources/configuration/log4j.properties");
		prop.load(file);
		
		PropertyConfigurator.configure(prop);
		
		log.info("info message");
		log.error("error messgage");
		
		
	}

	
	
	
	

}
