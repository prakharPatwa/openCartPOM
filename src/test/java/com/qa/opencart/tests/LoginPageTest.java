package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.openCart.base.BaseTest;
import com.qa.openCart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic 100 : define login page features")
@Story("US 101 : define login page class with title, forgot pwd link and login functionality")
public class LoginPageTest extends BaseTest{
	
	@Description("Verify login page title")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Title is "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("Verify SignUp link")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2)
	public void verifySignupLinktest() {
		Assert.assertTrue(loginPage.isSignupLinkExist());
	}
	
	@Description("Verify Forgot Pwd link exist")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void verifyForgotLinkTest() {
		Assert.assertTrue(loginPage.isForgotLinkExist());
	}
	
	@Description("Verify login test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 4)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
}
