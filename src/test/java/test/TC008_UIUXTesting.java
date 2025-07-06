package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.WelcomePage;

public class TC008_UIUXTesting extends BaseTest
{
	WelcomePage wp;
	HomePage hp;
	@BeforeMethod
	public void setupforui()
	{
		logger.info("********Starting TC008_UIUXTesting**********" );

		hp=new HomePage(driver);
		hp.clickloginHPM();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		LoginPage lp=new LoginPage(driver);
		lp.login(p.getProperty("validuname"), p.getProperty("validpwd"));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(lp.unameLP()));
		
	    wp=new WelcomePage(driver);
	    wp.clickHomeWP();
	}
	@AfterMethod
	public void close()
	{
		wp.clickLogoutWPM();
	}
	//checking height and width
@Test
public void verify_ui()
{
	List<WebElement> product_cards=hp.getProductTiles();

	WebElement firstTile=product_cards.get(0);

	int expectedWidth=firstTile.getSize().getWidth();
	System.out.println("ExpectedWidth="+expectedWidth);
	int expectedHeight=firstTile.getSize().getHeight();
	System.out.println("ExpectedHeight="+expectedHeight);
	for(int i=0;i<product_cards.size();i++)
	{
		WebElement tiles=product_cards.get(i);
		int actualWidth=tiles.getSize().getWidth();
		int actualHeight=tiles.getSize().getHeight();
		
		System.out.println("Actual values are"+i+"st iteration"+actualWidth+","+actualHeight);
		
		
		Assert.assertEquals(actualWidth, expectedWidth);
		Assert.assertEquals(actualHeight, expectedHeight);
		}
	
}
//checking x 
@Test
public void verify_x()
{
	List<WebElement> product_cards=hp.getProductTiles();

	WebElement firstcolTile=product_cards.get(0);
	int expectedX1=firstcolTile.getLocation().getX();
	
	WebElement secondcolTile=product_cards.get(1);
	int expectedX2=secondcolTile.getLocation().getX();
	
	WebElement thirdcolTile=product_cards.get(2);
	int expectedX3=thirdcolTile.getLocation().getX();
	
	System.out.println("Expected X1 ="+expectedX1);
	System.out.println("Expected X2 ="+expectedX2);
	System.out.println("Expected X3 ="+expectedX3);

	for(int i=0;i<product_cards.size();i++)
	{
		WebElement tiles=product_cards.get(i);
		int actualX=tiles.getLocation().getX();
		
		int columnindex=i%3;
		switch(columnindex)
		{
		case 0:
			System.out.println("ActualX1 is"+actualX+",ExpectedX1 is"+expectedX1+","+i);
			Assert.assertEquals(actualX, expectedX1);
			break;
		case 1:
			System.out.println("ActualX2 is"+actualX+",ExpectedX2 is"+expectedX2+","+i);

			Assert.assertEquals(actualX, expectedX2);
			break;
		case 2:
			System.out.println("ActualX3 is"+actualX+",ExpectedX3 is"+expectedX3+","+i);

			Assert.assertEquals(actualX, expectedX3);
			break;
		}
	}
}
	//checking y
	@Test
	public void verify_yy() throws InterruptedException	
	{
		List<WebElement> product_cards=hp.getProductCards();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(product_cards));
		int expectedY1=product_cards.get(0).getLocation().getY();
		int expectedY2=product_cards.get(4).getLocation().getY();
		int expectedY3=product_cards.get(6).getLocation().getY();
		
		for(int i=0;i<product_cards.size();i++)
		{
			WebElement tiles=product_cards.get(i);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tiles);
		    Thread.sleep(500);
			int actualY=tiles.getLocation().getY();
		if((i>=0)&&(i<=2))
		{
			System.out.println("ActualY1 is "+actualY+" ExpectedY1 "+expectedY1+"  "+i);
			Assert.assertEquals(actualY, expectedY1);
		}
		else if((i>=3)&&(i<=5))
		{
			System.out.println("ActualY12 is "+actualY+" ExpectedY2 "+expectedY2+"  "+i);
			Assert.assertEquals(actualY, expectedY2);
		}
		else if((i>=6)&&(i<=8))
		{
			System.out.println("ActualY3 is "+actualY+" ExpectedY3 "+expectedY3+"  "+i);
			Assert.assertEquals(actualY, expectedY3);
		}
		}
		
	}
	
}

