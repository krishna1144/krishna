package com.test.PageObjcects;
import java.io.IOException;

import org.openqa.selenium.By;

import com.framework.core.BaseClass;
import com.framework.core.CommonMethod;

public class HomePage extends BaseClass {
	
	public static By RegistrationElement = By.linkText("Registration");
	public static By ADTElement = By.linkText("ADT");
	public static By FeedbackElement = By.linkText("Feedback");
	public static By HelpLineElement = By.linkText("Help Line");
	
	
	
public void clickOnRegistrationLink() throws IOException{
	
	
	CommonMethod.click(RegistrationElement);
}
	
	
	
public void clickOnADTLink() throws IOException{
		
		
		CommonMethod.click(RegistrationElement);
	}
	
	
public void clickOnFeedbackLink() throws IOException{
	
	
	CommonMethod.click(RegistrationElement);
}

public void clickOnHelpLineLink() throws IOException{
	
	
	CommonMethod.click(RegistrationElement);
}

	
	
	
	
	
	

}
