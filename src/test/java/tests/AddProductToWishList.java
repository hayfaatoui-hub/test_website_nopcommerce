package tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ListProductPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishList extends TestBase {
	
	SearchPage searchObject;
	ListProductPage ProductListObject;
	WishListPage wishListObject;
	String prductName ="Apple";
	
	@Test(priority = 1)
	public void UserCanSearchForProductWithAutoSuggest() {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSugges("macB");
		ProductListObject = new ListProductPage(driver);
		Assert.assertTrue(ProductListObject.productNamebreadCrumb.getText().contains(prductName));
	}
	
	@Test(priority = 2)
	public void UserCanAddProductToWishList() {
		ProductListObject.AddProductToWishList();
		ProductListObject.openWishList();
		//driver.navigate().to("http://demo.nopcommerce.com"+"/wishlist");
		wishListObject = new WishListPage(driver);
		Assert.assertTrue(wishListObject.wishlistHeader.isDisplayed());
		Assert.assertTrue(wishListObject.productCell.getText().contains(prductName));
	}
	@Test(priority = 3)
	public void UserCanRemoveProductFromWishList() {
		
		wishListObject = new WishListPage(driver);
		wishListObject.removeProductFromWishList();
		Assert.assertTrue(wishListObject.EmptyFromCart.getText().contains("empty"));
	}
	
}
