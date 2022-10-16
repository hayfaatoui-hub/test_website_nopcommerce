package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ListProductPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
	
	HomePage homeObject;
	ListProductPage productObject;
	
	SearchPage searchObject;
	String productName ="Apple MacBook Pro 13-inch";
	
	
	@Test(priority =1) 
	public void UserCanChangeCurrency() {
		
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
	}
	
	
	@Test(priority = 2)
	public void UserCanSearchWithAutoSuggest() {
		
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSugges("MacB");
		productObject = new ListProductPage(driver);
		Assert.assertEquals(productObject.productNamebreadCrumb.getText(), productName);
		Assert.assertTrue(productObject.productPriceLbl.getText().contains("€"));
	}

}
