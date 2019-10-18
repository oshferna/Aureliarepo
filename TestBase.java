package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.util;

public class TestBase {

	public static  WebDriver driver;
	public static Properties prop;
	

	//create constructor of TestBase class
	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\oshferna\\eclipse-workspace\\urbanladder\\src\\main\\java\\com\\qa\\config\\config");
		    prop.load(ip);
		    } 
		 catch (FileNotFoundException e) {
			 e.printStackTrace();
			 } 
		 catch (IOException e) {
			 e.printStackTrace();
			 }
		}
	
	
	public  static WebDriver initialization(){
			
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\oshferna\\eclipse-workspace\\urbanladder\\soft\\chromedriver.exe");
			driver = new ChromeDriver();
	        System.out.println("Chrome Web Driver initilization has started...");
		} 
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\oshferna\\eclipse-workspace\\urbanladder\\software\\chromedriver.exe");
			driver = new FirefoxDriver();
	        System.out.println("Firefox Web Driver initilization has started...");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(util.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		return driver;
		
	}
	

}
