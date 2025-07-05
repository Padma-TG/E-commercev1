package pages;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MonitorsPage extends BasePage
{
	//constructors
	public MonitorsPage(WebDriver driver)
	{
		super(driver);
	}
	//locators
	@FindBy(xpath="//a[@class='hrefch']") List<WebElement> monitorSP;
	
	
	//action methods
	public List<WebElement> getAllmoni()
	{
		return monitorSP;
	}
	public HashSet<String> getmonitorset() 
	{
		HashSet<String> monitorset = new HashSet<String>();
		monitorset.add("Apple monitor 24");
		monitorset.add("ASUS Full HD");
		return monitorset;
	}
	

}
