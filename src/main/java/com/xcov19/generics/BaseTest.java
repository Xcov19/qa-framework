package com.xcov19.generics;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sonatype.inject.Parameters;
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
		Reporter.log("Execution begins", true);
	}
	
	@org.testng.annotations.Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void openBrowserAndLogin(String browser) throws IOException
	{
		if (browser.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		//System.setProperty("webdriver.chrome.logfile", "./Logs/chromelogs.txt");
		driver.get(siteUrl);
		
		HomePage home = new HomePage(driver);
		home.acceptCookies();
		Reporter.log("cookies accepted", true);
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
		Reporter.log("execution ends", true);
	}
}
