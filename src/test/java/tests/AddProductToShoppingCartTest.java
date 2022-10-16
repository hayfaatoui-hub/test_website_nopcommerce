package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.ListProductPage;
import pages.SearchPage;

public class AddProductToShoppingCartTest extends TestBase{

	String firsProductName = "Mac";
	ListProductPage productObject;
	SearchPage searchObject;
	CartPage CartObject;



	// 1- search for product numbers	
	@Test(priority = 1)
	public void userCansearchFroProduct() {	
		searchObject = new SearchPage(driver);
		productObject = new ListProductPage(driver);	
		searchObject.ProductSearchUsingAutoSugges(firsProductName);
		Assert.assertTrue(productObject.productNamebreadCrumb.getText().contains(firsProductName));

	}


	// 2- User Can Add a Product To ShoppingCart	
	@Test(priority = 2)
	public void AddProductToShoppingCart(){		
		productObject = new ListProductPage(driver);
		CartObject = new  CartPage(driver); 
		productObject.AddProductToShoppingCart();
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
		Assert.assertTrue(CartObject.ProductNameLbl.getText().contains(firsProductName));
	}
	
	
	// - User Can update quantity of Product in ShoppingCart	
		@Test(priority = 3)
		public void updateQuantityProductInShoppingCart() throws InterruptedException{		
			CartObject = new  CartPage(driver); 
			CartObject.UpdateProductQuantityInCart("4");
			Thread.sleep(10000);
			Assert.assertTrue(CartObject.totalLbl.getText().contains("7,200"));
		}

	// 4- User Can remove a Product From ShoppingCart	
	@Test(priority = 4)
	public void removeProductToShoppingCart() throws InterruptedException {	
		CartObject = new  CartPage(driver); 		
		CartObject.RemoveProductFromCart();
		Thread.sleep(5000);
		//Assert.assertTrue(CartObject.noDataLbl.getText().contains("is empty"));
	}
}
