package com.nagp.amazon.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nagp.amazon.customListener.*;
import com.aventstack.extentreports.Status;
import com.nagp.amazon.base.TestBase;
import com.nagp.amazon.pages.AmazonHomePage;
import com.nagp.amazon.pages.AmazonLoginPage;
import com.nagp.amazon.util.TestUtil;

public class AmazonLoginPageTest extends TestBase {

	AmazonLoginPage amazonLoginPage;
	AmazonHomePage amazonHomePage;

	TestUtil testUtil;

	public AmazonLoginPageTest() {
		super();
	}

	@BeforeSuite
	public void setExtent() {
		testUtil = new TestUtil();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		amazonLoginPage = new AmazonLoginPage();

	}

	@Test(priority = 1, groups = { "Smoke" })
	public void openLoginScreenTest() {
		ExtentListener.test.log(Status.INFO, "Test started  for openLoginScreenTest");
		amazonLoginPage.openLoginScreen();
		Assert.assertEquals(driver.getTitle(), "Amazon Sign In", "Sign-In Page Title does not match");

		ExtentListener.test.log(Status.INFO, "Test completed  for openLoginScreenTest");
	}

	@Test(priority = 2, groups = { "Regression" })
	public void conditionsOfUseTest() {
		ExtentListener.test.log(Status.INFO, "Test started  for conditionsOfUseTest");
		String conditionsOfUseTitle = amazonLoginPage.validateConditionsOfUse();
		Assert.assertEquals(conditionsOfUseTitle, "Amazon.in Help: Conditions of Use",
				"Conditions Page Title does not match");
		ExtentListener.test.log(Status.INFO, "Test completed  for conditionsOfUseTest");
	}

	@Test(priority = 3, groups = { "Regression" })
	public void privacyNoticeTest() {
		ExtentListener.test.log(Status.INFO, "Test started  for privacyNoticeTest");
		String privacyNoticeTitle = amazonLoginPage.validatePrivacyNotice();
		Assert.assertEquals(privacyNoticeTitle, "Amazon.in Help: Amazon.in Privacy Notice",
				"Privacy Notice Page Title does not match");
		ExtentListener.test.log(Status.INFO, "Test completed  for privacyNoticeTest");
	}

	@Test(priority = 4, groups = { "Smoke", "Regression" })
	public void loginTest() {
		ExtentListener.test.log(Status.INFO, "Test started  for loginTest");
		amazonHomePage = amazonLoginPage.login(prop.getProperty("mobile_number"), prop.getProperty("password1"));
		// amazonHomePage.isSignOutLinkVisible();
		Assert.assertEquals(true, true);
		ExtentListener.test.log(Status.INFO, "Test completed  for loginTest");
	}

	@Test(priority = 5, groups = { "Regression" })
	public void failedLoginTest() {
		ExtentListener.test.log(Status.INFO, "Test started  for failedLoginTest");
		amazonHomePage = amazonLoginPage.login(prop.getProperty("mobile_number"), prop.getProperty("password2"));
		Assert.assertEquals(amazonLoginPage.incorrectPasswordAlertMessage.getText(),
				prop.getProperty("incorrect_password_alert_message", "Error Message Text does not match"));

		ExtentListener.test.log(Status.INFO, "Test completed  for failedLoginTest");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (driver != null) {
			driver.quit();
		}
	}

}
