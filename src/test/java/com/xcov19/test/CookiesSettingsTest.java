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
		Reporter.log("cookies test", true);
		LoginPage login = new LoginPage(driver);
		login.performLogin();
	}
	
	@Test(priority = 1)
	public void changeCookiesAndVerifyTest() throws IOException, InterruptedException
	{
		HomePage home = new HomePage(driver);
		home.clickOnPrivacyPolicyLink();
		Reporter.log("clicked on privacy policy", true);
		
		PrivacyPolicyPopUp privacy = new PrivacyPolicyPopUp(driver);
		privacy.clickOnChangeYourConscentButton();
		Reporter.log("clicked on Change Your ConsentButton", true);

		
		CookiesPopUp cookies = new CookiesPopUp(driver);
		cookies.changeCookieSettings();
		Reporter.log("changed cookie settings..", true);
		
		privacy.clickOnCloseButton();
		
		//verify cookies after page refresh
		driver.navigate().refresh();
		
		privacy.clickOnBackToSite(); //clicking on back to site when popup appears abruptly
		
		home.clickOnPrivacyPolicyLink();
		Reporter.log("clicked on privacy policy to verify changes", true);
		
		privacy.clickOnChangeYourConscentButton();
		Reporter.log("clicked on Change Your ConsentButton", true);
		
		cookies.verifyIfCookiesPreferencesIsSaved();
		Reporter.log("cookie settings verified on page refresh", true);
		
		privacy.clickOnCloseButton();
		
		//logout and login to check if cookie preferences have been saved
		home.performLogout();
		Reporter.log("logged out", true);
		
		home.clickOnLogIn();
		
		LoginPage login = new LoginPage(driver);
		login.performLogin();
		
		home.clickOnPrivacyPolicyLink();
		Reporter.log("clicked on privacy policy to verify changes", true);
		
		privacy.clickOnChangeYourConscentButton();
		Reporter.log("clicked on Change Your ConsentButton", true);
		
		cookies.verifyIfCookiesPreferencesIsSaved();
		Reporter.log("cookie settings verified", true);
		
	
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
		Reporter.log("logged out", true);
		
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
