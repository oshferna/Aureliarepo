package testpackage;
import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.SearchPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginTest extends TestBase{
	SearchPage srch;
	LoginPage loginPage;
	public LoginTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage(); //create object of login page class
	}
	
	@Test(priority=2)
	public void loginPageTitleTest(){
		String title = loginPage.validateloginpagetitle();
		Assert.assertEquals(title, "Furniture Online: Buy Home Wooden Furniture Online At Best Prices - Urban Ladder");
	}
	
	@Test(priority=3)
	public void validateImage(){
		boolean flag = loginPage.validateImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		srch=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
}
}
	