package com.nagp.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagp.amazon.base.TestBase;

public class AmazonLoginPage extends TestBase {

	// Page Factory or Object Repository

	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	WebElement accountListDropdown;

	@FindBy(xpath = "//input[@id='ap_email']") // @FindBY(id="ap_email") can
												// also be used
	WebElement mobileNumber;

	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueButton;

	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	WebElement linkToSignIn;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement signInButton;

	@FindBy(linkText = "Conditions of Use")
	WebElement conditionsLink;

	@FindBy(linkText = "Privacy Notice")
	WebElement privacyNoticeLink;
	
	@FindBy(xpath = "//div[@class='a-alert-content']//span[@class='a-list-item']")
	public WebElement incorrectPasswordAlertMessage;

	public AmazonLoginPage() {
		PageFactory.initElements(driver, this);

	}

	public String openLoginScreen() {
		linkToSignIn.click();
		return driver.getTitle();

	}

	public String validateConditionsOfUse() {
		//Actions action = new Actions(driver);
		//action.moveToElement(accountListDropdown);
		linkToSignIn.click();
		conditionsLink.click();
		return driver.getTitle();
	}

	public String validatePrivacyNotice() {
		linkToSignIn.click();
		privacyNoticeLink.click();
		return driver.getTitle();
	}

	public AmazonHomePage login(String mobile, String pwd) {
		//driver.navigate().back();
		linkToSignIn.click();
		mobileNumber.sendKeys(mobile);
		continueButton.click();
		password.sendKeys(pwd);
		signInButton.click();
		return new AmazonHomePage();

	}

}
