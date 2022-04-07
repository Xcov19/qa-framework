package com.xcov19.generics;

import org.testng.Reporter;

public class Logger
{
	public static void info(String message)
	{
		
		Reporter.log("--------------------------------------------", true);
		Reporter.log("[INFO] "+ message, true);
		Reporter.log("--------------------------------------------", true);
	}
	public static void debug(String message)
	{	
		Reporter.log(message, true);
	}
	public static void error(String message)
	{
		
		Reporter.log("****************************************************", true);
		Reporter.log("[ERROR] "+ message, true);
		Reporter.log("****************************************************", true);
	}
	
}
