package test;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.PhonesPage;
import pages.WelcomePage;

public class Demotest extends BaseTest {
 
	@Test
	public void mobiletest() throws InterruptedException {
		
	HomePage hp=new HomePage(driver);
	hp.clickloginHPM();
	
	LoginPage lp=new LoginPage(driver);
	lp.login(p.getProperty("validuname"),p.getProperty("validpwd"));
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.invisibilityOf(lp.unameLP()));
	
	
	List<WebElement> product_list = hp.getProductCards();
	int i = 1;
	for(WebElement prod : product_list)
	{	
		if(i%3==1) {
			Assert.assertEquals(prod.getLocation().x, 383);
		}
		if(i%3==2) {
			Assert.assertEquals(prod.getLocation().x, 668);
		}
		if(i%3==0) {
			Assert.assertEquals(prod.getLocation().x, 953);
		}
		if (i >= 1 && i<=3) {
			Assert.assertEquals(prod.getLocation().y, 589);
		}
		if (i >= 4 && i<=6) {
			Assert.assertEquals(prod.getLocation().y, 940);
		}
		if (i >= 7 && i<=9) {
			Assert.assertEquals(prod.getLocation().y, 1292);
		}
		System.out.println(prod.getLocation().x + " "+prod.getLocation().y);
		if(prod.getSize().getHeight()==26) {
			System.out.println("height right");
			Assert.assertTrue(true);
		}
		else {
			Assert.fail(prod.getText() + " has different height");
		}
		if(prod.getSize().getWidth()==214) {
			System.out.println("Width right");
			Assert.assertTrue(true);
		}
		else {
			Assert.fail(prod.getText() + " has different w");
		}
		i++;
	}
}
	@Test
	public void Laptoptest() throws InterruptedException {
		
 	HomePage hp=new HomePage(driver);
	hp.clickloginHPM();
	
	LoginPage lp=new LoginPage(driver);
	lp.login(p.getProperty("validuname"),p.getProperty("validpwd"));
	Thread.sleep(5000);
	
	WelcomePage wp=new WelcomePage(driver);
	wp.clicklaptopsWPM();
	Thread.sleep(3000);
	PhonesPage pp = new PhonesPage(driver);

	List<WebElement> product_list = driver.findElements(By.className("card-title"));
	int i = 1;
	for(WebElement prod : product_list) {
		//checks column allignment
		if(i%3==1) {
			Assert.assertEquals(prod.getLocation().x, 383);
		}
		if(i%3==2) {
			Assert.assertEquals(prod.getLocation().x, 668);
		}
		if(i%3==0) {
			Assert.assertEquals(prod.getLocation().x, 953);
		}
		//checks row allignment
		if (i >= 1 && i<=3) {
			Assert.assertEquals(prod.getLocation().y, 589);
		}
		if (i >= 4 && i<=6) {
			Assert.assertEquals(prod.getLocation().y, 940);
		}
		if (i >= 7 && i<=9) {
			Assert.assertEquals(prod.getLocation().y, 1292);
		}
		//checks box allignment 
		if(prod.getSize().getHeight()==26) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail(prod.getText() + " has different height");
		}
		if(prod.getSize().getWidth()==214) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail(prod.getText() + " has different w");
		}
		i++;
}
	driver.findElement(By.id("next2")).click();
	Thread.sleep(3000);
	product_list = driver.findElements(By.className("card-title"));
	i = 1;
	for(WebElement prod : product_list) {
		if(i%3==1) {
			Assert.assertEquals(prod.getLocation().x, 383);
		}
		if(i%3==2) {
			Assert.assertEquals(prod.getLocation().x, 668);
		}
		if(i%3==0) {
			Assert.assertEquals(prod.getLocation().x, 953);
		}
		if (i >= 1 && i<=3) {
			Assert.assertEquals(prod.getLocation().y, 589);
		}
		if (i >= 4 && i<=6) {
			Assert.assertEquals(prod.getLocation().y, 940);
		}
		if (i >= 7 && i<=9) {
			Assert.assertEquals(prod.getLocation().y, 1292);
		}
		if(prod.getSize().getHeight()==26) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail(prod.getText() + " has different height");
		}
		if(prod.getSize().getWidth()==214) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail(prod.getText() + " has different w");
		}
		i++;
}
}
	@Test
	public void monitortest() throws InterruptedException {
		
		HomePage hp=new HomePage(driver);
	hp.clickloginHPM();
	
	LoginPage lp=new LoginPage(driver);
	lp.login(p.getProperty("validuname"),p.getProperty("validpwd"));
	Thread.sleep(5000);
	
	WelcomePage wp=new WelcomePage(driver);
	driver.findElement(By.linkText("Monitors")).click();
	Thread.sleep(3000);
	PhonesPage pp = new PhonesPage(driver);
	List<WebElement> product_list = driver.findElements(By.className("card-title"));
	int i = 1;
	for(WebElement prod : product_list) {
		System.out.println(prod.getLocation().x + " "+prod.getLocation().y);
		if(i%3==1) {
			Assert.assertEquals(prod.getLocation().x, 383);
		}
		if(i%3==2) {
			Assert.assertEquals(prod.getLocation().x, 668);
		}
		if(i%3==0) {
			Assert.assertEquals(prod.getLocation().x, 953);
		}
		if (i >= 1 && i<=3) {
			Assert.assertEquals(prod.getLocation().y, 589);
		}
		if (i >= 4 && i<=6) {
			Assert.assertEquals(prod.getLocation().y, 940);
		}
		if (i >= 7 && i<=9) {
			Assert.assertEquals(prod.getLocation().y, 1292);
		}
		if(prod.getSize().getHeight()==26) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail(prod.getText() + " has different height");
		}
		if(prod.getSize().getWidth()==214) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail(prod.getText() + " has different w");
		}
		i++;
	}
}
}