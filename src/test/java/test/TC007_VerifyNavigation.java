package test;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import pages.WelcomePage;

public class TC007_VerifyNavigation extends BaseTest
{
	@BeforeMethod
	public void methodsetup()
	{
		HomePage hp=new HomePage(driver);
		hp.clickloginHPM();
		
		LoginPage lp=new LoginPage(driver);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(lp.unameLP()));
		lp.login(p.getProperty("validuname"), p.getProperty("validpwd"));
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.invisibilityOf(lp.unameLP()));
		

		
	}
	//Verify home navigation

	@Test
	public void verify_home()
	{
		logger.info("********Starting TC007_VerifyNavigation**********" );

		WelcomePage wp=new WelcomePage(driver);

		wp.clickHomeWP();
		HomePage hp=new HomePage(driver);
		List<WebElement> getAllelemHp=hp.getAlleleHP();
		HashSet<String> actualset =new HashSet<String>();
		for(WebElement prod:getAllelemHp)
		{
			actualset.add(prod.getText());
		}
		HashSet<String> expected=hp.getAllElementsHP();
		wp.clickLogoutWPM();
		Assert.assertEquals(actualset, expected);
				
	}
	//Navigate using navbar links

	@Test
	public void verify_navg() throws InterruptedException
	{
		WelcomePage wp=new WelcomePage(driver);
		wp.clickHomeWP();
		String actualhomeurl=driver.getCurrentUrl();
		System.out.println("home url"+driver.getCurrentUrl());
		HomePage hp=new HomePage(driver);
		hp.clickCartHP();
		String actualcarturl=driver.getCurrentUrl();
		System.out.println("cart url"+driver.getCurrentUrl());
		driver.navigate().back();
		hp.clickContactHP();
		ContactPage cp=new ContactPage(driver);

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(cp.contactlabel()));
		boolean iscontactlblvsb=cp.iscontlblvisible();
		cp.clickClose();
		wp.clickLogoutWPM();
		//Logout Functionality
		//Verify logout after login

		boolean loginvisinhp=hp.loginVis();
		String expectedhomeurl="https://www.demoblaze.com/index.html";
		String expectedcarturl="https://www.demoblaze.com/cart.html";
		
		
		Assert.assertEquals(actualhomeurl, expectedhomeurl);
		Assert.assertEquals(actualcarturl, expectedcarturl);
		
		Assert.assertTrue(iscontactlblvsb);
		Assert.assertTrue(loginvisinhp);


	}
}
