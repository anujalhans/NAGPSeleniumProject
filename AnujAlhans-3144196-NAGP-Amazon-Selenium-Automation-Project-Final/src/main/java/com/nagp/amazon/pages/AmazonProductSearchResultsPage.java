package com.nagp.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagp.amazon.base.TestBase;
import com.nagp.amazon.util.TestUtil;

public class AmazonProductSearchResultsPage extends TestBase {

	@FindBy(xpath = "//select[@id='s-result-sort-select']")
	// "//span[@id='a-autoid-0']//span[@class='a-button-inner']")
	WebElement sortByDropDownMenu;

	@FindBy(xpath = "//span[@class='a-price']//span[@class='a-offscreen']")
	WebElement priceOfSortedProduct;

	public AmazonProductSearchResultsPage() {
		PageFactory.initElements(driver, this);
	}

	// public void validateClickonSortByDropDownMenu(){
	// sortByDropDownMenu.click();
	// }

	public void chooseSortSearchResultsByPriceLowToHigh(String val) {
		TestUtil.selectValueFromDropDown(sortByDropDownMenu, val);

	}

	public Boolean validateSearchResultsAreSortedByPriceLowToHigh() {
		Boolean condition = false;
		//This will store all the search results in a List.
		List<WebElement> listOfSortedProductPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		//System.out.println(listOfSortedProductPrices.size());
		for (int i = 0; i < listOfSortedProductPrices.size(); i++) {
			//System.out.println(listOfSortedProductPrices.get(i).getText());
			condition = Integer.parseInt(listOfSortedProductPrices.get(i).getText().replace(",", "")) < Integer
					.parseInt((listOfSortedProductPrices.get(i + 1).getText()).replace(",", ""));
			if (condition) {
				System.out.println("Lowest Price is :" + listOfSortedProductPrices.get(i).getText());
				break;
			}

		}
		return condition;
	}

}
