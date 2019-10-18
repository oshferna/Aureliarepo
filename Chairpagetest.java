package testpackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.SearchPage;
import com.qa.pages.addrespage;
import com.qa.pages.addtocartpage;
import com.qa.pages.chairpage;
import com.qa.pages.productpage;
import com.qa.pages.studychairpages;

public class Chairpagetest extends TestBase{
	SearchPage srch;
	LoginPage loginPage;
	addtocartpage addcart;
	productpage prod;
	addrespage addi;
	studychairpages stdypgs;
	chairpage charp;
	public Chairpagetest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		charp=new chairpage();
		stdypgs=new studychairpages();
		addi=new addrespage();
		srch=new SearchPage();
		loginPage = new LoginPage();
		addcart=new addtocartpage();
		prod=new productpage();//create object of login page class
		srch=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//prod=srch.searchproduct(prop.getProperty("val"));
		
	}
	

	
	@Test(priority=1)
	public void studymethodtest() throws InterruptedException {
		charp=stdypgs.studypasge();
		Thread.sleep(2000);
		String Parentwindow = driver.getWindowHandle();
	 	for(String Child : driver.getWindowHandles())
	 		{
	 			driver.switchTo().window(Child);
	 		}
		addcart=prod.pdpage();
		addi=prod.address(prop.getProperty("code"), prop.getProperty("adds"), prop.getProperty("ftsname"), prop.getProperty("lstname"), prop.getProperty("phn"));
	}
	
	@AfterMethod
	public void tearDown(){
	//	driver.close();
}
} 
