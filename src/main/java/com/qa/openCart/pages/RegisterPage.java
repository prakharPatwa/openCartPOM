package com.qa.openCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.openCart.base.BasePage;
import com.qa.openCart.utils.Constants;
import com.qa.openCart.utils.ElementUtil;

public class RegisterPage extends BasePage{
	private ElementUtil elementUtil;
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By phone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("//input[@type='radio' and @name='newsletter' and @value='1']");
	private By subscribeNo = By.xpath("//input[@type='radio' and @name='newsletter' and @value='0']");
	private By agree = By.xpath("//input[@type='checkbox' and @name='agree']");
	private By registerBtn = By.xpath("//input[@type='submit' and @value='Continue']");
	private By successMessage = By.cssSelector("#content h1");
	private By logout = By.linkText("Logout");
	private By register = By.linkText("Register");
	
	private By loginLink = By.linkText("Login");
	
	
	//Constructor
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	//Actions
	public String getregisterTitle() {
		return elementUtil.waitForTitlePresent(Constants.REGISTER_ACCOUNT_PAGE_TITLE, 10);
	}
	
	public boolean accountRegistration(String firstName, String lastName, String email, String phone, String password, String subscribe) {
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.phone, phone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmPassword, password);
		
		if(subscribe.equals("yes")) {
			elementUtil.doClick(subscribeYes);
		}else {
			elementUtil.doClick(subscribeNo);
		}
		
		elementUtil.doClick(agree);
		elementUtil.doClick(registerBtn);
		
		String text = elementUtil.doGetText(successMessage);
		if(text.contains(Constants.ACCOUNT_SUCCESS_MESSAGE)) {
			elementUtil.doClick(logout);
			elementUtil.doClick(register);
			return true;
		}
		return false;
	}
	
	public void loginLink() {
		 elementUtil.doClick(loginLink);
	}
	
	public String loginPageVerifyTitle() {
		return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
}
