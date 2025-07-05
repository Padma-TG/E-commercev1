package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.PhonesPage;
import pages.WelcomePage;

public class demo2ui extends BaseTest
{
	WelcomePage wp;
	PhonesPage pp;
	public void login()
	{
		HomePage hp=new HomePage(driver);
		hp.clickloginHPM();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		
		LoginPage lp=new LoginPage(driver);
		lp.login(p.getProperty("validuname"), p.getProperty("validpwd"));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(lp.unameLP()));
	}
	
	public void selectCategory(String cname)
	{
		wp=new WelcomePage(driver);
		switch(cname.toLowerCase())
		{
		case "home":
			wp.clickHomeWP();
			break;
		case "phones":
			wp.clickphonesWPM();
			break;
		case "laptops":
			wp.clickcartWPM();
			break;
		case "monitors":
			wp.clickMonitorsWPM();
			break;
		default:
			throw new IllegalArgumentException("Unknown category: " +cname);
		}
	}
	public void verifyProductAlignment(List<WebElement> tiles) 
	{
		Assert.assertTrue(tiles.size()>0,"No tiles found");
		WebElement firstTile=tiles.get(0);
		int expectedWidth=firstTile.getSize().getWidth();
		int expectedHeight=firstTile.getSize().getHeight();
		int expectedlocX=firstTile.getLocation().getX();
		int expectedlocY=firstTile.getLocation().getY();
		
		for(int i=1;i<tiles.size();i++)
		{
			WebElement tile=tiles.get(i);
			int actualWidth=tile.getSize().getWidth();
			int actualHeight=tile.getSize().getHeight();
			int actuallocX=tile.getLocation().getX();
			int actuallocY=tile.getLocation().getY();
			
			System.out.println("Tiles found: " + tiles.size());

			Assert.assertEquals(actualWidth, expectedWidth);
			Assert.assertEquals(actualHeight, expectedHeight);
			Assert.assertEquals(actuallocX, expectedlocX);
			Assert.assertEquals(actuallocY, expectedlocY);
		}
		System.out.println("All good");
	}
	
	@Test
	public void hometestalignment()
	{
		login();
		selectCategory("home");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		HomePage hp=new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(hp.getProductCards()));
		List<WebElement> tiles=hp.getProductCards();
		verifyProductAlignment(tiles);
		wp.clickLogoutWPM();
		}
	@Test
	public void phonestestalignment()
	{
		login();

		selectCategory("Phones");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(wp.getprodtileslist()));
		pp=new PhonesPage(driver);
		List<WebElement> tiles=pp.eleAllPPM();
		verifyProductAlignment(tiles);
		wp.clickLogoutWPM();
		}
	@Test
	public void laptoptestalignment()
	{		
		selectCategory("laptops");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(wp.getprodtileslist()));
		wp=new WelcomePage(driver);
		List<WebElement> tiles=wp.getprodtileslist();
		verifyProductAlignment(tiles);
		driver.navigate().back();

		}
	@Test
	public void monitortestalignment()
	{
		
		selectCategory("monitors");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(wp.getprodtileslist()));
		wp=new WelcomePage(driver);
		List<WebElement> tiles=wp.getprodtileslist();
		verifyProductAlignment(tiles);
		driver.navigate().back();

		}
	


}
