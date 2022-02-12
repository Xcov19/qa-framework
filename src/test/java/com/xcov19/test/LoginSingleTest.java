package com.xcov19.test;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
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
import java.io.IOException;

import org.testng.annotations.Test;

import com.xcov19.generics.BaseTest;
import com.xcov19.pom.LoginPage;

@Listeners(com.xcov19.generics.ScreenshotUtility.class)
public class LoginSingleTest extends BaseTest
{
	@Test
	public void performLoginOnce() throws IOException
	{
		Reporter.log("login single  test", true);
		LoginPage login = new LoginPage(driver);
		login.performLogin();
	}
}
