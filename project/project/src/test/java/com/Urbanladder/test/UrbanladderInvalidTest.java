/**
 * 
 */
package com.Urbanladder.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Urbanladder.base.CommonMethods;
import com.Urbanladder.base.ExtentReportManager;
import com.Urbanladder.base.dateUtils;
import com.Urbanladder.page.FindBookshelves;
import com.Urbanladder.page.HomePage;
import com.Urbanladder.page.PageObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

/**
 * @author Sayan
 
 */
public class UrbanladderInvalidTest extends CommonMethods {

	/**
	 * 
	 */
	
	public ExtentReports rep = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	
	
	
	@Test(priority = 0)
	public void clickBookshelves1() throws Exception {
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
	
	@Test(priority = 1)
	public void priceChoice1() throws Exception {
		 logger = rep.createTest("Price slider is shown");
		FindBookshelves price = new FindBookshelves(driver);
		logger.log(Status.INFO, "Setting the price range of the product-Negative");
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
	
	@Test(priority=2)
	public void setRange1() throws Exception {
    logger= rep.createTest("Slider is moved-Negative Test");
		FindBookshelves slide = new FindBookshelves(driver);
		logger.log(Status.INFO, "Checking whether the slider can be moved to the desired price");
	
			
			WebDriverWait wait=new WebDriverWait(driver,180);
			wait.until(ExpectedConditions.visibilityOf(PageObject.slider));
			slide.priceRangeNegative();
			Assert.assertTrue(true);
			logger.log(Status.FAIL,"Element cannot be clicked");
			takeScreenshot();
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");
			
			
			Thread.sleep(3000);
			driver.navigate().refresh();
	}
	
	/*@AfterMethod(alwaysRun= true)
	public void getResult(ITestResult result) throws Exception {
		if(result.getStatus()== ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Failed Test is"+result.getName());
			logger.log(Status.FAIL, result.getThrowable());
			
		}
		else if(result.getStatus()== ITestResult.SKIP) {
			logger.log(Status.SKIP, "Skipped Test is"+result.getName());
			logger.log(Status.SKIP, result.getThrowable());
		}
	}*/
	
	@Test(priority = 3)
	public void storageChoice1() throws Exception {
		
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
	
	
	

	@Test(priority=4)
	public void closedType() throws Exception {
    logger= rep.createTest("Slider is moved-Negative Test");
		FindBookshelves close = new FindBookshelves(driver);
		logger.log(Status.INFO, "Checking whether the slider can be moved to the desired price");
	
			
			
			close.storageClickNeg();
			Thread.sleep(1000);
			Assert.assertTrue(true);
			logger.log(Status.FAIL,"Element cannot be clicked");
			takeScreenshot();
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshot\\" +dateUtils.getTimestamp()+".png");
			
	}
	
	
	
	@Test(priority =5)
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
	@AfterMethod(alwaysRun=true)
	public void endReport() {
		
		rep.flush();
	}
	
}

