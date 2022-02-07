package com.xcov19.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.xcov19.generics.BasePage;

public class PrivacyPolicyPopUp extends BasePage
{
	WebDriver driver;
	
	@FindBy(xpath = "//button[@class='cookie-close']")
	private WebElement closeButton;
	
	@FindBy(xpath="//div[@id='CookieDeclarationUserStatusLabelOff']")
	private WebElement currentState;
	
	@FindBy(xpath = "//a[text()='Change your consent']")
	private WebElement changeYourConscentButton;
	
	@FindBy(xpath = "//a[text()='Withdraw your consent']")
	private WebElement withdrawConscentButton;
	
	@FindBy(xpath="//a[@id='back-link']")
	private WebElement backToSiteButton;
	
	public PrivacyPolicyPopUp(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnChangeYourConscentButton()
	{
		waitUntilElementToBeClickable(driver, changeYourConscentButton);
		changeYourConscentButton.click();
	}
	
	public void clickOnWithdrawConsent() throws InterruptedException
	{
		waitUntilElementToBeClickable(driver, withdrawConscentButton);
		withdrawConscentButton.click();
		Thread.sleep(2000);
		Reporter.log("clicking on withdraw button", true);
	}
	
	public void checkIfConsentCurrentStateIsUpdated()
	{
//		waitUntilElementToBeClickable(driver, currentState);
//        String actualCurrentState = currentState.getText();
//        Reporter.log("current state is "+actualCurrentState ,true );
//        String expectedCurrentState = "Your current state: Deny. ";
//        
//		if(actualCurrentState.equalsIgnoreCase(expectedCurrentState))
//		{
//			Reporter.log("withdraw button is removed from page", true);
//		}
//		else
//		{
//			Reporter.log("withdraw button is not removed from page", true);
//		}
	}
	
	public void checkIfWithdrawConsentButtonIsDisplayed()
	{
		waitUntilElementToBeClickable(driver, currentState);
        String actualCurrentState = currentState.getText();
        Reporter.log("current state is "+actualCurrentState ,true );
        String expectedCurrentState = "Your current state: Deny. ";
        
		if(withdrawConscentButton.isDisplayed()==false && actualCurrentState.equalsIgnoreCase(expectedCurrentState))
		{
			Reporter.log("withdraw button is removed from page", true);
		}
		else
		{
			Reporter.log("withdraw button is not removed from page", true);
		}
	}
	
	public void clickOnBackToSite()
	{
		waitUntilElementToBeClickable(driver, backToSiteButton);
		backToSiteButton.click();
	}
	
	public void clickOnCloseButton()
	{
		waitUntilElementToBeClickable(driver, closeButton);
		closeButton.click();
	}
}
