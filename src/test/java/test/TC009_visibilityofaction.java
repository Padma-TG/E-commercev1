package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductSpecPage;
import pages.SignUpPage;
import pages.ViewCartPage;
import pages.WelcomePage;
//Scenario: View "Add to Cart", "Log in", and "Sign up" buttons.
//Expected: Buttons are visible and clickable.

public class TC009_visibilityofaction extends BaseTest 
{
@Test
public void verify_visibility() throws InterruptedException
{
	logger.info("********Starting TC009_visibilityofaction**********" );

	HomePage hp=new HomePage(driver);
	hp.clickloginHPM();
	
	LoginPage lp=new LoginPage(driver);
	lp.login(p.getProperty("validuname"), p.getProperty("validpwd"));
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.invisibilityOf(lp.unameLP()));
	
	WelcomePage wp=new WelcomePage(driver);
	wp.selectProduct1WPM();
	//Thread.sleep(6000);
	
	ProductSpecPage psp=new ProductSpecPage(driver);
	String expected=psp.getTitle();
	boolean addtocartdisp=psp.gotoCartelemPSPM().isDisplayed();
	boolean addtocartenab=psp.gotoCartelemPSPM().isEnabled();
	
	psp.clickaddtocartPSPM();
	
	acceptAlert();
	psp.getgotocartPSPM();
	
	
	ViewCartPage vcp=new ViewCartPage(driver);
	String actual=vcp.getaddedfirst();
	vcp.clicklogoutvcp();
	System.out.println("actual is "+actual+"expected is "+expected);
	Assert.assertTrue(addtocartdisp, "Add to Cart button not visible");
	Assert.assertTrue(addtocartenab, "Add to Cart button not enabled");

	Assert.assertEquals(actual, expected);
}
@Test
public void visibility1() throws InterruptedException
{
	HomePage hp=new HomePage(driver);
	boolean visibilityofsignuphp=hp.signupbtnelehp().isEnabled();
	System.out.println("signupenabled"+visibilityofsignuphp);
			hp.clicksignupHPM();
			SignUpPage sp=new SignUpPage(driver);
			Thread.sleep(6000);
	boolean visibilityofsignupTitle=sp.titledisSU().isDisplayed();
	System.out.println("signuptitledisp "+visibilityofsignupTitle);
	sp.xcloseclick();
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("signInModal")));

	boolean visibilityofloginhp=hp.loginelehp().isEnabled();
	System.out.println("logininhp "+visibilityofloginhp);
	hp.clickloginHPM();
	LoginPage lp=new LoginPage(driver);
	Thread.sleep(6000);
	boolean visibilityofloginTitle=lp.loginEletitleLP().isDisplayed();
	System.out.println("logintitlelp "+visibilityofloginTitle);
	lp.clickcloseLP();
	
	
	
	Assert.assertTrue(visibilityofsignuphp);
	Assert.assertTrue(visibilityofsignupTitle);
	Assert.assertTrue(visibilityofloginhp);
	Assert.assertTrue(visibilityofloginTitle);
	
}
}
