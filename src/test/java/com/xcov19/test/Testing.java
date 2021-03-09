package com.xcov19.test;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.xcov19.generics.BaseTest;

public class Testing extends BaseTest
{

	@Test
	public void test()
	{
		Reporter.log("testing", true);
	}
}
