package com.Urbanladder.page;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class HomePage {
	
	
	public static  WebDriver driver;
	public static Properties prop ;
	PageObject pob;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		pob = new PageObject(driver);
		
		if (prop == null) {
			prop = new Properties();

			try {
				FileInputStream fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\ObjectRepository\\config.properties");
				prop.load(fis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	public   void clickBookshelves() {
		
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		PageObject.bookshelves.click();
		
		
	}
	
	
	
	
	public  void popUp()
	{
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		 PageObject.close.click();
		
	}
	
	public  WebElement closePop()
	{
		return PageObject.close;
	}
	
	
	public  WebElement clickBooks() {
		return PageObject.bookshelves;
	}
	
	
	
	

}
