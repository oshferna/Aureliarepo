package testpackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.SearchPage;
import com.qa.pages.addrespage;
import com.qa.pages.addtocartpage;
import com.qa.pages.productpage;

public class Producttest extends TestBase{
	SearchPage srch;
	LoginPage loginPage;
	addtocartpage addcart;
	productpage prod;
	addrespage addi;
	
	public Producttest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		addi=new addrespage();
		srch=new SearchPage();
		loginPage = new LoginPage();
		addcart=new addtocartpage();
		prod=new productpage();//create object of login page class
		srch=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		prod=srch.searchproduct(prop.getProperty("val"));
		
	}
	
	/*@Test(priority=1)
	public void prodpagetitle() throws InterruptedException{
		Thread.sleep(2000);
		 String Parentwindow = driver.getWindowHandle();
		 	for(String Child : driver.getWindowHandles())
		 		{
		 			driver.switchTo().window(Child);
		 		}
		String title1 = prod.validateprodpagetitle();
		Assert.assertEquals(title1, "Ormond Coffee Table - Urban Ladder");
		
	}
	*/
	@Test(priority=1)
	public void productmethod() throws InterruptedException{
		Thread.sleep(2000);
		String Parentwindow = driver.getWindowHandle();
	 	for(String Child : driver.getWindowHandles())
	 		{
	 			driver.switchTo().window(Child);
	 		}
		addcart=prod.pdpage();
		Thread.sleep(3000);
		addi=prod.address(prop.getProperty("code"), prop.getProperty("adds"), prop.getProperty("ftsname"), prop.getProperty("lstname"), prop.getProperty("phn"));
	}
	
/*	@Test(priority=2)
	public void addressfill() throws InterruptedException {
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		String Parentwindow = driver.getWindowHandle();
	 	for(String Child : driver.getWindowHandles())
	 		{
	 			driver.switchTo().window(Child);
	 		}
	 	driver.get(prop.getProperty("checkout"));
		addi=prod.address(prop.getProperty("code"), prop.getProperty("adds"), prop.getProperty("ftsname"), prop.getProperty("lstname"), prop.getProperty("phn"));
	}*/
	
	@AfterMethod
	public void tearDown(){
		driver.close();
}
}
