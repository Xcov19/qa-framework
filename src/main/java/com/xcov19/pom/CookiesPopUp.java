package com.xcov19.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.xcov19.generics.BasePage;

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
		Reporter.log("Waiting for hidedetails to be displayed", true);
		waitUntilElementToBeClickable(driver, showOrHideDetailsLink);
		if(hideDetailsLink.isDisplayed())
		{
			Reporter.log("show details has changed to hide details", true);
		}
		else if (showDetailsLink.isDisplayed()==true) 
		{
			showDetailsLink.click();
			Reporter.log("hide not displayed yet...", true);
		} 
	
		waitUntilElementToBeClickable(driver, statisticsOptionCheckbox);
		statisticsOptionCheckbox.click();
		Reporter.log("stats after click on input: "+ statisticsOptionInputCheckbox.isSelected(), true);
		Thread.sleep(2000);
		Reporter.log("unchecked statistics", true);
		
//		waitUntilElementToBeClickable(driver, hideDetailsLink);
//		hideDetailsLink.click();
//		Reporter.log("clicked on hide details", true);
		
		waitUntilElementToBeClickable(driver, OKButton);
		performClickUsingActions(driver, OKButton);
		Reporter.log("clicked on OK button", true);
		
	}
	
	public void verifyIfCookiesPreferencesIsSaved() throws InterruptedException
	{
		waitUntilElementToBeClickable(driver, showOrHideDetailsLink);
		if(hideDetailsLink.isDisplayed())
		{
			Reporter.log("show details has changed to hide details", true);
		}
		else if (showDetailsLink.isDisplayed()==true) 
		{
			showDetailsLink.click();
			Reporter.log("hide not displayed yet...", true);
		}
		
		waitUntilElementToBeClickable(driver, preferencesOptionCheckbox);
		
		Reporter.log("stats: "+statisticsOptionInputCheckbox.isSelected(), true); // should be false
		
		Thread.sleep(1000);
		if(preferencesInputCheckbox.isSelected()==true && marketingOptionInputCheckbox.isSelected()== true &&
				statisticsOptionInputCheckbox.isSelected()==false)
		{
			Reporter.log("cookie preferences is saved ", true);
		}
		else
		{
			Reporter.log("cookie preferneces is not saved", true);
		}
		
		waitUntilElementToBeClickable(driver, OKButton);
		performClickUsingActions(driver, OKButton);
	}
	
	public void verifyIfConsentIsWithdrawn() throws InterruptedException
	{
		waitUntilElementToBeClickable(driver, preferencesOptionCheckbox);
		Reporter.log("preferences: "+preferencesInputCheckbox.isSelected(), true);
		Reporter.log("stats: "+statisticsOptionInputCheckbox.isSelected(), true);
		Reporter.log("marketing: "+marketingOptionInputCheckbox.isSelected(), true);
		Thread.sleep(3000);
		if(preferencesInputCheckbox.isSelected()==false && statisticsOptionInputCheckbox.isSelected()==false && 
				marketingOptionInputCheckbox.isSelected()==false)
		{
			Reporter.log("consent has been withdrawn", true);
		}
		else
		{
			Reporter.log("error in withdraw consent", true);
		}
		waitUntilElementToBeClickable(driver, OKButton);
		performClickUsingActions(driver, OKButton);
	}
	
}
