package com.xcov19.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xcov19.generics.BasePage;

public class HomePage extends BasePage
{
	WebDriver driver;
	
	//OK button of cookies
	@FindBy(xpath="//a[@id='CybotCookiebotDialogBodyButtonAccept']")
	private WebElement acceptCookiesOkButton;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement logInSignUpButton;
	
	@FindBy(xpath="//div[@class='d-block']//h2")
	private WebElement findHospitalsNearMeButton;
	
	@FindBy(xpath="//button[text()='Join Now']")
	private WebElement joinNowButton;
	
	@FindBy(xpath="//a[text()='About XCOV19']")
	private WebElement AboutXCov19Link;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement ContactUsLink;
	
	@FindBy(xpath="//a[text()='Privacy Policy']")
	private WebElement privacyPolicyLink;
	
	@FindBy(xpath="//img[@alt='hacktoberfest-sponsors-logo']")
	private WebElement intelLogo;
	
	@FindBy(xpath="//img[@alt='mattermore-logo']")
	private WebElement mattermoreLogo;
	
	@FindBy(xpath="//img[@alt='helpful-logo']")
	private WebElement helpfulLogo;
	
	@FindBy(xpath="//img[@alt='jogl-logo']")
	private WebElement joglLogo;
	
	@FindBy(xpath="//img[@class='avatar']")
	private WebElement usernameIcon;
	
	@FindBy(xpath="//li[text()='My Profile']")
	private WebElement myProfileLink;
	
	@FindBy(xpath="//li[text()=' Log Out']")
	private WebElement logOutLink;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void acceptCookies()
	{
		waitUntilElementToBeClickable(driver, acceptCookiesOkButton);
		acceptCookiesOkButton.click();
	}
	
	public void clickOnLogIn()
	{
		waitUntilElementToBeClickable(driver, logInSignUpButton);
		performClickUsingActions(driver, logInSignUpButton);
	}
	
	public void clickOnPrivacyPolicyLink()
	{
		waitUntilElementToBeClickable(driver, privacyPolicyLink);
		performClickUsingActions(driver, privacyPolicyLink);
		//privacyPolicyLink.click();
	}
	
	public void performLogout()
	{
		
			waitUntilElementToBeClickable(driver, usernameIcon);
			usernameIcon.click();
			waitUntilElementToBeClickable(driver, logOutLink);
			logOutLink.click();
			
	}
}
