package com.qa.openCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.openCart.base.BasePage;
import com.qa.openCart.utils.Constants;
import com.qa.openCart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{
	private ElementUtil elementUtil;
	
	//1. By Locators:
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By forgotLink = By.linkText("Forgotten Password");
	private By signupLink = By.linkText("Continue");
	private By registerLink = By.linkText("Continue");
	
	//2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	//3. Page Actions: page actions(Behavior) in the form of methods
	@Step("getting Login Page title")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
		
	}
	
	@Step("checking if SignUp link exist")
	public boolean isSignupLinkExist() {
		return elementUtil.doIsDisplayed(signupLink);
	}
	
	@Step("checking if Forgot Password link exist")
	public boolean isForgotLinkExist() {
		return elementUtil.doIsDisplayed(forgotLink);
	}
	
	@Step("Naviagting to Register page")
	public RegisterPage goToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}
	
	@Step("Login with username : {0} and password : {1}")
	public AccountsPage doLogin(String un, String pwd) {
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}
	
}











