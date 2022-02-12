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
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.xcov19.generics.BaseTest;
import com.xcov19.generics.ExcelLibrary;
import com.xcov19.pom.ChatPopUp;
import com.xcov19.pom.LoginPage;

public class ChatTest extends BaseTest
{
	
	@Test(priority = 1)
	public void openChatPopUpTest() throws InterruptedException
	{
		Reporter.log("chat test", true);
		LoginPage login = new LoginPage(driver);
		try {
			login.performLogin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ChatPopUp chat = new ChatPopUp(driver);
		chat.clickOnChatIcon();
		
	}
	
	@Test(priority = 2)
	public void sendMessageOnChatTest()
	{
		
		ChatPopUp chat = new ChatPopUp(driver);
		chat.sendMessageOnChatPopUpOnce();
	}
	
	@DataProvider(name = "chatData")
	public Object[][] chatdetails() throws IOException
	{
		Object[][] details = new Object[4][3];
		for(int i=0; i<details.length;i++)
		{
			for(int j=0; j<details[0].length;j++)
			{
				details[i][j] = ExcelLibrary.cellValue("ChatDetails", i+1, j);
			}
		}
		Reporter.log("details: " + details, true);
		return details;
	}

	@Test(dataProvider = "chatData", priority = 2, invocationCount = 0)
	public void chatBoxValidation(String name, String email, String message) throws InterruptedException
	{
		Reporter.log("name: " + name + " email: " + email, true);
		
		WebElement nameField = driver.findElement(By.xpath("//input[@aria-placeholder='Name']"));
		WebElement emailField = driver.findElement(By.xpath("(//input[@aria-placeholder='Email'])"));
		WebElement messageField = driver.findElement(By.xpath("//div[@class='tawk-form-wrapper tawk-margin-small']//textarea"));
		WebElement submitButton = driver.findElement(By.xpath("//div[@class='tawk-form-footer']//button"));
		
		Reporter.log("entering name "+name, true);
		Duration timeout = Duration.ofSeconds(10);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		wait.until(ExpectedConditions.visibilityOf(nameField));

		nameField.clear();
		nameField.sendKeys(name);
	
		wait.until(ExpectedConditions.visibilityOf(emailField));
		Reporter.log("entering email "+email, true);
		emailField.clear();
		emailField.sendKeys(email);	

		wait.until(ExpectedConditions.visibilityOf(messageField));
		messageField.clear();
		messageField.sendKeys(message);
		
		Reporter.log("submitting...", true);
		wait.until(ExpectedConditions.visibilityOf(submitButton));
		submitButton.click();
		
		WebElement sendAgainButton = driver.findElement(By.xpath("//button[text()=' Send Again ']"));
//		wait.until(ExpectedConditions.visibilityOf(sendAgainButton));
		Thread.sleep(500);
		if(sendAgainButton.isDisplayed()==true)
		{
			Reporter.log("message sent", true);
		}
		else
		{
			Reporter.log("message not sent", true);
		}
		
	}
	
	@Test(priority = 3)
	public void closeChatPopUpTest()
	{
		ChatPopUp chat = new ChatPopUp(driver);
		chat.CloseChatPopUp();
	}
}
