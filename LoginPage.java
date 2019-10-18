package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
@FindBy(xpath="//a[.='Log-in']")
WebElement lgn;
@FindBy(xpath="(//input[@id='spree_user_email'])[2]")
 WebElement email;
@FindBy(xpath="(//input[@id='spree_user_password'])[3]")
 WebElement password;
@FindBy(xpath="(//input[@type='submit'])[3]")
 WebElement login;
@FindBy(xpath="(//figure[@class='header__topBar_logo'])")
WebElement logo;

public LoginPage()
{
	PageFactory.initElements(driver, this);
}


public String validateloginpagetitle()
{
	return driver.getTitle();
	
}

public boolean validateImage(){
	return logo.isDisplayed();
}


public SearchPage login (String un, String pwd) throws InterruptedException{
	
	lgn.click();
	Thread.sleep(5000);
	email.sendKeys(un);
	password.sendKeys(pwd);
	login.click();
	return new SearchPage();


}

}
