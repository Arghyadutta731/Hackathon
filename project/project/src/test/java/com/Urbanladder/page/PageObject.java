package com.Urbanladder.page;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	
	
	
	
	public WebDriver driver;

	public PageObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='category' and @href='/bookshelf?src=explore_categories']")
	public static  WebElement  bookshelves;

	@FindBy(xpath="//a[contains(@class,'close-reveal-modal hide-mobile')]")
	public static WebElement close;
	
	@FindBy(xpath="//div[contains(text(),'Price')]")
	public static WebElement price;
	
	@FindBy(xpath="//li[@data-group='storage type']/div[@class='gname']")
	public static WebElement storage;
	
	@FindBy(xpath="//div[@class='item' and @data-group='sorting']/div[@class='gname']")
    public static WebElement sort;

	@FindBy(xpath="//div[contains(@class,'noUi-handle noUi-handle-upper')]")
	public static WebElement slider;
	
	@FindBy(xpath="//input[@type='checkbox' and @value='Open']")
	public static WebElement checkBox;

	@FindBy(xpath="//li[text()='Recommended']")
	public static WebElement recommend;

	@FindBy(xpath="//input[@type='checkbox' and @ id='filters_availability_In_Stock_Only']")
	public static WebElement includeStock;

	@FindBy(xpath="//div[@class='product-title product-title-sofa-mattresses']/span")
	public static List<WebElement> name;
	
	@FindBy(xpath="//div[@class='product-title product-title-sofa-mattresses']/div")
	public static List<WebElement> details;
	
	@FindBy(xpath="//div[@class='price-number']/span")
	public static List<WebElement> price2;
	
	@FindBy(xpath="//span[@class='topnav_itemname'][contains(text(),'Study')]")
	
	public static WebElement study;
	
	
	@FindBy(xpath="//li[@class='subnav_item 1730']/a/span")
	
	public static WebElement studychair;
	
	
	@FindBy(xpath="//input[@type='checkbox' and @value='Closed']")
	public static WebElement closed;
	
	
	
	
	


}



