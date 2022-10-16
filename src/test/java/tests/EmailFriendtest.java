package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.ListProductPage;
import pages.LoginPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendtest extends TestBase{
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ListProductPage ListProductObject;
	EmailPage EmailObject;
	String productName ="Apple MacBook Pro 13-inch";
	
	
	
	//1-User Registration
	@Test (priority = 1)
	public void UserCanRegisterSuccssfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Hayy","Attttt","qlq4@gm.vb","123456");
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

	
	
	//3- Email to Friend
	
	@Test(priority = 3)
	public void RegisteredUserCanSendProductToFriend() {
		
		ListProductObject = new ListProductPage(driver);
		ListProductObject.openSendEmail();
		EmailObject = new EmailPage(driver);
		EmailObject.SendEmailToFriend("qlq00@qlq.qlq", "hallo hallo");
		Assert.assertTrue(EmailObject.messegeNotification.getText().contains("Your message"));
	}
	
	
	
	
	
	//4- User Log Out
	
	@Test (priority = 4)
	public void RegisterUserCanLogout() {
		
		registerObject.userLogOut();
	}	

}
