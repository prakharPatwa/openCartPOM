package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.openCart.base.BaseTest;
import com.qa.openCart.utils.Constants;
import com.qa.openCart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest{
	@BeforeClass
	public void registerPageSetup() {
		register = loginPage.goToRegisterPage();
	}
	
	@Test(priority = 1)
	public void verifyRegistrationTitleTest() {
		System.out.println("Registration title is - "+register.getregisterTitle());
		Assert.assertEquals(register.getregisterTitle(), Constants.REGISTER_ACCOUNT_PAGE_TITLE);
	}
	@DataProvider
	public Object[][] getRegistrationData() {
		Object[][] data = ExcelUtil.getTestData("registration");
		return data;
	}
	
	@Test(dataProvider = "getRegistrationData",priority = 2)
	public void userRegistrationPage(String firstname, String lastname, String email, String telephone, String password, String subscribe) {
		boolean flag = register.accountRegistration(firstname, lastname, email, telephone, password, subscribe);
		Assert.assertTrue(flag);
	}
	
//	@Test(priority = 3)
//	public void verifyOnLoginPage() {
//		register.loginLink();
//		System.out.println("Login Page title is "+loginPage.getLoginPageTitle());
//		Assert.assertEquals(loginPage.getLoginPageTitle(), Constants.LOGIN_PAGE_TITLE);
//	}
}
