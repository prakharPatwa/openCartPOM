package com.qa.openCart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.openCart.base.BasePage;
import com.qa.openCart.utils.Constants;
import com.qa.openCart.utils.ElementUtil;

import io.qameta.allure.Step;

public class AccountsPage extends BasePage{
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By header = By.xpath("//div[@id='logo']/h1");
	private By shoppingCart = By.xpath("//span[@id='cart-total']");
	private By menuNav = By.xpath("//nav[@id='menu']//div[2]/ul/li");
	private By accountSectionsHeaders = By.xpath("//div[@id='content']//h2");
	private By searchText = By.xpath("//div[@id='search']//input[@name='search']");
	private By searchButton = By.xpath("//div[@id='search']/span/button");
	private By searchItemresult = By.cssSelector(".product-layout .product-thumb");
	private By resultItems = By.cssSelector(".product-thumb h4 a");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	@Step("Getting the Account page title")
	public String getAccountPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.ACCOUNT_PAGE_TITLE, 10);
	}
	
	@Step("Getting the Account page header title")
	public String getAccountPageHeaderValue() {
		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}
	
	@Step("Getting the Account Section counts")
	public int getAccountSectionCount() {
		return elementUtil.getElements(accountSectionsHeaders).size();
	}
	
	@Step("Getting the Account Section lists")
	public List<String> getAccountSectionsList() {
		List<String> accList = new ArrayList<String>();
		List<WebElement> accSectionLists = elementUtil.getElements(accountSectionsHeaders);
		for(WebElement e:accSectionLists) {
			accList.add(e.getText());
		}
		return accList;
	}
	
	@Step("Checking the Account navbar exists")
	public boolean isMenuNavbarExist() {
		if(elementUtil.getElements(menuNav).size()>0) {
			return true;
		}
		return false;
	}
	
	@Step("Checking Shopping Cart value")
	public String getShoppingCartValue() {
		if(elementUtil.doIsDisplayed(shoppingCart)) {
			return elementUtil.doGetText(shoppingCart);
		}
		return null;
	}
	
	@Step("Searching for a product name : {0}")
	public boolean doSearch(String productName) {
		elementUtil.doSendKeys(searchText, productName);
		elementUtil.doClick(searchButton);
		if(elementUtil.getElements(searchItemresult).size()>0) {
			return true;
		}
		return false;
	}
	
	@Step("Searching result for a particular product name : {0}")
	public ProductInfoPage selectProductFromResults(String productName) {
		List<WebElement> resultItemLists =  elementUtil.getElements(resultItems);
		System.out.println("total numbers of items are "+resultItemLists.size());
		
		for(WebElement e:resultItemLists) {
			if(e.getText().equals(productName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
	
}
