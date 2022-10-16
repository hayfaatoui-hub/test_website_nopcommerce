package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ListProductPage;
import pages.SearchPage;

public class searchProductTest extends TestBase {
	
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ListProductPage ListProductObject;
	
	@Test
	public void userCanSearchProduct() {
		
		searchObject = new SearchPage(driver);
		searchObject.ProductSearch(productName);
		ListProductObject = new ListProductPage(driver);
		searchObject.openProductDetailPage();
		Assert.assertTrue(ListProductObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		//Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}

}
