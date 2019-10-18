package testpackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.SearchPage;
import com.qa.pages.productpage;


public class SearchTest extends TestBase{
	SearchPage srch;
	LoginPage loginPage;
	productpage prod;
	
	public SearchTest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage = new LoginPage(); //create object of login page class
		srch=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		prod=new productpage();
	}
	
	@Test
	public void serachtest() throws InterruptedException{
		//System.out.println(prop.getProperty("val"));
		prod=srch.searchproduct(prop.getProperty("val"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
}
	
	
	
	
	
	
	
}
