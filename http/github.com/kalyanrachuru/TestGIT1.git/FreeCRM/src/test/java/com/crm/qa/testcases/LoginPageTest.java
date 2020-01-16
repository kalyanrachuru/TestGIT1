package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	HomePage  hp;
	
	public LoginPageTest() {
		super();
		
	}
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
	}
	
	@Test(priority=1)
	public   void LoginPageTitleTest() {
		String title = lp.validateLoginPageTitle();
		Assert.assertEquals(title,"Cogmento CRM");
		
	}
	@Test(priority=2)
	public void loginTest() {
		hp = lp.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void closeBrowser() {
		//driver.quit();
		
	}
}
