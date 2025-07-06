package test;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
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
import pages.LaptopsPage;
import pages.LoginPage;
import pages.MonitorsPage;
import pages.PhonesPage;
import pages.WelcomePage;

public class TC005_CategoryProducttest extends BaseTest
{
    WelcomePage wp;
    PhonesPage pp;

    @BeforeMethod
    public void loginAndNavigate() {
        HomePage hp = new HomePage(driver);
        hp.clickloginHPM();

        LoginPage lp = new LoginPage(driver);
        lp.login(p.getProperty("validuname"), p.getProperty("validpwd"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(lp.unameLP()));

        wp = new WelcomePage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", wp.eleMonitors());
    }

    @AfterMethod
    public void logoutAfterEachTest() {
        if (wp != null) {
            wp.clickLogoutWPM();
        }
    }


	//Browse product categories (Phones, Laptops, Monitors)
	@Test(priority=1)
	public void verify_mobile() throws InterruptedException
	{
		logger.info("********Starting TC005_CategoryProducttest**********" );

		wp.clickphonesWPM();
		PhonesPage pp=new PhonesPage(driver);

		WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("card-title")));
		
		
		
		List<WebElement> getAllelem=pp.eleAllPPM();
		
		HashSet<String> actualProductNames=new HashSet<String>();
		for(WebElement prod:getAllelem)
		{
			actualProductNames.add(prod.getText());
		}
		
		HashSet<String> expected=pp.getmobilesetPPM();
		Assert.assertEquals(actualProductNames, expected);	
		
				
	}
	
	@Test(priority=2)
	public void verify_laptop() throws InterruptedException
	{
		wp.clicklaptopsWPM();
		//driver.manage().timeouts().getPageLoadTimeout();
		pp=new PhonesPage(driver);
		WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait3.until(ExpectedConditions.invisibilityOf(pp.getfirstEle()));
		LaptopsPage ltp=new LaptopsPage(driver);

		List<WebElement> getAllElelaptop=ltp.getallelemlap();
		HashSet<String> actualLapNames=new HashSet<String>();
		for(WebElement prod:getAllElelaptop)
		{
			actualLapNames.add(prod.getText());
		}
		HashSet<String> expectedlap=ltp.getLaptopsetLTPM();
		System.out.println("Actual laptops displayed: " + actualLapNames);
		System.out.println("Expected laptops: " + expectedlap);

		Assert.assertEquals(actualLapNames, expectedlap);
}
	@Test(priority=3)
	public void verify_Monitors() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(wp.eleMonitors()));
		wp.clickMonitorsWPM();
		//Thread.sleep(6000);
		pp=new PhonesPage(driver);
		WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait3.until(ExpectedConditions.invisibilityOf(pp.getfirstEle()));
		MonitorsPage mp=new MonitorsPage(driver);

		List<WebElement> getMonitorlist=mp.getAllmoni();
		HashSet<String> actualMonitors=new HashSet<String>();
		for(WebElement prod:getMonitorlist)
		{
			actualMonitors.add(prod.getText());
		}
		HashSet<String> expectedMonitor=mp.getmonitorset();
		Assert.assertEquals(actualMonitors, expectedMonitor);
	}
}
