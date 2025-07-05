package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage
{
	public WelcomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Log out']") WebElement logoutWP;
	
	@FindBy(xpath="//a[text()='Contact']") WebElement contactWP;
	
	@FindBy(xpath="//a[contains(text(),'Welcome')]") WebElement successloginWP;
	
	@FindBy(xpath="//a[text()='Samsung galaxy s6']") WebElement selectprod1WP;
	
	@FindBy(xpath="//a[text()='Nokia lumia 1520']") WebElement selectprod2WP;
	
	@FindBy(xpath="//a[text()='Sony xperia z5']") WebElement selectprod3WP;
	
	@FindBy(xpath="//a[text()='Cart']") WebElement cartWP;
	
	@FindBy(xpath="//a[text()='Home ']") WebElement homebtnWP;
	
	@FindBy(xpath="//a[text()='Phones']") WebElement phonesbtnWP;
	
	@FindBy(xpath="//a[text()='Laptops']") WebElement laptopsbtnWP;
	
	@FindBy(xpath="//a[text()='Monitors']") WebElement monitorsbtnWP;
	
	@FindBy(css="#next2") WebElement nextbtnWP;
	
	@FindBy(css=".col-lg-4.col-md-6.mb-4") List<WebElement> prodTileseleWP;
	
	@FindBy(id="nava") WebElement titleWp;
	
	public WebElement gettitleofwp()
	{
		return titleWp;
	}
	
	public List<WebElement> getprodtileslist()
	{
		return prodTileseleWP;
	}
	
	public void clickNextbtnWP()
	{
		nextbtnWP.click();
	}
	
	public void clickphonesWPM()
	{
		phonesbtnWP.click();
	}
	public WebElement eleMonitors()
	{
		return monitorsbtnWP;
	}
	public void clicklaptopsWPM()
	{
		laptopsbtnWP.click();
	}
	public void clickMonitorsWPM()
	{
		monitorsbtnWP.click();	
	}
	
	public String disMsg()
	{
		return successloginWP.getText();
	}
	public WebElement dishomeWPM()
	{
		return homebtnWP;
	}
	public WebElement eledisMsg()
	{
		return successloginWP;
	}
	public WebElement elelogoutWPM()
	{
		return logoutWP;
	}
	public void clickLogoutWPM()
	{
		logoutWP.click();
	}
	public void selectProduct1WPM()
	{
		selectprod1WP.click();
	}
	public WebElement Product1()
	{
		return selectprod1WP;
	}
	public void clickcartWPM()
	{
		cartWP.click();
	}
	public WebElement elemselectproduct2WPM()
	{
		return selectprod2WP;
	}
	public void selectProduct2WPM()
	{
		selectprod2WP.click();
	}
	public void selectProduct3WPM()
	{
		selectprod3WP.click();
	}
	public void clickHomeWP()
	{
		homebtnWP.click();
	}
	public void clickContactWP()
	{
		contactWP.click();
	}
	
	public WebElement getLogoutWP()
	{
		return logoutWP;
	}
}
