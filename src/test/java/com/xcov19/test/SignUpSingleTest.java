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
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.xcov19.generics.BaseTest;
import com.xcov19.generics.ExcelLibrary;
import com.xcov19.generics.Logger;
import com.xcov19.pom.HomePage;
import com.xcov19.pom.LoginPage;
import com.xcov19.pom.SignUpPage;

public class SignUpSingleTest extends BaseTest
{
	@Test()
	public void signUpTest() throws InterruptedException, IOException
	{
		Logger.info("signup single test");
		LoginPage login = new LoginPage(driver);
		login.selectSignUp();
		Logger.info("signup started");
		SignUpPage signUp = new SignUpPage(driver);
		signUp.performSignUp();
		Logger.info("finished sigh up");
		Reporter.log("-------------------------------------------------------------------", true);
	}
	
	
	
//	@DataProvider(name = "signup-data")
//	public Object[][] signUp() throws IOException
//	{
//		Object[][] values = new Object[5][2];
//		for(int i=0;i<values.length;i++)
//		{
//			for(int j=0;j<values[0].length;j++)
//			{
//				values[i][j] = ExcelLibrary.cellValue("signUp", i, j);
//			}
//		}
//		return values;
//	}
//	
//	@Test(dataProvider = "signup-data", priority = 1)
//	public void signUpValidation(String username, String password) throws InterruptedException
//	{
//		
//		Reporter.log("username is"+username, true);
//		Reporter.log("password is"+password, true);
//		
//		WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
//		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
//		WebElement continueButton = driver.findElement(By.xpath("//button[@name='action']"));
//		
//		Duration timeout = Duration.ofSeconds(30);
//		WebDriverWait wait = new WebDriverWait(driver, timeout);
//		wait.until(ExpectedConditions.visibilityOf(emailField));
//		emailField.clear();
//		emailField.sendKeys(username);
//		Reporter.log(username);
//	
//		wait.until(ExpectedConditions.visibilityOf(passwordField));
//		passwordField.sendKeys(password);
//		
//		wait.until(ExpectedConditions.visibilityOf(continueButton));
//		continueButton.click();
//		
//		Thread.sleep(2000);
//		String expectedURL = "https://www.mycovidconnect.com/profile";
//		String actualURL = driver.getCurrentUrl();
//		
//		if(actualURL.equalsIgnoreCase(actualURL))
//		{
//			Reporter.log("signup successful");
//		}
//		else
//		{
//			Reporter.log("signup unsuccessful");
//
//		}
//	}
}
