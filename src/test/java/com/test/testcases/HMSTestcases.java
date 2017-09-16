package com.test.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.core.BaseClass;
import com.framework.core.CommonMethod;
import com.test.PageObjcects.HomePage;
import com.test.PageObjcects.LoginPage;
import com.test.PageObjcects.RegistrationPage;

public class HMSTestcases extends BaseClass {
	
	LoginPage login = new LoginPage();
	HomePage home = new HomePage();
	RegistrationPage rpage = new RegistrationPage();
	
	@Test
	public void verifyLoginTest() throws IOException{
		
		login.login();
		CommonMethod.explicitWait(20, HomePage.RegistrationElement);
		Assert.assertTrue(CommonMethod.isElementPresent(HomePage.RegistrationElement));
		home.clickOnRegistrationLink();
		Assert.assertTrue(CommonMethod.isElementPresent(RegistrationPage.title));
		rpage.clickOnLogout();
		Assert.assertTrue(CommonMethod.isElementPresent(LoginPage.submit));
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
