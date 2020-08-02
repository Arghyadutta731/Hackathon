package com.Urbanladder.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static String Node;
	//private static String browser;

	public static WebDriver getWebdriver(String browser) throws Exception {
		
		
		System.out.println("Starting" + browser + "locally");
		if (prop == null) {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\ObjectRepository\\config.properties");
			prop = new Properties();			
			prop.load(file);			
	}
		

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge2")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("URL"));
		return driver;
	}
	
	public static WebDriver getBrowserGrid(String browser) throws MalformedURLException, Exception
	{

		if (prop == null) {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\ObjectRepository\\config.properties");
			prop = new Properties();			
			prop.load(file);			
	}
		
		if (browser.equalsIgnoreCase("chrome")) {
			
			System.out.println(" Executing on Chrome");
	          Node ="http://192.168.0.109:4444/wd/hub";
	         new DesiredCapabilities();
	         DesiredCapabilities cap = DesiredCapabilities.chrome();
	         ChromeOptions op=new ChromeOptions();
	         
	         cap.setBrowserName("Chrome");
	         cap.setPlatform(Platform.WINDOWS);
	         cap.setCapability(ChromeOptions.CAPABILITY,op);
	       
	       // op.merge(cap);
	         
	         driver = new RemoteWebDriver(new URL(Node), cap);
	         
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
	         driver.manage().window().maximize();
	 		
	 		driver.get(prop.getProperty("URL"));
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			
			System.out.println(" Executing on FireFox");
	        Node =" http://192.168.0.109:4444/wd/hub";
	        new DesiredCapabilities();
	         DesiredCapabilities cap = DesiredCapabilities.firefox();
	         
	         
	         cap.setBrowserName("firefox");
	         cap.setPlatform(Platform.WINDOWS);
	        
	         
	        // op1.merge(cap);
	         driver = new RemoteWebDriver(new URL(Node), cap);
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
	         driver.manage().window().maximize();
	 		
	 		driver.get(prop.getProperty("URL"));
			
		}
		 else if (browser.equalsIgnoreCase("edge")) {
				
				System.out.println(" Executing on Edge");
		        Node =" http://192.168.0.109:4444/wd/hub";
		        new DesiredCapabilities();
		         DesiredCapabilities cap = DesiredCapabilities.edge();
		         
		         
		         cap.setBrowserName("edge");
		         cap.setPlatform(Platform.WINDOWS);
		        
		         
		        // op1.merge(cap);
		         driver = new RemoteWebDriver(new URL(Node), cap);
		         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		         driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		         driver.manage().window().maximize();
		 		
		 		driver.get(prop.getProperty("URL"));
				
			}
		else {
	         throw new IllegalArgumentException("The Browser Type is Undefined");
	      }
		
		
		
		return driver;
	}

}