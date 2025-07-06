package baseTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest 
{
	public static WebDriver driver;
	public Properties p;
	public Logger logger;
	
	@Parameters({"os","browser"})
	@BeforeClass(groups = {"sanity"})	
	public void setup(@Optional("windows")String os,String br) throws IOException
	{
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		//String br="chrome";
		switch(br.toLowerCase())
		{
		case "chrome":		driver=new ChromeDriver(); break;
		case "edge":		driver=new EdgeDriver(); break;
		default : System.out.println("Invalid browser name"); return;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.demoblaze.com/");
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	@SuppressWarnings("deprecation")
	public String randomeString(int numA)
	{
		return RandomStringUtils.randomAlphabetic(numA);
		 
	}
	@SuppressWarnings("deprecation")
	public String randomeNum(int numN)
	{
		return RandomStringUtils.randomNumeric(numN);
	}
	@SuppressWarnings("deprecation")
	public String randomeAlphanum(int numAN)
	{
		return RandomStringUtils.randomAlphanumeric(numAN);
	}
	public void acceptAlert()
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	}
	public String getAndAcceptAlertText() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	    String alertText = alert.getText();
	    alert.accept();
	    return alertText;
	}
	public String captureScreenshot(String tname) throws IOException
	{
		String timeStamp=new SimpleDateFormat("yyyyMMDDhhmmss").format(new Date());
		TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
		File sourcefile=takesscreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp;
		File targetFile=new File(targetFilePath);
		sourcefile.renameTo(targetFile);
		
		return targetFilePath;
	}

	



}
