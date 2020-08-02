package com.Urbanladder.page;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Urbanladder.base.ExcelHandle;



public class FindBookshelves  {
	
	
	public static WebDriver driver;
	public static String read;

	public FindBookshelves(WebDriver driver)
	{
		
		this.driver=driver;
	
	}
	
	
	public  void price_Hover() {
		Actions hover = new Actions(driver);
		hover.moveToElement(PageObject.price).build().perform();
	}
	

	public  void priceRange() {
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		Actions slider = new Actions(driver);
		slider.dragAndDropBy(PageObject.slider, -209, 0).build().perform();


	}
	
	public  void storage_Hover() {
		Actions hover = new Actions(driver);
		hover.moveToElement(PageObject.storage).build().perform();
	}
	
	public  void storageClick() {
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		PageObject.checkBox.click();
		
	}
	
	public  void sort_Hover() {
		Actions hover = new Actions(driver);
		hover.moveToElement(PageObject.sort).build().perform();
	}
	public  void filterClick() {
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		PageObject.recommend.click();
		

	}
	
	public  void study_Hover() {
		Actions hover = new Actions(driver);
		hover.moveToElement(PageObject.study).build().perform();
	}
	
	public  void chairClick() {
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		PageObject.studychair.click();
		

	}
	
	public void searchBar() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		PageObject.search.clear();
		
		ExcelHandle ex = new ExcelHandle(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\urbanRead.xlsx");
		read=ex.getCellValue("search", 1, 1);
		
		
		PageObject.search.sendKeys(read);
		Thread.sleep(1000);
		PageObject.search.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
	
	}
	
	
	public  WebElement storageCheck() {
		
		return PageObject.checkBox;

	}
	
	public  WebElement price_Range() {
		
		return  PageObject.slider;

	}
	public  WebElement filter_Click() {
		
		return PageObject.recommend;

	}
	public  WebElement price_Hover1() {
		
		return PageObject.price;
	}
	public  WebElement storage_Hover1() {
		
		return PageObject.storage;
	}
	public  WebElement sort_Hover1() {
		
		return PageObject.sort;
	}
	
	public  WebElement study_Hover1() {
		
		return PageObject.study;
	}
	
public  WebElement chair_Hover1() {
		
		return PageObject.studychair;
	}




public  void priceRangeNegative() {
	driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	Actions slider = new Actions(driver);
	slider.dragAndDropBy(PageObject.slider, 0, 0).build().perform();


}
public  WebElement price_Range1() {
	
	return  PageObject.slider;

}
public  void storageClickNeg() {
	driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	PageObject.closed.click();
	
}
public  WebElement storage_Neg() {
	
	return  PageObject.closed;

}
}










