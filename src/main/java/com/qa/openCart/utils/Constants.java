package com.qa.openCart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_HEADER_VALUE = "Your Store";
	public static final String ACCOUNT_PAGE_CART_VALUE = "0 item(s) - $0.00";
	public static final String REGISTER_ACCOUNT_PAGE_TITLE ="Register Account";
	public static final int ACCOUNT_PAGE_SECTION_COUNT = 4;
	public static final String ACCOUNT_SUCCESS_MESSAGE = "Your Account Has Been Created";
	
	public static List<String> getAccountSectionList() {
		List<String> accountList = new ArrayList<String>();
		accountList.add("My Account");
		accountList.add("My Orders");
		accountList.add("My Affiliate Account");
		accountList.add("Newsletter");
		
		return accountList;
	}
}
