package com.xcov19.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xcov19.generics.BasePage;

public class MyProfilePage extends BasePage
{
	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Privacy Policy']")
	private WebElement privacyPolicyLink;
	
	public MyProfilePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPrivacyPolicyLink()
	{
		waitUntilElementToBeClickable(driver, privacyPolicyLink);
		performClickUsingActions(driver, privacyPolicyLink);
		//privacyPolicyLink.click();
	}
}
