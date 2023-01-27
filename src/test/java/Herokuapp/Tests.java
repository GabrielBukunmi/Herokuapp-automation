package Herokuapp;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.Landingpage;
import pageObject.Loginpage;
import resources.Base;

public class Tests extends Base {

	public WebDriver driver;
	@BeforeTest
	public void initializeBrowser() throws IOException{
		driver = initializeDriver();
		driver.get("https://the-internet.herokuapp.com/");	
		
	}
	
	@Test
	public void validLogin() throws InterruptedException, IOException {
		Landingpage lp = new Landingpage(driver);
		lp.formAuthentication().click();
		Loginpage lg = new Loginpage(driver);
		lg.username().sendKeys("tomsmith");
		lg.password().sendKeys("SuperSecretPassword!");
		lg.login().click();
		String text = driver.findElement(By.id("flash")).getText();
		Assert.assertTrue(text.contains("You logged into a secure area!"));
		Thread.sleep(2000);
		
	}
	
	@Test(dependsOnMethods= {"validLogin"})
	public void invalidLogin() throws InterruptedException, IOException {
	
		driver.get("https://the-internet.herokuapp.com/");	
		Landingpage lp = new Landingpage(driver);
		lp.formAuthentication().click();
		Loginpage lg = new Loginpage(driver);
		lg.username().sendKeys("thomas");
		lg.password().sendKeys("SecretPassword!");
		lg.login().click();
		String text = driver.findElement(By.id("flash")).getText();
		Assert.assertTrue(text.contains("Your username is invalid!"));
		driver.close();
		
	}
		
	
//		driver.get("https://the-internet.herokuapp.com/");
//		
//		driver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]")).click();
//		driver.findElement(By.id("username")).sendKeys("tomsmith");
//		driver.findElement(By.cssSelector("[type='password']")).sendKeys("SuperSecretPassword!");
//		driver.findElement(By.cssSelector("button[type='submit']")).click();
//		String text = driver.findElement(By.id("flash")).getText();
//		Assert.assertTrue(text.contains("You logged into a secure area!"));
		
//		driver.get("https://the-internet.herokuapp.com/");
//		
//		driver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]")).click();
//		driver.findElement(By.id("username")).sendKeys("thomas");
//		driver.findElement(By.cssSelector("[type='password']")).sendKeys("SecretPassword!");
//		driver.findElement(By.cssSelector("button[type='submit']")).click();
//		String text = driver.findElement(By.id("flash")).getText();
//		Assert.assertTrue(text.contains("Your username is invalid!"));

				
	}
//}