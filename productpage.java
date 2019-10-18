package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class productpage extends TestBase
{
	@FindBy(xpath="//button[@id='add-to-cart-button']")
	WebElement buttonclick;
	@FindBy(xpath="(//button[.='Checkout'])[1]")
	WebElement checkout;
	@FindBy(name="order[ship_address_attributes][zipcode]")
	WebElement pincode;
	@FindBy(name="order[ship_address_attributes][address1]")
	WebElement address;
	@FindBy(name="order[ship_address_attributes][firstname]")
	WebElement firstname;
	@FindBy(name="order[ship_address_attributes][lastname]")
	WebElement lastname;
	@FindBy(name="order[ship_address_attributes][phone]")
	WebElement phno;
	@FindBy(name="commit")
	WebElement save;
	@FindBy(xpath="//div[@id='cart-badge']")
	WebElement items;


	public productpage()
	{
		PageFactory.initElements(driver, this);
	}


	public String validateprodpagetitle()
	{
		return driver.getTitle();
	}

	public addrespage address(String code,String adds,String ftsname,String lstname,String phn)
	{	//items.click();
		checkout.click();
		pincode.sendKeys(code);
		address.sendKeys(adds);
		firstname.sendKeys(ftsname);
		lastname.sendKeys(lstname);
		phno.sendKeys(phn);
		save.click();
		return new addrespage();
	}

	public addtocartpage pdpage () throws InterruptedException
	{
		
		buttonclick.click();	
		return new addtocartpage();


	}
	
}
