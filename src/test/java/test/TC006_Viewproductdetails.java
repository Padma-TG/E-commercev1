package test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductSpecPage;
import pages.WelcomePage;

public class TC006_Viewproductdetails extends BaseTest
{
	//View product details

	@Test
	public void verify_productDetails()
	{
		logger.info("********Starting TC006_Viewproductdetails**********" );

		HomePage hp=new HomePage(driver);
		hp.clickloginHPM();
		
		LoginPage lp=new LoginPage(driver);
		lp.login(p.getProperty("validuname"), p.getProperty("validpwd"));
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.invisibilityOf(lp.unameLP()));
		
		WelcomePage wp=new WelcomePage(driver);
		wp.selectProduct1WPM();
		
		ProductSpecPage psp=new ProductSpecPage(driver);
		boolean istitlepresent=psp.chcktitlePSP();
		boolean ispricepresent=psp.chckpricePSP();
		boolean isproductdesc=psp.chckprodDes();
		Assert.assertTrue(istitlepresent);
		Assert.assertTrue(ispricepresent);
		Assert.assertTrue(isproductdesc);
		wp.clickLogoutWPM();
		
		
	}
}
