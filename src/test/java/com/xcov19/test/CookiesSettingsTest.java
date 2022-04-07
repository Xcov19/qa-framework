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
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.xcov19.generics.BaseTest;
import com.xcov19.generics.Logger;
import com.xcov19.pom.CookiesPopUp;
import com.xcov19.pom.HomePage;
import com.xcov19.pom.LoginPage;
import com.xcov19.pom.MyProfilePage;
import com.xcov19.pom.PrivacyPolicyPopUp;

public class CookiesSettingsTest extends BaseTest
{
	@Test(priority = 0)
	public void performLoginOnce() throws IOException
	{
		Logger.info("cookies test");
		LoginPage login = new LoginPage(driver);
		login.performLogin();
	}
	
	@Test(priority = 1)
	public void changeCookiesAndVerifyTest() throws IOException, InterruptedException
	{
		HomePage home = new HomePage(driver);
		home.clickOnPrivacyPolicyLink();
		Logger.info("clicked on privacy policy");
		
		PrivacyPolicyPopUp privacy = new PrivacyPolicyPopUp(driver);
		privacy.clickOnChangeYourConscentButton();
		Logger.info("clicked on Change Your ConsentButton");

		
		CookiesPopUp cookies = new CookiesPopUp(driver);
		cookies.changeCookieSettings();
		Logger.info("changed cookie settings..");
		
		privacy.clickOnCloseButton();
		
		//verify cookies after page refresh
		driver.navigate().refresh();
		
		privacy.clickOnBackToSite(); //clicking on back to site when popup appears abruptly
		
		home.clickOnPrivacyPolicyLink();
		Logger.info("clicked on privacy policy to verify changes");
		
		privacy.clickOnChangeYourConscentButton();
		Logger.info("clicked on Change Your ConsentButton");
		
		cookies.verifyIfCookiesPreferencesIsSaved();
		Logger.info("cookie settings verified on page refresh");
		
		privacy.clickOnCloseButton();
		
		//logout and login to check if cookie preferences have been saved
		home.performLogout();
		Logger.info("logged out");
		
		home.clickOnLogIn();
		
		LoginPage login = new LoginPage(driver);
		login.performLogin();
		
		home.clickOnPrivacyPolicyLink();
		Logger.info("clicked on privacy policy to verify changes");
		
		privacy.clickOnChangeYourConscentButton();
		Logger.info("clicked on Change Your ConsentButton");
		
		cookies.verifyIfCookiesPreferencesIsSaved();
		Logger.info("cookie settings verified");
		
	
		privacy.clickOnCloseButton();
	}
	
	@Test(priority = 2)
	public void withDrawConsentTest() throws InterruptedException, IOException
	{
		HomePage home = new HomePage(driver);
		home.clickOnPrivacyPolicyLink();
		
		PrivacyPolicyPopUp privacy = new PrivacyPolicyPopUp(driver);
		privacy.clickOnWithdrawConsent();
				
		//refresh and verify if consent has been withdrawn
		driver.navigate().refresh();
		privacy.clickOnBackToSite(); //clicking on back to site when popup appears abruptly
		
		home.clickOnPrivacyPolicyLink();
		privacy.checkIfWithdrawConsentButtonIsDisplayed();
		privacy.clickOnChangeYourConscentButton();
		
		CookiesPopUp cookies = new CookiesPopUp(driver);
		cookies.verifyIfConsentIsWithdrawn();
		
		privacy.clickOnCloseButton();
		
		//logout and login to check if cookie preferences have been saved
		home.performLogout();
		Logger.info("logged out");
		
		home.clickOnLogIn();
		
		LoginPage login = new LoginPage(driver);
		login.performLogin();
		
		home.clickOnPrivacyPolicyLink();
		privacy.checkIfWithdrawConsentButtonIsDisplayed();
		privacy.clickOnChangeYourConscentButton();
		
		cookies.verifyIfConsentIsWithdrawn();
		
		privacy.clickOnCloseButton();
		Reporter.log("-------------------------------------------------------------------", true);
	}
}
