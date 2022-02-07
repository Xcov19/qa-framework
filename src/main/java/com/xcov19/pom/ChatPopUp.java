package com.xcov19.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.xcov19.generics.BasePage;

public class ChatPopUp extends BasePage
{
	WebDriver driver;
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement chatIcon;
	
	@FindBy(id="a2ar5bhoa5081641603875880")
	private WebElement frameElement;
	
	@FindBy(xpath="//button[text()=' Yes, I Accept ']")
	private WebElement acceptCookiesButtonOnChatBox;
	
	@FindBy(xpath="//button[text()=' No, Not Now ']")
	private WebElement notNowButtonOnChatBox;
	
	@FindBy(xpath = "//div[@class='tawk-min-container']//button")
	private WebElement closeChatPopUpButton;
	
	@FindBy(xpath = "(//input[@class='tawk-input'])[1]")
	private WebElement NameField;
	
	@FindBy(xpath = "(//input[@class='tawk-input'])[2]")
	private WebElement emailField;
	
	@FindBy(xpath = "//div[@class='tawk-form-wrapper tawk-margin-small']//textarea")
	private WebElement messageField;
	
	@FindBy(xpath = "//div[@class='tawk-form-footer']//button")
	private WebElement submitButton;
	
	@FindBy(xpath = "//button[text()=' Send Again ']")
	private WebElement sendAgainButton;
	
	public ChatPopUp(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnChatIcon() throws InterruptedException
	{
		Thread.sleep(2000);
		Reporter.log("switching to frame", true);		

		//switching to the frame having chat icon
		driver.switchTo().frame(2);
		
		waitUntilElementToBeClickable(driver, chatIcon);
		chatIcon.click();
		Reporter.log("switcheddd to frame", true);
		
		//swicthing to parent
		switchToParentFrame(driver);
		
		//switching to other frame that has accept cookies button
		switchFrameUsingIndex(driver, 3);
		
		Reporter.log("entered inner frame", true);
		waitUntilElementToBeClickable(driver, acceptCookiesButtonOnChatBox);
		acceptCookiesButtonOnChatBox.click();
		Reporter.log("accepted cookies", true);
	
	}
	
	public void sendMessageOnChatPopUpOnce()
	{
		waitUntilElementToBeClickable(driver, NameField);
		NameField.sendKeys("test");
		waitUntilElementToBeClickable(driver, emailField);
		emailField.sendKeys("testxcov19@gmail.com");
		waitUntilElementToBeClickable(driver, messageField);
		messageField.sendKeys("testing");
		waitUntilElementToBeClickable(driver, submitButton);
		submitButton.click();
		waitUntilElementToBeClickable(driver, sendAgainButton);
		if(sendAgainButton.isDisplayed())
		{
			Reporter.log("message sent", true);
		}
		else
		{
			Reporter.log("message not sent", true);
		}
		
	}
	
	public void CloseChatPopUp()
	{
		//switching to parent frame after performing chat tasks
		switchToParentFrame(driver);
		switchFrameUsingIndex(driver, 2); //switch to the frame having close button
		waitUntilElementToBeClickable(driver, closeChatPopUpButton);
		closeChatPopUpButton.click();
		switchToParentFrame(driver);
	}
}
