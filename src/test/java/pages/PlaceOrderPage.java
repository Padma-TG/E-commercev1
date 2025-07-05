package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderPage extends BasePage
{
	//constructors
	public PlaceOrderPage(WebDriver driver)
	{
		super(driver);
	}
	//locators
	@FindBy(id="totalm") WebElement totallabelPOC;
	@FindBy(id="name") WebElement nameipPOC;
	@FindBy(id="country") WebElement countryipPOC;
	@FindBy(id="city") WebElement cityipPOC;
	@FindBy(id="card") WebElement cardipPOC;
	@FindBy(id="month") WebElement monthipPOC;
	@FindBy(id="year") WebElement yearipPOC;
	@FindBy(xpath="//button[text()='Purchase']") WebElement purchasebtnPOC; 
	@FindBy(xpath="(//button[text()='Close'])[3]") WebElement closebtnPOC;
	@FindBy(xpath="//h2[text()='Thank you for your purchase!']") WebElement thankyoumsgPOC;
	@FindBy(xpath="//div[contains(@class, 'sweet-alert')]//p[contains(@class, 'lead')]") WebElement confirmationmsgPOC;
	@FindBy(xpath="//button[text()='OK']") WebElement okbtnPOC;
    @FindBy(css = "#orderModal .form-group")    WebElement formGroupElement;
    

	//action methods
    public WebElement eleFormGroupDisplayed() 
    {
        return formGroupElement;
    }

	public boolean distotalPOCM()
	{
		return totallabelPOC.isDisplayed();
	}
	public void fillPOCM(String name,String country,String city,String card,String month,String year)
	{
		nameipPOC.sendKeys(name);
		countryipPOC.sendKeys(country);
		cityipPOC.sendKeys(city);
		cardipPOC.sendKeys(card);
		monthipPOC.sendKeys(month);
		yearipPOC.sendKeys(year);
		purchasebtnPOC.click();
	}
	public void clickClosePOCM()
	{
		closebtnPOC.click();
	}
	public boolean disthankyouPOCM()
	{
		return thankyoumsgPOC.isDisplayed();
	}
	public WebElement getthankyouelem()
	{
		return thankyoumsgPOC;
	}
	public String thankyouPOCM()
	{
		return thankyoumsgPOC.getText();
	}
	public String getConfirmationPOCM()
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement confirmation = wait.until(ExpectedConditions.visibilityOf(confirmationmsgPOC));
	return confirmation.getText();
	}
	public void clickOkPOCM()
	{
		okbtnPOC.click();
	}
	
	

}
