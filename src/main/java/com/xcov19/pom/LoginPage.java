package com.xcov19.pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.xcov19.generics.AutoConstants;
import com.xcov19.generics.BasePage;
import com.xcov19.generics.ExcelLibrary;

public class LoginPage extends BasePage implements AutoConstants
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@class='cd1df0865 ulp-button-icon c6cad41d5 _button-icon']")
	private WebElement showPasswordButton;
	
	@FindBy(xpath="//a[text()='Forgot password?']")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//a[text()='Sign up']")
	private WebElement signUpLink;
	
	@FindBy(xpath="//span[text()='Continue with Google']")
	private WebElement continueWithGoogleButton;
	
	@FindBy(xpath = "//p[text()='Welcome, ']")
	private WebElement welcomeButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void performLogin() throws IOException
	{
		waitUntilVisibilityOfElement(driver, emailField);
		emailField.sendKeys(ExcelLibrary.cellValue("login", 4, 0));
		waitUntilElementToBeClickable(driver, passwordField);
		passwordField.sendKeys(ExcelLibrary.cellValue("login", 4, 1));
		//waitUntilElementToBeClickable(driver, showPasswordButton);
		//showPasswordButton.click();
		Reporter.log("hitting continue button", true);
		waitUntilElementToBeClickable(driver, continueButton);
		performClickUsingActions(driver, continueButton);
		String expectedURL = "https://www.mycovidconnect.com/profile";
		waitUntilElementToBeClickable(driver, welcomeButton);
		String actualURL = driver.getCurrentUrl();
		Reporter.log(actualURL, true);
		
		if(actualURL.equalsIgnoreCase(expectedURL))
		{
			Reporter.log("login successful", true);
		}
		else
		{
			Reporter.log("login unsuccessful", true);

		}
	}
	
	public void selectSignUp()
	{
		waitUntilElementToBeClickable(driver, signUpLink);
		signUpLink.click();
	}
	
	
	
	
	
}
