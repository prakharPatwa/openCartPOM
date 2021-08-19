package com.qa.openCart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.openCart.base.BasePage;
import com.qa.openCart.utils.ElementUtil;

import io.qameta.allure.Step;

public class ProductInfoPage extends BasePage{
	private WebDriver driver;
	private ElementUtil elementUtil;
	private By productNameHeader = By.xpath("//div[@id='content']//div//h1");
	private By productMetaData = By.xpath("//div[@id='content']//div[@class='col-sm-4']//ul[1]//li");
	private By productPrice = By.xpath("//div[@id='content']//div[@class='col-sm-4']//ul[2]//li");
	private By quantity = By.id("input-quantity");
	private By addTocartButton = By.id("button-cart");
	private By productImages = By.cssSelector(".thumbnails li a img");
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	@Step("Getting the product information")
	public Map<String, String> getProductInformation() {
		Map<String, String> productInfoMap = new HashMap<String, String>();
		
		productInfoMap.put("name", elementUtil.doGetText(productNameHeader).trim());
		
		List<WebElement> productmetaDataList = elementUtil.getElements(productMetaData);
		for(WebElement e:productmetaDataList) {
			productInfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
		}
		
		List<WebElement> productpriceList = elementUtil.getElements(productPrice);
		productInfoMap.put("price", productpriceList.get(0).getText().trim());
		productInfoMap.put("exTaxPrice", productpriceList.get(1).getText().split(":")[1].trim());
		
		return productInfoMap;
	}
	
	@Step("Selecting the product quantity")
	public void selectQuantity(String quantity) {
		elementUtil.doSendKeys(this.quantity, quantity);
	}
	
	@Step("Adding product to the cart")
	public void addToCart() {
		elementUtil.doClick(addTocartButton);
	}
	
	@Step("Getting the product images")
	public int getProductImages() {
		int imgsize = elementUtil.getElements(productImages).size();
		return imgsize;
	}
	
}
















