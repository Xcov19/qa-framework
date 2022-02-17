package com.xcov19.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.xcov19.generics.BaseTest;
import com.xcov19.generics.ExcelLibrary;
import com.xcov19.pom.HomePage;
import com.xcov19.pom.LoginPage;

public class LoginValidation extends BaseTest
{
//	@Test()
//	public void loginTest() throws IOException
//	{
//		LoginPage login = new LoginPage(driver);
//		login.performLogin();
//	}
	
	@DataProvider(name = "login-data")
	public Object[][] passData() throws IOException 
	{
		Object[][] values = new Object[5][2];
		for(int i=0; i<values.length;i++)
		{
			for(int j=0; j<values[0].length;j++)
			{
				values[i][j] = ExcelLibrary.cellValue("login", i, j);
			}
		}
		Reporter.log("-------------------------------------------------------------------", true);
		return values;
		
	}

	@Test(dataProvider = "login-data")
	public void loginTestValidation(String Username, String password) throws IOException, InterruptedException
	{
		Reporter.log("login validation test started", true);
		Reporter.log("username is "+Username, true);
		Reporter.log("password is "+password, true);
		
		WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement continueButton = driver.findElement(By.xpath("//button[@name='action']"));
		
		Duration timeout = Duration.ofSeconds(30);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(emailField));
		emailField.clear();
		emailField.sendKeys(Username);
		Reporter.log(Username);
	
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.sendKeys(password);
		
		wait.until(ExpectedConditions.visibilityOf(continueButton));
		continueButton.click();
		
		Thread.sleep(2000);
		String expectedURL = "https://www.mycovidconnect.com/profile";
		String actualURL = driver.getCurrentUrl();
		
		if(actualURL.equalsIgnoreCase(actualURL))
		{
			Reporter.log("login successful", true);
		}
		else
		{
			Reporter.log("login unsuccessful", true);

		}
	}
}
