package com.Urbanladder.page;

import java.io.FileInputStream;


import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Urbanladder.base.ExcelHandle;



public class DisplayProducts  {

	
	public WebDriver driver;
	public Properties prop;

	public DisplayProducts(WebDriver driver) {

		this.driver=driver;


	}
	

	
	public   String[][] getDetails()
	{
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		
		try{
		
			List<WebElement> name= PageObject.name;
		
		
		List<WebElement> specification=PageObject.details;
		List<WebElement> price= PageObject.price2;
		
		String [][] write=new String[3][3];
		int j=0;
		for(int i=0;i<3;i++)
		{
		   write[j][0]=name.get(i).getText();
			write[j][1]=specification.get(i).getText();
			write[j][2]=price.get(i).getText();
			j=j+1;
			
		}
		
		return write;
			
	}catch(Exception e) {
		
		e.printStackTrace();
		return null;
		
	}
	}
	

}
