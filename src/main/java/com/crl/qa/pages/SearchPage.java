package com.crl.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crl.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//page Factory-OR
		@FindBy(xpath="//a[contains(text(),'Login')]")
		WebElement lgoin;
	public void logincl()
	{
		lgoin.click();
	}

	//Initializing page objects
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
	//Page Factory - OR:
		@FindBy(name="email")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginBtn;
	
	public HomePage login(String un, String pwd){
		//username.sendKeys(un);
		//password.sendKeys(pwd);
		//loginBtn.click();
		System.out.println("before entering un:"+un);
		driver.findElement(By.name("email")).sendKeys(un);
		System.out.println("after entering un:"+un);
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}

}
