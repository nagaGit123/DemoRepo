package com.crl.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crl.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public Properties prop;
	
	
public TestBase()
{
	try {
		prop=new Properties();
		
	FileInputStream ip=new FileInputStream("D:\\EC\\Hybrid\\src\\main\\java\\com\\crl\\qa\\config\\config.properties");
	try {
		prop.load(ip);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	catch(FileNotFoundException e){
		e.printStackTrace();
		
		
	}
}



public  void initialization() {
	String browserName=prop.getProperty("browser");
	
	if(browserName.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\EC\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	else if(browserName.equals("firefox")) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\EC\\chromedriver.exe");
		driver= new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
	driver.get(prop.getProperty("url"));
	
	
}





	
}
