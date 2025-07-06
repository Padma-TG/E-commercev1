package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage
{
	public ContactPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//label[text()='Contact Email:']") WebElement contactemaillblcp;
	@FindBy(xpath="(//button[text()='Close'])[1]") WebElement closecontactcp;
	
	public void clickClose()
	{
		closecontactcp.click();
	}
	public WebElement closeelem()
	{
		return closecontactcp;
	}
	
	public WebElement contactlabel()
	{
		return contactemaillblcp;
	}
	
	public boolean iscontlblvisible()
	{
		return contactemaillblcp.isDisplayed();
	}

}
