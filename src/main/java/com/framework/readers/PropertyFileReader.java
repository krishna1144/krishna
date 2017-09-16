package com.framework.readers;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	
	static Properties prop = new Properties();
	
	public static String getData(String key) throws IOException{
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/configuration/environment.properties");
		prop.load(file);
		
		String value = prop.getProperty(key);
		return value;
		
	
		
	}
	

}
