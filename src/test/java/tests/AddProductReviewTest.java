package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.ListProductPage;
import pages.LoginPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ListProductPage ListProductObject;
	EmailPage EmailObject;
	ProductReviewPage reviewObject;
	String productName ="Apple MacBook Pro 13-inch";
	
	
	
	//1-User Registration
	@Test (priority = 1)
	public void UserCanRegisterSuccssfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Hayy","Attttt","log@gm.vb","123456");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		
	}
	
	
	//2- Search For Product
	@Test(priority = 2)
	public void UserCanSearchWithAutoSuggest() {
		
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSugges("MacB");
		ListProductObject = new ListProductPage(driver);
		Assert.assertEquals(ListProductObject.productNamebreadCrumb.getText(), productName);
	}

		
	//3-add review
	@Test(priority = 3)
	public void openReviewProduct() {
		
		ListProductObject.openAddPoductReview();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.AddProductReview("title of review", "message message review");
		Assert.assertTrue(reviewObject.reviewNotification.getText().contains("successfully added"));
		
	}
	
	
	//4- User Log Out
	
		@Test (priority = 4)
		public void RegisterUserCanLogout() {
			
			registerObject.userLogOut();
			
		}	


}
