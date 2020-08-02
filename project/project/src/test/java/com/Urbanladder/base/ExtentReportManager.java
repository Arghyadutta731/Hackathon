

/**

 * 
 */

 package com.Urbanladder.base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


/**
 * @author DONA
 *
 */

public class ExtentReportManager {

	
	public static ExtentReports rep;

	public static ExtentReports getReportInstance() {

		if ( rep == null) {
			
			String reportName=dateUtils.getTimestamp()+".html";
			ExtentHtmlReporter htmlrep = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output"+reportName);

		    rep = new ExtentReports();
		    rep.attachReporter(htmlrep);
		    
		  
		    rep.setSystemInfo("OS", "Windows 10");
		    rep.setSystemInfo("Environment", "UAT");
		    rep.setSystemInfo("Build Number", "10.8.1");
		    rep.setSystemInfo("Browser", "Chrome");
		    
		    
		   
		    htmlrep.config().setDocumentTitle("UI Automation Result(UAT)");  
		    htmlrep.config().setReportName("All Headlines UI test report");
		    htmlrep.config().setTestViewChartLocation(ChartLocation.TOP);
		    htmlrep.config().setTimeStampFormat("MM dd,yyyy HH:mm:ss");
		    htmlrep.config().setTheme(Theme.DARK);
		    		
		    
		    
		    
		    
	}

		return rep;

	}

}