package com.xcov19.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xcov19.generics.AutoConstants;
import com.xcov19.generics.BasePage;
import com.xcov19.generics.ExcelLibrary;

public class SignUpPage extends BasePage implements AutoConstants
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement showPasswordButton;
	
	@FindBy(xpath="//button[.='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//a[text()='Log in']")
	private WebElement loginLink;
	
	@FindBy(xpath="//span[text()='Continue with Google']")
	private WebElement continueWithGoogleButton;
	
	public SignUpPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void performSignUp() throws InterruptedException, IOException
	{
		waitUntilVisibilityOfElement(driver, emailField);
		emailField.sendKeys(ExcelLibrary.cellValue("signUp", 4, 0));
		waitUntilElementToBeClickable(driver, passwordField);
		passwordField.sendKeys(ExcelLibrary.cellValue("signUp", 4, 1));
		waitUntilElementToBeClickable(driver, showPasswordButton);
		showPasswordButton.click();
		waitUntilElementToBeClickable(driver, continueButton);
		continueButton.click();
		Thread.sleep(4000);
		
	}
	
	
}
