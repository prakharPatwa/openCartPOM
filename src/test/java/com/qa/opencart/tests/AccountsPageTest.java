package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.openCart.base.BaseTest;
import com.qa.openCart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100 : define Accounts page features")
@Story("US 101 : define Accounts page class with title, header, menu bar, shopping cart and search functionality")
public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void homePageSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Description("Verify Account Page title")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void accountAccountTitleTextTest() {
		String title = accountsPage.getAccountPageTitle();
		System.out.println("Home Page title is - "+title);
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Description("Verify Header Page title")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2)
	public void homePageHeaderTest() {
		String headerValue = accountsPage.getAccountPageHeaderValue();
		Assert.assertEquals(headerValue, Constants.ACCOUNT_PAGE_HEADER_VALUE);
	}
	
	@Description("Verify Menu Bar")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void verifyMenuBarTest() {
		Assert.assertTrue(accountsPage.isMenuNavbarExist());
	}
	
	@Description("Verify Shopping Cart text")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 4)
	public void verifyShoppingCartTextTest() {
		String cartVlue = accountsPage.getShoppingCartValue();
		Assert.assertEquals(cartVlue, Constants.ACCOUNT_PAGE_CART_VALUE);
	}
	
	@Description("Verify Account Section counts")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 5)
	public void verifyMyAccountSectionsCountTest() {
		Assert.assertTrue(accountsPage.getAccountSectionCount() ==  Constants.ACCOUNT_PAGE_SECTION_COUNT);
	}
	
	@Description("Verify Account Section List")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 6)
	public void verifyMyAccountSectionListTest() {
		Assert.assertEquals(accountsPage.getAccountSectionsList(), Constants.getAccountSectionList());
	}
	
	@Description("Search product")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 7)
	public void searchTest() {
		Assert.assertTrue(accountsPage.doSearch("iMac"));
	}
	
	@Description("Verify cart ammount in dollar")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 8)
	public void verifyAmountCurrency() {
		Assert.assertTrue(accountsPage.getAmountCurrencyType());
	}
	
}