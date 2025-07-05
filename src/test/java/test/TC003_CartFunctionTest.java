package test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductSpecPage;
import pages.ViewCartPage;
import pages.WelcomePage;

public class TC003_CartFunctionTest extends BaseTest
{
	//Add product to cart
	//Add multiple products to cart
	//Expected: Cart displays the added products with title and price.


	@Test(priority=1)
	public void verify_addtoCart() throws InterruptedException
	{
		logger.info("********Starting TC003_CartFunctionTest**********" );

		HomePage hp=new HomePage(driver);
		hp.clickloginHPM();
		
		LoginPage lp=new LoginPage(driver);
		lp.login(p.getProperty("validuname"),p.getProperty("validpwd"));
		Thread.sleep(5000);
		
		WelcomePage wp=new WelcomePage(driver);
		wp.selectProduct1WPM();
		
		ProductSpecPage psp=new ProductSpecPage(driver);
		psp.clickaddtocartPSPM();
		String actualMsg1=getAndAcceptAlertText();
		 psp.clickHomebtnPSPM();
		
		wp.selectProduct2WPM();
		psp.clickaddtocartPSPM();
		acceptAlert();
		
		psp.getgotocartPSPM();
		ViewCartPage vcp=new ViewCartPage(driver);
		Thread.sleep(7000);
		List<String> getAllcartval=vcp.getaddedproductsVCPM();
	    List<Integer> actualPrices = vcp.getaddedpricesVCPM(); // You should write this method if not yet

	    //arrays.aslist=Useful for writing expected values quickly.
	  //  It's a Java method that creates a fixed-size list from given values. 


		List<String> expectedProducts = Arrays.asList("Samsung galaxy s6", "Nokia lumia 1520");
	    List<Integer> expectedPrices = Arrays.asList(360, 820); // Update with actual site prices

		
		psp.clickLogoutPSP();		
		
		Assert.assertTrue(getAllcartval.containsAll(expectedProducts));
	    Assert.assertTrue(actualPrices.containsAll(expectedPrices), "Cart does not have all expected prices.");

		
		Assert.assertEquals(actualMsg1.trim(), p.getProperty("expproductAddedMsg".trim()));

	}
	//View cart with added products
	//Remove product from cart

	@Test(priority=2)
	public void verify_addedCart() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);		
		hp.clickloginHPM();
		
		LoginPage lp=new LoginPage(driver);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(lp.unameLP()));
		lp.login(p.getProperty("validuname"),p.getProperty("validpwd"));
		
		WelcomePage wp=new WelcomePage(driver);
		WebDriverWait wait4=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait4.until(ExpectedConditions.visibilityOf(wp.eledisMsg()));

		wp.selectProduct2WPM();
		
		ProductSpecPage psp=new ProductSpecPage(driver);
		psp.clickaddtocartPSPM();
		acceptAlert();
		psp.clickaddtocartPSPM();
		acceptAlert();
		wp.clickcartWPM();
		ViewCartPage vcp=new ViewCartPage(driver);

		driver.navigate().refresh();
		WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOfAllElements(vcp.getAddedProductElementsVCPM()));
				
		List<String> actProducts=vcp.getaddedproductsVCPM();
		String expectedproduct="Nokia lumia 1520";
		System.out.println("Expected product: " + expectedproduct);
		System.out.println("Actual products in cart: " + actProducts);
		
		int bftotalVal=vcp.getTotalVCPM();
		int priceofdeleted=vcp.getfirstPriceVCPM();
		int expectedVal = bftotalVal - priceofdeleted;  
		
		vcp.getdeleteVCPM();
		Thread.sleep(4000);
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait3.until(ExpectedConditions.visibilityOf(vcp.gettotalelementVSPM()));
		driver.navigate().refresh();
		Thread.sleep(4000);
		int actafttotVal=vcp.getTotalVCPM();
		Assert.assertEquals(actafttotVal, expectedVal);
		Assert.assertTrue(actProducts.contains(expectedproduct));		
		
	}
}
