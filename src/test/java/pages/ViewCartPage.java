package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCartPage extends BasePage
{
	
	public ViewCartPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(id="nava") WebElement titleofvcp;
	
	@FindBy(xpath="(//tr[@class='success'])[1]/td[2]") WebElement addedfirst;

	@FindBy(xpath="//tr[td]/td[2]") List<WebElement> addedproductsVCP; 
	
	@FindBy(xpath="(//tr[td])[1]") WebElement firstProductVCP;
	
	@FindBy(xpath="//h3[@id='totalp']") WebElement totalvalueVCP;
	
	@FindBy(xpath="(//a[text()='Delete'])[1]") WebElement firstdeletebtnVCP;
	
	@FindBy(xpath="(//tr/td)[3]") WebElement priceofFirstVCP;
	
	@FindBy(xpath = "//tr[td]/td[3]") List<WebElement> productPrices;
	
	@FindBy(xpath="//img[@src='imgs/galaxy_s6.jpg']") WebElement imgdispVCP;
	
	@FindBy(xpath="//a[text()='Log out']") WebElement logoutvcp;
	
	@FindBy(xpath = "//a[text()='Delete']")
	private List<WebElement> deleteButtons;
	
	@FindBy(xpath="//button[text()='Place Order']") WebElement placeorderbtnVCP;
	
	@FindBy(xpath="(//div[@class='modal-content'])[3]") WebElement modelappearsVCP;
	
	public WebElement getmodelappear()
	{
		return modelappearsVCP;
	}
	
	public WebElement gettitlevcp()
	{
		return titleofvcp;
	}
	
	public void clicklogoutvcp()
	{
		logoutvcp.click();
	}
	
	public String getaddedfirst()
	{
		return addedfirst.getText();
	}
	
	public WebElement getimgdisVCPM()
	{
		return imgdispVCP;
	}
	
	public void clickPlaceorderVCPM()
	{
		placeorderbtnVCP.click();
	}

	
	public List<String> getaddedproductsVCPM()
	{
		List<String> productNames = new ArrayList<>();

		for(WebElement product:addedproductsVCP)
		{
			productNames.add(product.getText());
		}
		return productNames;
	}
	public List<Integer> getaddedpricesVCPM() 
	{
	    List<Integer> prices = new ArrayList<>();
	     
	    for (WebElement e : productPrices) 
	    {
	        prices.add(Integer.parseInt(e.getText().trim()));
	    }
	    return prices;

	}

	public WebElement getfirstProductVCPM()
	{
		return firstProductVCP;
	}
	public List<WebElement> getAddedProductElementsVCPM()
	{
	    return addedproductsVCP;
	}
	public void getdeleteVCPM()
	{
		firstdeletebtnVCP.click();
	}
	public int getTotalVCPM()
	{
		String rawText= totalvalueVCP.getText().trim();
		return Integer.parseInt(rawText);
	}
	public int getfirstPriceVCPM()
	{
		String rawFirst=priceofFirstVCP.getText();
		return Integer.parseInt(rawFirst);
	}
	public WebElement gettotalelementVSPM()
	{
		return totalvalueVCP;	
	}
	public void clearCartIfNotEmpty() 
	{
	    for (WebElement delete : deleteButtons) 
	    {
	        delete.click();
	        try 
	        {
	            Thread.sleep(1000); // small wait between deletes
	        } 
	        catch (InterruptedException e) 
	        {
	            e.printStackTrace();
	        }
	    }
	}

//validate 
//	public int getPriceFirst()
//	{
//		
//	}
}
