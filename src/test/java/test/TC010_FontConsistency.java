package test;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductSpecPage;
import pages.SignUpPage;
import pages.ViewCartPage;
import pages.WelcomePage;
import utility.FontUtility;

public class TC010_FontConsistency extends BaseTest
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	@Test
	public void verify_font()
	{
		logger.info("********Starting TC010_FontConsistency**********" );

		HomePage hp=new HomePage(driver);
		WebElement elementtitlehp=hp.getTitleofHomepage();
		String fontofhp=FontUtility.getfontFamily(elementtitlehp);
		String fontsizehp=FontUtility.getFontSize(elementtitlehp);
		System.out.println("font style of hp"+fontofhp);
		System.out.println("font size of hp"+fontsizehp);
		hp.clicksignupHPM();
		
		SignUpPage su=new SignUpPage(driver);	
		wait.until(ExpectedConditions.visibilityOf(su.titledisSU()));
		WebElement elementtitleSU=su.titledisSU();
		FontUtility.assertFontStle(elementtitleSU, fontofhp, fontsizehp);
		su.xcloseclick();
		hp.clickloginHPM();		
		
		LoginPage lp=new LoginPage(driver);
		WebElement elementlogin=lp.loginEletitleLP();
		FontUtility.assertFontStle(elementlogin, fontofhp, fontsizehp);
		lp.login(p.getProperty("validuname"), p.getProperty("validpwd"));
		wait.until(ExpectedConditions.invisibilityOf(lp.unameLP()));

		WelcomePage wp=new WelcomePage(driver);
		WebElement elementwp=wp.gettitleofwp();
		FontUtility.assertFontStle(elementwp, fontofhp, fontsizehp);
		wp.selectProduct1WPM();
		
		ProductSpecPage psp=new ProductSpecPage(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement elementtitleofpsp=psp.gettitleofpsp();
		FontUtility.assertFontStle(elementtitleofpsp, fontofhp, fontsizehp);
		psp.clickaddtocartPSPM();
		acceptAlert();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		ViewCartPage vcp=new ViewCartPage(driver);
		WebElement elementtitleofvcp=vcp.gettitlevcp();
		FontUtility.assertFontStle(elementtitleofvcp, fontofhp, fontsizehp);
		vcp.clicklogoutvcp();
		

	}
	

}
