package com.test.PageObjcects;

import java.io.IOException;

import org.openqa.selenium.By;

import com.framework.core.BaseClass;
import com.framework.core.CommonMethod;

public class RegistrationPage extends BaseClass {
	
	
	public static By title = By.xpath("html/body/div[2]/div/h3/span");
	
	public static By logout = By.xpath("html/body/div[2]/div/h3/a");
	
	
	public void clickOnLogout() throws IOException{
		
		
		CommonMethod.click(logout);
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
