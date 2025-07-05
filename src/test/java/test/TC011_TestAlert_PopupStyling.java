package test;

import java.time.Duration;

import org.openqa.selenium.Alert;
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

public class TC011_TestAlert_PopupStyling extends BaseTest 
{
//Test alert and popup styling
//Scenario: Trigger alerts or popups (e.g., Add to Cart or Purchase).
//Expected: Alerts are styled properly and are readable.
	
	
	@Test
	public void verify_alerts() throws InterruptedException
	{
		logger.info("********Starting TC011_TestAlert_PopupStyling**********" );

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

		HomePage hp=new HomePage(driver);
		hp.clickloginHPM();
		
		LoginPage lp=new LoginPage(driver);
		wait.until(ExpectedConditions.visibilityOf(lp.unameLP()));
		lp.login(p.getProperty("validuname"), p.getProperty("validpwd"));
		wait.until(ExpectedConditions.invisibilityOf(lp.unameLP()));
		
		WelcomePage wp=new WelcomePage(driver);
		wp.selectProduct1WPM();
		
		ProductSpecPage psp=new ProductSpecPage(driver);
		psp.clickaddtocartPSPM();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String alerttext=alert.getText();
		System.out.println("1st assert");
		System.out.println("Alert text is"+alerttext);
		Assert.assertTrue(alerttext.toLowerCase().contains("product added"),"Alert msg not readable");
		alert.accept();
		psp.getgotocartPSPM();
		
		ViewCartPage vcp=new ViewCartPage(driver);
		vcp.clickPlaceorderVCPM();
		wait.until(ExpectedConditions.visibilityOf(vcp.getfirstProductVCPM()));
		System.out.println("2before");
		wait.until(ExpectedConditions.visibilityOf(vcp.getmodelappear()));
		//Thread.sleep(4000);
		boolean ismodaldisplayed=vcp.getmodelappear().isDisplayed();
		System.out.println("2nd assert");

		Assert.assertTrue(ismodaldisplayed,"modalnot displayed");
		
		PlaceOrderPage pop=new PlaceOrderPage(driver);
		pop.fillPOCM(p.getProperty("PName"), p.getProperty("PCountry"),
				p.getProperty("PCity"), p.getProperty("PCreditcard"), 
				p.getProperty("PMonth"), p.getProperty("PYear"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(pop.getthankyouelem()));
		//Thread.sleep(4000);
		boolean alertdisplayed=pop.eleFormGroupDisplayed().isDisplayed();
		System.out.println("3rd assert");

		Assert.assertTrue(alertdisplayed,"3rd not displayed");
		pop.clickOkPOCM();
		pop.clickClosePOCM();
		wait.until(ExpectedConditions.elementToBeClickable(wp.getLogoutWP()));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		wp.clickLogoutWPM();	
		
	}

}
