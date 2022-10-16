package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ListProductPage;
import pages.LoginPage;
import pages.SearchPage;
import pages.UserRegistrationPage;
import pages.orderDetailsPage;

public class RegisteredUserCheckOutProductTest extends TestBase{
	
	
	
	/*
	 * 
	 * 1- register user
	 * 2- search for product
	 * 3- add to cart
	 * 4- checkout
	 * 5- logout
	 * 
	 */
	String productName ="Apple MacBook Pro 13-inch";
	HomePage homeObject;
	UserRegistrationPage registrationObject;
	LoginPage logingObject;
	SearchPage searchObject;
	ListProductPage productObject;
	CartPage cartObject;
	CheckOutPage checkoutObject;
	orderDetailsPage orderObject;
	
	@Test(priority = 1)
	public void UserCanRegister() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registrationObject = new UserRegistrationPage(driver);
		registrationObject.userRegistration("qlq","qlq", "qlq2@qlq.qlq", "1233455");
		Assert.assertTrue(registrationObject.successMessage.getText().contains("registration completed"));
		
	}
	
	@Test(priority = 2)
	public void UserCanSearchForProductUsingAutosuggest() {
		try {
		searchObject = new SearchPage(driver);
		productObject = new ListProductPage(driver);
		searchObject.ProductSearchUsingAutoSugges(productName);
		Assert.assertEquals(productObject.productNamebreadCrumb.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred"+e.getMessage());
		}
		
	}
	
	
	@Test(priority = 3)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		productObject = new ListProductPage(driver);
		productObject.AddProductToShoppingCart();
		Thread.sleep(2000);
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
		cartObject = new CartPage(driver);
		Assert.assertTrue(cartObject.totalLbl.getText().contains("3,600"));
	}
	
	
	@Test(priority = 4 )
	public void UserCanCheckoutProduct() throws Exception {
		checkoutObject = new CheckOutPage(driver);
		cartObject = new CartPage(driver);
		cartObject.openCheckoutPage();
		checkoutObject.RegisterUserAndCheckoutProduct("France",
				"qlq", "qlq", "qqq", "qqq", "qqq");
		Assert.assertTrue(checkoutObject.productNameLbl.isDisplayed());
		Assert.assertTrue(checkoutObject.productNameLbl.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYouLbl.isDisplayed());
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new orderDetailsPage(driver);
		orderObject.DownloadPDFInvoice();
		orderObject.PrintOrderDetail();
		
	}
	
	@Test(priority = 5)
	public void RegisteredUserCanLogout() {
		registrationObject.userLogOut();
	}

}
