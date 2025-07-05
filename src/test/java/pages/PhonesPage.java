package pages;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhonesPage extends BasePage
{
	//constructors
	//locators
	//action methods
	public PhonesPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='hrefch']") List<WebElement> allphonesPP;
	
	@FindBy(xpath="//a[text()='Samsung galaxy s6']") WebElement firstPhonePP;
	
	@FindBy(className="card-title") List<WebElement> product_list;
	
	public WebElement getfirstEle()
	{
		return firstPhonePP;
	}
	
	public List<WebElement> eleAllPPM()
	{
		return product_list;
	}
	
	HashSet<String> mobileset = new HashSet<String>();
	
	public HashSet<String> getmobilesetPPM() 
	{
		mobileset.add("Samsung galaxy s6");
		mobileset.add("Nokia lumia 1520");
		mobileset.add("Nexus 6");
		mobileset.add("Samsung galaxy s7");
		mobileset.add("Iphone 6 32gb");
		mobileset.add("Sony xperia z5");
		mobileset.add("HTC One M9");
		mobileset.add("Sony vaio i7");
		mobileset.add("Sony vaio i5");
		return mobileset;
		
	}
	
	}
