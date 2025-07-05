package pages;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaptopsPage extends BasePage 
{
	public LaptopsPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//a[@class='hrefch']") List<WebElement> laptopSP;
	
	@FindBy(className="card-title") List<WebElement> eleoflap;
	
	@FindBy(xpath="(//p[contains(text(),'laptop')])[1]") WebElement firstlaptop;
	
	public WebElement getfirstltp()
	{
		return firstlaptop;
	}

	public List<WebElement> getallelemlap()
	{
		return eleoflap;
	}
	
	public HashSet<String> getLaptopsetLTPM() 
	{
		HashSet<String> laptopset = new HashSet<String>();

		laptopset.add("Sony vaio i5");
		laptopset.add("Sony vaio i7");
		laptopset.add("MacBook air");
		laptopset.add("Dell i7 8gb");
		laptopset.add("2017 Dell 15.6 Inch");
		laptopset.add("MacBook Pro");
		//laptopset.add("Apple monitor 24");
		laptopset.add("MacBook air");
		laptopset.add("Dell i7 8gb");
		laptopset.add("2017 Dell 15.6 Inch");
		laptopset.add("MacBook Pro");
		return laptopset;
		
	}
	
	

}
