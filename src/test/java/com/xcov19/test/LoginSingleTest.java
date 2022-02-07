package com.xcov19.test;

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

public class LoginSingleTest extends BaseTest
{
	@Test
	public void performLoginOnce() throws IOException
	{
		LoginPage login = new LoginPage(driver);
		login.performLogin();
	}
}
