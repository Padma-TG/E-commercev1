package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSpecPage extends BasePage
{
	public ProductSpecPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Add to cart']") WebElement addcartbtnPSP;
	@FindBy(xpath="//a[text()='Log out']") WebElement logoutbtnPSP;
	@FindBy(id="cartur") WebElement gotoCartPSP;
	@FindBy(xpath="//a[text()='Home ']") WebElement homebtnPSP;
	@FindBy(xpath="//h2[@class='name'] ") WebElement titleprodPSP;
	@FindBy(xpath="//h3[@class='price-container'] ") WebElement pricePSP;
	@FindBy(xpath="//div[@id='more-information']/p") WebElement prodDesPSP;
	@FindBy(xpath="//h2[@class='name']") WebElement titletxtpsp;
	@FindBy(id="nava") WebElement titleofpsp;
	
	public WebElement gettitleofpsp()
	{
		return titleofpsp;
	}
	
	public boolean chcktitlePSP()
	{
		return titleprodPSP.isDisplayed();
	}
	public boolean chckpricePSP()
	{
		return pricePSP.isDisplayed();
	}

	public boolean chckprodDes()
	{
		return prodDesPSP.isDisplayed();
	}
	public void clickaddtocartPSPM()
	{
		addcartbtnPSP.click();
	}
	public void getgotocartPSPM()
	{
		gotoCartPSP.click();
	}
	public WebElement gotoCartelemPSPM()
	{
		return addcartbtnPSP;
	}
	public void clickHomebtnPSPM()
	{
		homebtnPSP.click();
	}
	public void clickLogoutPSP()
	{
		logoutbtnPSP.click();
	}
	public String getTitle()
	{
		return titletxtpsp.getText();
	}

}
