package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderC 
{
	@DataProvider(name="data")
	public Object[][] getLoginData() throws IOException
	{
		return ExcelUtility.readExcel("loginData");
	}
}