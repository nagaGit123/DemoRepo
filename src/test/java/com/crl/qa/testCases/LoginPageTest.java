package com.crl.qa.testCases;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crl.qa.base.TestBase;
import com.crl.qa.pages.HomePage;
import com.crl.qa.pages.LoginPage;
import com.crl.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	public LoginPage lp;
	public HomePage hp;
	public LoginPageTest() {
		super();
	}   
	
	@BeforeMethod
public void setUp() {
		initialization();
		lp= new LoginPage();
	
		
	}
	
	/*
	 * @Test(priority=1) public void loginPageTitleTest() { String
	 * title=lp.validateTitle(); System.out.println(title); }
	 */
	
	@Test
	public void test() {

		lp.logincl();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		//lp.loginToApplication(prop.getProperty("name"), prop.getProperty("password"));
		lp.login(prop.getProperty("name"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
}
