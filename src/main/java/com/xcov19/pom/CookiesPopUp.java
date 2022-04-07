package com.xcov19.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.xcov19.generics.BasePage;
import com.xcov19.generics.Logger;

public class CookiesPopUp extends BasePage
{
	WebDriver driver;
	
	@FindBy(xpath = "(//a[@class='CybotCookiebotDialogBodyLink'])[1]")
	private WebElement showDetailsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'details')][@id='CybotCookiebotDialogBodyButtonDetails']")
	private WebElement showOrHideDetailsLink;
	
	@FindBy(xpath = "//a[text()='Hide details']")
	private WebElement hideDetailsLink;
	
	@FindBy(xpath = "//a[text()='About']")
	private WebDriver aboutTab;
	
	@FindBy(xpath = "//a[text()='Cookie declaration']")
	private WebElement cookieDeclarationTab;
	
	@FindBy(xpath = "//a[text()='Necessary (1)']//label")
	private WebElement necessaryoptionCheckbox;
	
	@FindBy(xpath = "//a[text()='Preferences (1)']//label")
	private WebElement preferencesOptionCheckbox;
	
	@FindBy(xpath="//input[@id='CybotCookiebotDialogBodyLevelButtonPreferences']")
	private WebElement preferencesInputCheckbox;
	
	@FindBy(xpath = "//a[text()='Statistics (1)']//label")
	private WebElement statisticsOptionCheckbox;
	
	@FindBy(xpath = "//input[@id='CybotCookiebotDialogBodyLevelButtonStatistics']")
	private WebElement statisticsOptionInputCheckbox;
	
	@FindBy(xpath = "//a[text()='Marketing (0)']//label")
	private WebElement marketingOptionCheckbox;
	
	@FindBy(xpath= "//input[@id='CybotCookiebotDialogBodyLevelButtonMarketing']")
	private WebElement marketingOptionInputCheckbox;
	
	@FindBy(xpath = "//a[text()='Unclassified (0)']")
	private WebElement unclassifiedOption;
	
	@FindBy(xpath = "//a[@class='CybotCookiebotDialogBodyButton'][text()='OK']")
	private WebElement OKButton;
	
	
	public CookiesPopUp(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
	public void changeCookieSettings() throws InterruptedException
	{
		Logger.info("Waiting for hidedetails to be displayed");

		waitUntilElementToBeClickable(driver, showOrHideDetailsLink);
		if(hideDetailsLink.isDisplayed())
		{
			Logger.info("show details has changed to hide details");
		}
		else if (showDetailsLink.isDisplayed()==true) 
		{
			showDetailsLink.click();
			Logger.info("hide not displayed yet...");
		} 
	
		waitUntilElementToBeClickable(driver, statisticsOptionCheckbox);
		statisticsOptionCheckbox.click();
		Logger.info("stats after click on input: "+ statisticsOptionInputCheckbox.isSelected());
		Thread.sleep(2000);
		Logger.info("unchecked statistics");
		
//		waitUntilElementToBeClickable(driver, hideDetailsLink);
//		hideDetailsLink.click();
//		Reporter.log("clicked on hide details", true);
		
		waitUntilElementToBeClickable(driver, OKButton);
		performClickUsingActions(driver, OKButton);
		Logger.info("clicked on OK button");
		
	}
	
	public void verifyIfCookiesPreferencesIsSaved() throws InterruptedException
	{
		waitUntilElementToBeClickable(driver, showOrHideDetailsLink);
		if(hideDetailsLink.isDisplayed())
		{
			Logger.info("show details has changed to hide details");
		}
		else if (showDetailsLink.isDisplayed()==true) 
		{
			showDetailsLink.click();
			Logger.info("hide not displayed yet...");
		}
		
		waitUntilElementToBeClickable(driver, preferencesOptionCheckbox);
		
		Logger.info("stats: "+statisticsOptionInputCheckbox.isSelected()); // should be false
		
		Thread.sleep(1000);
		if(preferencesInputCheckbox.isSelected()==true && marketingOptionInputCheckbox.isSelected()== true &&
				statisticsOptionInputCheckbox.isSelected()==false)
		{
			Logger.info("cookie preferences is saved ");
		}
		else
		{
			Logger.error("cookie preferneces is not saved");
			Assert.fail();
		}
		
		waitUntilElementToBeClickable(driver, OKButton);
		performClickUsingActions(driver, OKButton);
	}
	
	public void verifyIfConsentIsWithdrawn() throws InterruptedException
	{
		waitUntilElementToBeClickable(driver, preferencesOptionCheckbox);
		Logger.info("preferences: "+preferencesInputCheckbox.isSelected());
		Logger.info("stats: "+statisticsOptionInputCheckbox.isSelected());
		Logger.info("marketing: "+marketingOptionInputCheckbox.isSelected());
		
		Thread.sleep(3000);
		if(preferencesInputCheckbox.isSelected()==false && statisticsOptionInputCheckbox.isSelected()==false && 
				marketingOptionInputCheckbox.isSelected()==false)
		{
			Logger.info("consent has been withdrawn");
		}
		else
		{
			Logger.error("error in withdraw consent");
			Assert.fail();
		}
		waitUntilElementToBeClickable(driver, OKButton);
		performClickUsingActions(driver, OKButton);
	}
	
}
