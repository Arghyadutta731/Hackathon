package com.Urbanladder.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FindStudyChair {
	public static WebDriver driver;

	public FindStudyChair(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public void sort_Hover() {
		Actions hover = new Actions(driver);
		hover.moveToElement(PageObject.sort).build().perform();
	}

	public void filterClick() {
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		PageObject.recommend.click();

	}

	public WebElement sort_Hover1() {

		return PageObject.sort;

	}

	public WebElement filter_Click() {

		return PageObject.recommend;

	}
}
