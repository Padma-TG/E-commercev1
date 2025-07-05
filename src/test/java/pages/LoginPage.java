package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	//constructors
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	//locators
	//@FindBy(id="login2") WebElement loginbtnHP;
	@FindBy(id="loginusername") WebElement unameipLP;
	@FindBy(id="loginpassword") WebElement pwdipLP;
	@FindBy(xpath="//button[text()='Log in']") WebElement loginbtnLP;
	@FindBy(xpath="(//button[text()='Close'])[3]") WebElement closebtnLP;
	@FindBy(xpath="//h5[text()='Log in']") WebElement labelloginLP;
	//action Methods
	public void login(String uname,String pwd)
	{
		unameipLP.click();
		unameipLP.clear();
		unameipLP.sendKeys(uname);
		pwdipLP.click();
		pwdipLP.clear();
		pwdipLP.sendKeys(pwd);
		loginbtnLP.click();
	}
	public void clickcloseLP()
	{
		closebtnLP.click();
	}
	public WebElement unameLP()
	{
		return unameipLP;
	}
	public WebElement loginEletitleLP()
	{
		return labelloginLP;
	}
	
	
	
}
