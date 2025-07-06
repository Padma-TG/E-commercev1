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
import pages.WelcomePage;

public class TC002_LoginTest extends BaseTest
{
	@Test(dataProvider="data",dataProviderClass=utility.DataProviderC.class,groups={"sanity","smoke"})
	public void verify_login(String testcase,String username,String pwd,String expected)
	{
		logger.info("********Starting TC002_LoginTest**********" );

		HomePage hp=new HomePage(driver);
		hp.clickloginHPM();
		
		LoginPage lp=new LoginPage(driver);

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(lp.unameLP()));
		lp.login(username, pwd);
		
		if(testcase.equalsIgnoreCase("Valid"))
		{
			WelcomePage wp=new WelcomePage(driver);
			String actMsg=wp.disMsg();

			wp.clickLogoutWPM();
			WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(20));
			wait3.until(ExpectedConditions.visibilityOf(hp.loginelehp()));
			String ogexp=expected+" "+username;
			Assert.assertEquals(actMsg, ogexp,"Login welcome message mismatch");			
		}
		else
		{
			WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			String actMsg=alert.getText();
			alert.accept();
			lp.clickcloseLP();
			System.out.println("actual "+actMsg);
			System.out.println("expected "+expected);
			Assert.assertEquals(actMsg, expected.trim(),"Error in Invalid");	
			
		}
		
	}
}
