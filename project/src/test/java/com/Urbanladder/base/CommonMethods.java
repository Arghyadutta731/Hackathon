package com.Urbanladder.base;

import java.io.File;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Urbanladder.base.BrowserFactory;
import com.Urbanladder.page.PageObject;



public class CommonMethods {
	
	public static WebDriver driver;
	public static Properties prop;
	//invoking the browser
	@BeforeClass(alwaysRun=true)
	@Parameters({"browser","environment"})
	
	public void createDriver(String browsers,String environment) throws MalformedURLException, Exception 
	{
		
		
		
		
  if(environment.equalsIgnoreCase("grid"))
  {		
	  driver=BrowserFactory.getBrowserGrid(browsers);
   
		
	}
 else
  {
	 driver=BrowserFactory.getWebdriver(browsers); 
  
	}
	}
	
	
	
//close the browser
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();

	}
//scroll elements
	public void scrollPage(WebElement xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView()", (xpath));
	}
	
	
	public void OpenTab()
	{
		Actions a = new Actions(driver);
		a.keyDown(Keys.CONTROL).click(PageObject.bookshelves).keyUp(Keys.CONTROL).build().perform();
	}
	
	public void WindowHandle(int i) {
		List<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(i));
	}
	//open in a new tab
	public void windowHandlesSet() {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> itr = window.iterator();

	     itr.next();
		String childPageID = itr.next();

		driver.switchTo().window(childPageID);
	}

	
//explicit wait
	public void checkVisibility(WebElement xpath)
	{
		WebDriverWait wait=new WebDriverWait(driver,180);
		wait.until(ExpectedConditions.visibilityOf(xpath));
	}
	
	
		
	//Screenshot based on pass or failure result
	
	public void takeScreenshot() throws Exception {

		TakesScreenshot tS = (TakesScreenshot) driver;
		File src = tS.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");

	     FileUtils.copyFile(src, dest);
	     
		
	}
}



