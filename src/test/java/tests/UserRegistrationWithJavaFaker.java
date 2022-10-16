package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithJavaFaker extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	Faker fakerData = new Faker();
	String firstname = fakerData.name().firstName();
	String lastname = fakerData.name().lastName();
	String email = fakerData.internet().emailAddress();
	String password = fakerData.number().digits(8);
	
	@Test (priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(firstname,lastname,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		
	}
	
	
	@Test (priority = 2, dependsOnMethods ={"UserCanRegisterSuccssfully"})
	public void RegisterUserCanLogout() {
		
		registerObject.userLogOut();
	}
	
	
	@Test(priority = 3, dependsOnMethods ={"RegisterUserCanLogout"})
	public void RegisterUserCanLogin() {
		
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email,password);
		Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
		
	}

	@Test(priority = 4)
	public void Logout() {
		
		registerObject.userLogOut();
	}
	

}
