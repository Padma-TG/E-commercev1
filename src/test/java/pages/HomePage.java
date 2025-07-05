package pages;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	//constructors
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	//locators
	@FindBy(xpath="//a[contains(text(),'PRODUCT STORE')]") WebElement titleofHomeP;
	
	@FindBy(xpath="//a[text()='Home ']") WebElement homebtnHP;
	
	@FindBy(xpath="//a[text()='Contact']") WebElement contactbtnHP;
	
	@FindBy(xpath="//a[text()='About us']") WebElement aboutbtnHP;
	
	@FindBy(xpath="//a[text()='Cart']") WebElement cartbtnHP;
	
	@FindBy(xpath="//a[text()='Log in']") WebElement loginbtnHP;
	
	@FindBy(xpath="//a[text()='Sign up']") WebElement signupbtnHP;
	
	@FindBy(xpath="//a[@class='hrefch']") List<WebElement> allprodHP;
	
	@FindBy(xpath="//a[text()='Contact']") WebElement contactHP;

	@FindBy(xpath="//a[text()='Cart']") WebElement cartHP;
	
	@FindBy(css=".col-lg-4.col-md-6.mb-4") List<WebElement> productCards;
	
	@FindBy(xpath="//button[text()='Next']") WebElement nextpageHP;
	
	@FindBy(xpath="//div[@class='card h-100']") List<WebElement> elemProducttiles;
	
	//action methods
	public WebElement getTitleofHomepage()
	{
		return titleofHomeP;
	}
	
	public WebElement signupbtnelehp()
	{
		return signupbtnHP;
	}
	public List<WebElement> getProductTiles()
	{
		return elemProducttiles;
	}
	public void clicktogoNextPage()
	{
		nextpageHP.click();
	}
	public List<WebElement> getProductCards()
	{
		return productCards;
	}
	public boolean loginVis()
	{
		return loginbtnHP.isDisplayed();
	}
	public WebElement loginelehp()
	{
		return loginbtnHP;
	}
	public void clickCartHP()
	{
		cartHP.click();
	}
	public void clickContactHP()
	{
		contactHP.click();
	}
	public List<WebElement> getAlleleHP()
	{
		return allprodHP;
	}
	public void clickhomeHPM()
	{
		homebtnHP.click();
	}
	public void clickContactHPM()
	{
		contactbtnHP.click();
	}
	public void clickaboutHPM()
	{
		aboutbtnHP.click();
	}
	public void clickcartHPM()
	{
		cartbtnHP.click();
	}
	public void clickloginHPM()
	{
		loginbtnHP.click();
	}
	public void clicksignupHPM()
	{
		signupbtnHP.click();
	}
	public WebElement signupWEHPM()
	{
		return signupbtnHP;
	}
	public HashSet<String> getAllElementsHP()
	{
		HashSet<String> homeset=new HashSet<>();
		homeset.add("Samsung galaxy s6");
		homeset.add("Nokia lumia 1520");
		homeset.add("Nexus 6");
		homeset.add("Samsung galaxy s7");
		homeset.add("Iphone 6 32gb");
		homeset.add("Sony xperia z5");
    	homeset.add("HTC One M9");
    	homeset.add("Sony vaio i5");
    	homeset.add("Sony vaio i7");
    	return homeset;

	}
}
