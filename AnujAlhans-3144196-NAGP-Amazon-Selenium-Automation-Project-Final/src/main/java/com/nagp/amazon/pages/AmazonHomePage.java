package com.nagp.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagp.amazon.base.TestBase;

public class AmazonHomePage extends TestBase {

	public AmazonHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id= 'nav-logo-sprites']")
	WebElement amazonLogo;

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchBox;

	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement searchButton;

	@FindBy(id = "glow-ingress-block")
	public WebElement selectYourAddress;
	
	@FindBy(xpath="//span[@id='glow-ingress-line2']")
	public WebElement enteredLocation;

	@FindBy(id = "GLUXZipUpdateInput")
	WebElement enterPincode;

	@FindBy(xpath = "//span[@id='GLUXZipUpdate']//input[@class='a-button-input']")
	WebElement applyButton;
	
	@FindBy(linkText="Today's Deals")
	WebElement todaysDealsLink;

	public boolean isAmazonLogoVisible() {
		return amazonLogo.isDisplayed();
	}
	
	public String validateTodaysDealsPage(){
		todaysDealsLink.click();
		return driver.getTitle();
	}

	public void enterDeliveryAddressPincode(String pincode) throws InterruptedException {
		selectYourAddress.click();
		enterPincode.sendKeys(pincode);
		Thread.sleep(2000);
		applyButton.click();
		Thread.sleep(3000);
	}

	public void searchProduct(String searchProduct) {
		searchBox.sendKeys(searchProduct);
		searchButton.click();
		//return new AmazonProductSearchResultsPage();
	}

}
