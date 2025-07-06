package test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaceOrderPage;
import pages.ProductSpecPage;
import pages.ViewCartPage;
import pages.WelcomePage;

public class TC004_PlaceOrder extends BaseTest
{
	//Place order with valid details
	//Verify order confirmation popup
	@Test(priority=1,groups= {"smoke"})
	public void verify_placeOrder() throws InterruptedException
	{
		logger.info("********Starting TC004_PlaceOrder**********" );

		HomePage hp=new HomePage(driver);
		hp.clickloginHPM();
		
		LoginPage lp=new LoginPage(driver);
		lp.login(p.getProperty("validuname"),p.getProperty("validpwd"));
		WelcomePage wp=new WelcomePage(driver);

		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOf(wp.eledisMsg()));

		wp.selectProduct1WPM();
		
		ProductSpecPage pcp=new ProductSpecPage(driver);
		pcp.clickaddtocartPSPM();
		acceptAlert();
		pcp.getgotocartPSPM();
		ViewCartPage vcp=new ViewCartPage(driver);

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(vcp.getimgdisVCPM()));
		
		vcp.clickPlaceorderVCPM();
		
		PlaceOrderPage pop=new PlaceOrderPage(driver);
		pop.fillPOCM(p.getProperty("PName"), p.getProperty("PCountry"), 
				p.getProperty("PCity"), p.getProperty("PCreditcard"), 
				p.getProperty("PMonth"), p.getProperty("PYear"));
		
		String actMsg=pop.thankyouPOCM();
		
		System.out.println(actMsg);
		String confirmationmsg=pop.getConfirmationPOCM();
		System.out.println("Confirmation Message:\n" + confirmationmsg);
		boolean status=(confirmationmsg.contains("Id:") && confirmationmsg.contains("Amount:"));
		pop.clickOkPOCM();
		WebDriverWait waitDismiss = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitDismiss.until(ExpectedConditions.invisibilityOf(pop.getthankyouelem()));
		pop.clickClosePOCM();


		WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOf(wp.elelogoutWPM()));
		
		wp.clickLogoutWPM();
		Assert.assertTrue(status);
		Assert.assertEquals(actMsg, p.getProperty("placedorderMsg"));		
	}
	//Place order with empty form
	@Test(priority=2)
	public void verify_emptyField()
	{
		HomePage hp=new HomePage(driver);
		hp.clickloginHPM();
		
		LoginPage lp=new LoginPage(driver);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(lp.unameLP()));
		lp.login(p.getProperty("validuname"),p.getProperty("validpwd"));
		WelcomePage wp=new WelcomePage(driver);

		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOf(wp.eledisMsg()));

		wp.selectProduct1WPM();
		
		ProductSpecPage pcp=new ProductSpecPage(driver);
		pcp.clickaddtocartPSPM();
		acceptAlert();
		pcp.getgotocartPSPM();
		ViewCartPage vcp=new ViewCartPage(driver);

		WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOf(vcp.getimgdisVCPM()));
		
		vcp.clickPlaceorderVCPM();
		
		PlaceOrderPage pop=new PlaceOrderPage(driver);
		pop.fillPOCM("", "", "", "", "" ,"");
		String alertErr=getAndAcceptAlertText();
		
		System.out.println(alertErr);
		pop.clickClosePOCM();
		wp.clickLogoutWPM();
		Assert.assertEquals(alertErr, "Please fill out Name and Creditcard.");
		

	}
}
