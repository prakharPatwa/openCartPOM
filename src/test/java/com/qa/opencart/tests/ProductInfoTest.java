package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.openCart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 103 : define Product Information features")
@Story("US 103 : define Product Information page class with title and product results functionality")
public class ProductInfoTest extends BaseTest{
	@BeforeClass
	public void productInfoSetUp() {
		accountsPage =  loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Description("Verify Account Page title")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void verifyProfuctInfoTestAppleMacbook() {
		String productName = "Macbook";
		String actualProduct = "MacBook Pro";
		Assert.assertTrue(accountsPage.doSearch(productName));
		productInfoPage = accountsPage.selectProductFromResults(actualProduct);
		Assert.assertTrue(productInfoPage.getProductImages()>=1);
		Map<String, String> productInfoMap =  productInfoPage.getProductInformation();
		//Brand=Apple, 
		//Availability=Out Of Stock, 
		//price=$2,000.00, 
		//name=MacBook Pro, 
		//Product Code=Product 18, 
		//Reward Points=800, 
		//exTaxPrice=$2,000.00
		
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("name"), actualProduct);
		Assert.assertEquals(productInfoMap.get("price"), "$2,000.00");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
	}
}
