package com.nagp.amazon.customListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nagp.amazon.base.TestBase;

public class ExtentManager extends TestBase {

	/*
	 * This method to be used in ExtentListeners class to create instance of
	 * extent report.
	 */
	public static ExtentReports createReport(String fileName) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		ExtentReports extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Employee Name", "Anuj Alhans");
		extent.setSystemInfo("Employee Code", "3144196");
		extent.setSystemInfo("Project Name", "NAGP Amazon Automation Selenium Project");
		extent.setSystemInfo("NAGP Assignment #", "2");
		extent.setSystemInfo("Organization", "Nagarro");
		//extent.setSystemInfo("Browser", prop.getProperty("browser"));

		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("NAGP Amazon Automated Test Results");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Test Report for Amazon Testing Framework designed by Anuj Alhans");
		htmlReporter.config().setCSS(".r-img { width: 50%; }");

		return extent;
	}

}
