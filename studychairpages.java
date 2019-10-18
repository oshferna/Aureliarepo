package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class studychairpages extends TestBase {

	
	@FindBy(xpath="//img[@title='Venturi Study Chair-3 Axis Adjustable (Carbon Black)']")
	WebElement topname;
	@FindBy(xpath="//span[.='Study Chairs']")
	WebElement study;

	public studychairpages()
	{
		PageFactory.initElements(driver, this);
	}
	
	public chairpage studypasge () throws InterruptedException
	{
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("(//span[@class='topnav_itemname'])[6]"));
		action.moveToElement(we).build().perform();
		study.click();
		topname.click();
		return new chairpage();


	}
	

}
