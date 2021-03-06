package com.xcov19.generics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	
	//wait until visibility of Element
	public void waitUntilVisibilityOfElement(WebDriver driver, WebElement e)
	{
		Duration timeout = Duration.ofSeconds(30);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	//wait until element to be clickable 
	public void waitUntilElementToBeClickable(WebDriver driver, WebElement e)
	{
		Duration timeout = Duration.ofSeconds(30);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	//wait until visibility of all elements
	public void waitUntilVisibilityOfAllElements(WebDriver driver, List<WebElement> li)
	{
		Duration timeout = Duration.ofSeconds(30);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElements(li));
	}
	
	//click using Actions class
	public void performClickUsingActions(WebDriver driver, WebElement e)
	{
		Actions ac = new Actions(driver);
		ac.click(e).perform();
	}
	
	//double click using Actions class
	public void performDoubleClickUsingActions(WebDriver driver, WebElement e)
	{
		Actions ac = new Actions(driver);
		ac.doubleClick(e).perform();
	}
	
	//mouse hover using Actions class
	public void performMouseHoverUsingActions(WebDriver driver, WebElement e)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(e).perform();
	}
	
	//right click using Actions class
	public void performContextClickUsingActions(WebDriver driver, WebElement e)
	{
		Actions ac = new Actions(driver);
		ac.contextClick(e).perform();
	}
	
	//drag and drop using Actions class
	public void performDragAndDropUsingActions(WebDriver driver, WebElement source, WebElement target)
	{
		Actions ac = new Actions(driver);
		ac.dragAndDrop(source, target).perform();
	}
	
	//arrow up key
	public void arrowUpUsingRobot(int n) throws AWTException
	{
		Robot r = new Robot();
		for(int i=0;i<n;i++)
		{
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		}
		
	}
	
	//arrow down key
	public void arrowDownUsingRobot(int n) throws AWTException
	{
		Robot r = new Robot();
		for(int i=0;i<n;i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		
	}
	
	//arrow left key
	public void arrowLeftUsingRobot(int n) throws AWTException
	{
		Robot r = new Robot();
		for(int i=0;i<n;i++)
		{
			r.keyPress(KeyEvent.VK_LEFT);
			r.keyRelease(KeyEvent.VK_LEFT);
		}
		
	}
	
	//arrow right key
	public void arrowRightUsingRobot(int n) throws AWTException
	{
		Robot r = new Robot();
		for(int i=0;i<n;i++)
		{
			r.keyPress(KeyEvent.VK_RIGHT);
			r.keyRelease(KeyEvent.VK_RIGHT);
		}
		
	}
	
	//enter key
	public void pressEnterUsingRobot() throws AWTException
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//click using Javascript Executor
	public void performClickUsingJavascriptExecutor(WebDriver driver, WebElement e)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", e);
	}
	
	//sendkeys using Javascript Executor
	public void performSendKeysUsingJavascriptExecutor(WebDriver driver, WebElement e, String val)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+val+"'", e);
	}
	
	//page scroll using Javascript Executor
	public void performScrollUsingJavascriptExecutor(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(x, y)");
	}
	
	//Select by value
	public void selectByValue(WebElement e, String val)
	{
		Select sel = new Select(e);
		sel.selectByValue(val);
	}
	
	//Select by visible text
	public void selectByVisibleText(WebElement e, String text)
	{
		Select sel = new Select(e);
		sel.selectByVisibleText(text);
	}
	
	//select by index
	public void selectByIndex(WebElement e, int index)
	{
		Select sel = new Select(e);
		sel.selectByIndex(index);
	}
	
	//get all options in a drop down using select
	public void getSelectOptions(WebElement e)
	{
		Select sel = new Select(e);
		List<WebElement> li = sel.getOptions();
		for(int i=0;i<li.size();i++)
		{
			System.out.println("the select dropdown options are "+li.get(i).getText());
		}
	}
	
	//deselect by visible text
	public void deselectByVisibleText(WebElement e, String text)
	{
		Select sel = new Select(e);
		sel.deselectByVisibleText(text);
	}
	
	//deselect by value
	public void deselectByValue(WebElement e, String val )
	{
		Select sel = new Select(e);
		sel.deselectByValue(val);;
	}
	
	//click OK(accept) on an alert pop up
	public void acceptAlert(WebDriver driver)
	{
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	
	//click cancel(dismiss) on an alert pop up
	public void dismissAlert(WebDriver driver)
	{
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}
	
	//switch to the required child browser/window
	public void switchWindow(WebDriver driver, int index)
	{
		Set<String> s = driver.getWindowHandles();
		ArrayList<String> windowHandles = new ArrayList<String>(s);
		
		//run for loop to find out the required window index
//		for(int i=0;i<windowHandles.size();i++)
//		{
//			String current_window = driver.switchTo().window(windowHandles.get(i)).getTitle();
//			System.out.println("current window is "+current_window);
//		}
		driver.switchTo().window(windowHandles.get(index));
	}
	
	//switch frame using index
	public void switchFrameUsingIndex(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	//switch frame using name
	public void switchFrameUsingName(WebDriver driver, String name)
	{
		driver.switchTo().frame(name);
	}
	
	//switch frame using id
	public void switchFrameUsingId(WebDriver driver, String id)
	{
		driver.switchTo().frame(id);
	}
	
	//open a new tab
	public void openNewTab(WebDriver driver)
	{
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
	//open a new window
	public void openNewWindow(WebDriver driver)
	{
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
	
	//access data from properties file
	public void propeties() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("./test-data/config.properties");
		prop.load(file);
	}
	
}
