package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ListProductPage;
import pages.SearchPage;

public class SearchProductUsingAutomSuggest extends TestBase{
	
	SearchPage searchObject;
	ListProductPage ListProductObject;
	String productName ="Apple MacBook Pro 13-inch";
	
	@Test
	public void UserCanSearchWithAutoSuggest() {
		
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSugges("MacB");
		ListProductObject = new ListProductPage(driver);
		Assert.assertEquals(ListProductObject.productNamebreadCrumb.getText(), productName);
	}

}
