package com.xcov19.generics;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sonatype.inject.Parameters;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.xcov19.pom.HomePage;
import com.xcov19.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements AutoConstants 
{
	public static WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	public void executionStarts()
	{
		Logger.info("Execution begins");
	}
	
//	@org.testng.annotations.Parameters("browser")
	@org.testng.annotations.Parameters({"url"})
	@BeforeClass(alwaysRun = true)
	public void openBrowserAndLogin(String url) throws IOException
	{
		String browser = System.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) 
		{
			ChromeOptions op = new ChromeOptions();
			op.addArguments("headless");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(op);
		}
		else {
			Logger.error("Incorrect browser (" + browser + ") passed. Supported brwosers: [chrome]. Exiting...");
			Assert.fail();
		}
		
		driver.manage().window().maximize();
		//System.setProperty("webdriver.chrome.logfile", "./Logs/chromelogs.txt");
		
		Logger.info("opening url: "+url);

		driver.get(url);
		
		
		HomePage home = new HomePage(driver);
		home.acceptCookies();
		Logger.info("cookies accepted");
		home.clickOnLogIn();
//		
//		LoginPage login = new LoginPage(driver);
//		login.performLogin();
		
	}
	
	@AfterClass(alwaysRun = true)
	public void LogoutAndcloseBrowser()
	{
		HomePage home = new HomePage(driver);
		home.performLogout();
		
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void executionEnds()
	{
		Logger.info("execution ends");
	}
}
