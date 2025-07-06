package test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.HomePage;
import pages.SignUpPage;

public class TC001_SignUpTest extends BaseTest
{
	@Test(priority=1,groups= {"sanity"})
	public void verify_validsignup()
	{
		logger.info("********Starting TC001_SignUpTest**********" );
		HomePage hp=new HomePage(driver);
		hp.clicksignupHPM();
		SignUpPage sp=new SignUpPage(driver);
		sp.fullsignupSPM(randomeString(5), randomeAlphanum(6));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String actualMsgSP=alert.getText();
		System.out.println(actualMsgSP);
		alert.accept();
		String success="Sign up successful.";

		Assert.assertEquals(actualMsgSP, success);		
	}
	@Test(priority=2)
	public void invalid_signup() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		driver.navigate().refresh();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(hp.getAlleleHP()));
		hp.clicksignupHPM();
		
		SignUpPage sp=new SignUpPage(driver);
		sp.fullsignupSPM("PadmaGoutam", "123456");
		
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.alertIsPresent());

		Alert alert=driver.switchTo().alert();
		String actualMsgSP=alert.getText();
		alert.accept();
		sp.clickcloseSPM();
		String fail="This user already exist.";
		Assert.assertEquals(actualMsgSP, fail);
	}
	@Test(priority=3)
	public void emptyfield_signup()
	{
		HomePage hp=new HomePage(driver);
		driver.navigate().refresh();

		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(hp.getProductTiles()));
		hp.clicksignupHPM();
		
		SignUpPage sp=new SignUpPage(driver);
		
		sp.fullsignupSPM("", "");
		
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.alertIsPresent());

		Alert alert=driver.switchTo().alert();
		String actualMsgSP=alert.getText();
		alert.accept();
		sp.clickcloseSPM();
		String fail="Please fill out Username and Password.";
		Assert.assertEquals(actualMsgSP, fail);
		logger.info("********Finishing TC001_SignUpTest**********" );

	}

}
