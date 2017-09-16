package com.test.PageObjcects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Command;
import org.testng.annotations.Test;

import com.framework.core.BaseClass;
import com.framework.core.CommonMethod;

public class LoginPage extends BaseClass {
	
	
	public static By usernameelement = By.xpath("//input[@name='username']");
	public static By passwordelement = By.xpath("//input[@name='password']");
	public static By submit = By.xpath("//input[@name='submit']");
	
		
	

	public void login() throws IOException{
		//String username = excel.getCellData("Login", 1, 0);
		//String password = excel.getCellData("Login", 1, 1);
		CommonMethod.clear(usernameelement);
		CommonMethod.sendKeys(usernameelement, "admin");
		CommonMethod.sendKeys(passwordelement, "admin");	
		CommonMethod.click(submit);
		CommonMethod.takesScreenshot("After login");
	}

	
	
	
	
	
	
}
