package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage
{
	//constructors
	public SignUpPage(WebDriver driver) 
	{
		super(driver);		
	}
	//locators
	@FindBy(xpath="//h5[text()='Sign up']") WebElement titleofsignup;
	
	@FindBy(id="sign-username") WebElement usernameipSP;
	
	@FindBy(id="sign-password") WebElement passwordipSP;
	
	@FindBy(xpath="//button[text()='Sign up']") WebElement signupbtnSP;
	
	@FindBy(xpath="(//button[text()='Close'])[2]") WebElement closebtnSP;
	
	@FindBy(xpath="//a[text()='Log out']") WebElement logoutbtnSP;
	
	@FindBy(xpath="(//span[text()='×'])[2]") WebElement xcloselemSP;
	//Action methods
	public void xcloseclick()
	{
		xcloselemSP.click();
	}
	public WebElement titledisSU()
	{
		return titleofsignup;
	}
	public void fullsignupSPM(String uname,String password)
	{
		usernameipSP.click();
		usernameipSP.clear();
		usernameipSP.sendKeys(uname);
		passwordipSP.click();
		passwordipSP.clear();
		passwordipSP.sendKeys(password);
		signupbtnSP.click();
	}
	public void clicklogoutSPM()
	{
		logoutbtnSP.click();
	}
	public WebElement logoutWESPM()
	{
		return logoutbtnSP;
	}
	public void clickcloseSPM()
	{
		closebtnSP.click();
	}
	public void clearsignupM()
	{
		usernameipSP.click();
		usernameipSP.clear();
		passwordipSP.click();
		passwordipSP.clear();
	}
	

}
