/**
 * 
 */
package com.Urbanladder.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Urbanladder.base.BrowserFactory;
import com.Urbanladder.base.CommonMethods;
import com.Urbanladder.base.ExcelHandle;
import com.Urbanladder.base.ExtentReportManager;
import com.Urbanladder.base.dateUtils;
import com.Urbanladder.page.DisplayProducts;
import com.Urbanladder.page.FindBookshelves;
import com.Urbanladder.page.FindStudyChair;
import com.Urbanladder.page.HomePage;
import com.Urbanladder.page.PageObject;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



/**
 * @author DONA
 *
 */
public class UrbanladderTest extends CommonMethods {

	public ExtentReports rep = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;

	//verify the title of the home page
	@Test(priority = 0,groups="Smoke")
	public void titleVerify() {

	 logger = rep.createTest("Home Page Title");

		String homePageTitle = driver.getTitle();
		logger.log(Status.INFO, "verification of home page title");

		Assert.assertEquals(homePageTitle,
				"Furniture Online: Buy Home Wooden Furniture Online In India At Best Price - Urban Ladder - Urban Ladder",
				"Wrong title found");
		logger.log(Status.PASS, "Verified");
		
	}
//clicked on the bokkshelves
	@Test(priority = 1,groups="Smoke")
	public void clickBookshelves() throws Exception {
		// super.scrollPage();
		// super.checkVisibility();

		 logger = rep.createTest("Bookshelf Click");

		HomePage home = new HomePage(driver);
		logger.log(Status.INFO, "clicking on the bookshelf category");
		
		if (home.clickBooks().isDisplayed()) {
			home.clickBookshelves();
			Assert.assertTrue(true);
			logger.log(Status.PASS,"Clicked Successfully");
		} else {
			Assert.assertTrue(false);
			logger.log(Status.FAIL,"Element cannot be clicked");
			takeScreenshot();
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");
		}
		Thread.sleep(2000);
		driver.navigate().refresh();
	
		
	}
	
	
//checking the hovering of price field.
	@Test(priority = 2,groups= {"Smoke","Regression"})
	public void priceChoice() throws Exception {
		 logger = rep.createTest("Price slider is shown");
		FindBookshelves price = new FindBookshelves(driver);
		logger.log(Status.INFO, "Setting the price range of the product");
		WebDriverWait wait=new WebDriverWait(driver,180);
		wait.until(ExpectedConditions.visibilityOf(PageObject.price));
		if (price.price_Hover1().isEnabled()) {
			
			price.price_Hover();
			Assert.assertTrue(true);
			logger.log(Status.PASS,"Element is present");

		} else {
			Assert.assertTrue(false);
			logger.log(Status.FAIL,"Element not visible");
			takeScreenshot();
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");
		}
		Thread.sleep(1000);
	}
//setting the range of price
	@Test(priority = 3,groups= {"Smoke","Regression"})
	public void setRange() throws Exception {
		 logger = rep.createTest("Slider is moved");
		FindBookshelves slider = new FindBookshelves(driver);
		logger.log(Status.INFO, "Checking whether the slider can be moved to the desired price");
		if (slider.price_Range().isEnabled() || slider.price_Range().isDisplayed()) {
			
			WebDriverWait wait=new WebDriverWait(driver,180);
			wait.until(ExpectedConditions.visibilityOf(PageObject.slider));
			slider.priceRange();
			Assert.assertTrue(true);
			logger.log(Status.PASS," price range below 15000");
		} else {
			Assert.assertTrue(false);
			logger.log(Status.FAIL,"price range above 15000");
			takeScreenshot();
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");
		}
		
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
//checking the hovering of the storage field
	@Test(priority = 4,groups= {"Smoke","Regression"})
	public void storageChoice() throws Exception {
		
		 logger = rep.createTest("Storage types are shown");
		FindBookshelves storage = new FindBookshelves(driver);
		logger.log(Status.INFO, "Storage category to be decided");
		if (storage.storage_Hover1().isEnabled()) {

			storage.storage_Hover();
			Assert.assertTrue(true);
			logger.log(Status.PASS," Element present");
		} else {
			Assert.assertTrue(false);
			logger.log(Status.FAIL,"Element invisiblr");
			takeScreenshot();
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");
			
		}
		Thread.sleep(1000);
	}
//selecting specified storage type
	@Test(priority = 5,groups= {"Smoke","Regression"})
	public void checkStorageType() throws Exception {
		 logger = rep.createTest("Storage type is selected");
		FindBookshelves check = new FindBookshelves(driver);
		logger.log(Status.INFO, "Storage type has to be selected");
		
	//	if (check.storageCheck().isEnabled() && check.storageCheck().isDisplayed()) {
			
		   // Assert.assertTrue(true);
		
//			WebDriverWait wait=new WebDriverWait(driver,180);
//			wait.until(ExpectedConditions.visibilityOf(PageObject.checkBox));
			check.storageClick();
			Thread.sleep(1000);
        

		/*	logger.log(Status.PASS,"Selected  Open type");
		} else {
			Assert.assertTrue(false);
			logger.log(Status.FAIL,"Invalid selection");
			takeScreenshot();
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");
		}*/

	}
//include out of stock
	@Test(priority = 6,groups= {"Smoke","Regression"})
	public void includeStock() {
		 logger = rep.createTest("Include out of stock");
		logger.log(Status.INFO, "Include all the items which are out of stock");
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		Assert.assertFalse(PageObject.includeStock.isSelected());
		logger.log(Status.PASS,"Included");
	    driver.navigate().refresh();
	}
//check the hovering of filters
	@Test(priority = 7,groups="Smoke")
	public void filterChoice() throws Exception {
		 logger= rep.createTest("Sorting types are shown");
		FindBookshelves sort = new FindBookshelves(driver);
		logger.log(Status.INFO, "Select the filter");
		if (sort.sort_Hover1().isEnabled()) {
			
			sort.sort_Hover();
			Assert.assertTrue(true);
			logger.log(Status.PASS,"Element visible");
		} else {
			Assert.assertTrue(false);
			logger.log(Status.FAIL,"Element cannot be displayed");
			takeScreenshot();
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");
		}

	}
//select the recommmended filter
	@Test(priority = 8,groups="Smoke")
	public void sortBy() throws Exception {
		 logger = rep.createTest("Sorting type is selected");
		FindBookshelves filter = new FindBookshelves(driver);
		logger.log(Status.INFO, " Sort by the highest recommendation");
		
	//	if (filter.filter_Click().isEnabled() && filter.filter_Click().isSelected()) {

		
		
//			WebDriverWait wait=new WebDriverWait(driver,180);
//			wait.until(ExpectedConditions.visibilityOf(PageObject.recommend));
			filter.filterClick();
		//	Assert.assertTrue(true);
			//logger.log(Status.PASS,"Recommended");
	/*	} else {
			Assert.assertTrue(false);
			logger.log(Status.FAIL,"invalid selection");
			takeScreenshot();
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");
		}*/
			
	}
//checking the popup
	@Test(priority = 9,groups="Smoke")
	public void PopUp() throws Exception {
		 logger = rep.createTest("Pop Up is closed");
		HomePage pop = new HomePage(driver);
		logger.log(Status.INFO, "Pop must be checked");
		
		WebDriverWait wait=new WebDriverWait(driver,180);
		wait.until(ExpectedConditions.visibilityOf(PageObject.close));

		
		if (pop.closePop().isDisplayed() || pop.closePop().isEnabled()) {
			
			Assert.assertTrue(true);
		
			pop.popUp();
			
			logger.log(Status.PASS,"Closed Successfully");

		} else {
			Assert.assertTrue(false);
			logger.log(Status.FAIL,"cannot close the popup");
			takeScreenshot();
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");

		}
		

	}
	
	
	
//displaying the results in excel sheet
	@Test(priority = 10,groups="Smoke")
	public void writeExcel1() throws Exception {
		 logger = rep.createTest("Write in Excel");
		logger.log(Status.INFO, "");
		DisplayProducts get = new DisplayProducts(driver);
		ExcelHandle ex = new ExcelHandle(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\urban.xlsx");
		String[][] excelData = get.getDetails();

		ex.createColumn("Bookshelves", "Name");
		ex.createColumn("Bookshelves", "Specifications");
		ex.createColumn("Bookshelves", "Price");

		ex.setCellData("Bookshelves", excelData);
		Assert.assertTrue(true, "Recommended products written to the Excel file are incorrect");
		logger.log(Status.PASS,"Data are written in the excel successfully");
		takeScreenshot();
		logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");
        
	}
	
	
	@Test(priority=11,groups="Smoke")
	public void studyChoice() throws Exception
	{
		 logger = rep.createTest("Price slider is shown");
		FindBookshelves stud = new FindBookshelves(driver);
		logger.log(Status.INFO, "Selecting study category of the product");
		
		//scrollPage(PageObject.study);
		
		checkVisibility(PageObject.study);
		if (stud.study_Hover1().isEnabled()) {
			
			stud.study_Hover();
			Assert.assertTrue(true);
			logger.log(Status.PASS,"Element is present");

		} else {
			Assert.assertTrue(false);
			logger.log(Status.FAIL,"Element not visible");
			takeScreenshot();
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");
		}
		//Thread.sleep(1000);
	}
	
	@Test(priority=12,groups="Smoke")
	public void studychair()
	{

		ExtentTest logger = rep.createTest("Sorting type is selected");
		FindBookshelves studyChair= new FindBookshelves(driver);
		logger.log(Status.INFO, " ");
		
		studyChair.chairClick();
	}
	
	@Test(priority = 13,groups="Smoke")
	public void filterChoice1() throws Exception {
		 logger= rep.createTest("Sorting types are shown");
		FindStudyChair sort1 = new FindStudyChair(driver);
		logger.log(Status.INFO, "Select the filter");
		if (sort1.sort_Hover1().isEnabled()) {
			
			sort1.sort_Hover();
			Assert.assertTrue(true);
			logger.log(Status.PASS,"Element visible");
		} else {
			Assert.assertTrue(false);
			logger.log(Status.FAIL,"Element cannot be displayed");
			takeScreenshot();
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");
		}

	}
	
	@Test(priority = 14,groups="Smoke")
	public void sortBy1() throws Exception {
		 logger = rep.createTest("Sorting type is selected");
		FindStudyChair filter1 = new FindStudyChair(driver);
		logger.log(Status.INFO, " Sort by the highest recommendation");
		

			filter1.filterClick();
	}
	@Test(priority = 15,groups="Smoke")
	public void writeExcel2() throws Exception {
		 logger = rep.createTest("Write in Excel");
		logger.log(Status.INFO, "");
		DisplayProducts get = new DisplayProducts(driver);
		ExcelHandle ex = new ExcelHandle(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\urban.xlsx");
		String[][] excelData = get.getDetails();

		ex.createColumn("StudyChair", "Name");
		ex.createColumn("StudyChair", "Specifications");
		ex.createColumn("StudyChair", "Price");

		ex.setCellData("StudyChair", excelData);
		Assert.assertTrue(true, "Recommended products written to the Excel file are incorrect");
		logger.log(Status.PASS,"Data are written in the excel successfully");
		takeScreenshot();
		logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");
        
	}
	
	@AfterMethod(alwaysRun=true)
	public void endReport() {
		
		rep.flush();
	}
}
