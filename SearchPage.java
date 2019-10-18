package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class SearchPage  extends TestBase {
	@FindBy(xpath="(//input[@type='search'])[2]")
	WebElement search;
	@FindBy(xpath="//button[@id='search_button']")
	WebElement searchbtn;
	@FindBy(xpath="//img[@src='https://www.ulcdn.net/images/products/42901/product/Ormond_Coffee_Table_00_LP.jpg?1437137050']")
	WebElement img;
	
	public SearchPage()
	{
		PageFactory.initElements(driver, this);
	}

	
	public productpage searchproduct(String val){
		// TODO Auto-generated method stub
		search.sendKeys(val);
		searchbtn.click();
		img.click();
		return new productpage();
		
		
	}


	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}	
	

