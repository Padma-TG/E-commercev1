package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderC 
{
	@DataProvider(name="loginData")
	public Object[][] getLoginData() throws IOException
	{
		return ExcelUtility.readExcel("loginData");
	}
	@DataProvider(name="mobile")
	public Object[][] getmobileData() throws IOException
	{
		return ExcelUtility.readExcel("Mobile");
	}
	@DataProvider(name="Laptop")
	public Object[][] getlaptopData() throws IOException
	{
		return ExcelUtility.readExcel("Laptop");
	}
	@DataProvider(name="Monitor")
	public Object[][] getmonitorData() throws IOException
	{
		return ExcelUtility.readExcel("Monitor");
	}

}
