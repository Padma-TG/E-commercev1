package utility;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FontUtility 
{
	public static void assertFontStle(WebElement element,String expectedFont,String expectedFontSize)
	{
		String actualFont=element.getCssValue("font-family");
		String actualSize=element.getCssValue("font-size");
		
		Assert.assertEquals(actualFont, expectedFont);
		Assert.assertEquals(actualSize, expectedFontSize);
	}
	public static String getfontFamily(WebElement element)
	{
		return element.getCssValue("font-family");
	}
	public static String getFontSize(WebElement element)
	{
		return element.getCssValue("font-size");
	}
}
