package test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import baseTest.BaseTest;

//Test horizontal scrolling
//Scenario: Load site on smaller screen (mobile/tablet).
//Expected: Page should not require horizontal scrolling.

public class TC012_ResponsiveTest extends BaseTest
{
	@Test
	public void verify_resolution()
	{
		logger.info("********Starting TC012_ResponsiveTest**********" );

		Map<String, String> mobileemulation=new HashMap<>();
		mobileemulation.put("deviceName","iPhone X");
		
		ChromeOptions chromeoptions=new ChromeOptions();
		chromeoptions.setExperimentalOption("mobileEmulation", mobileemulation);
		
		WebDriver driver=new ChromeDriver(chromeoptions);
		try
		{
			driver.get("https://www.demoblaze.com/");
			Long scrollWidth = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("return document.documentElement.scrollWidth;");
            Long clientWidth = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("return document.documentElement.clientWidth;");

            if (scrollWidth > clientWidth) {
                System.out.println("Page has horizontal scrolling (scrollWidth > clientWidth)");
            } else {
                System.out.println("Page fits in the viewport - No horizontal scroll");
            }

        } 
		finally 
		{
           driver.quit();
        }
    }


		
		
	}

