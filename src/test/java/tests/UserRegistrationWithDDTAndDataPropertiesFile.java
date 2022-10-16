package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataPropertiesFile extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String fn = LoadProperties.userData.getProperty("firstname");
	String ln = LoadProperties.userData.getProperty("lastname");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");
	
	
	
	@Test (priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(fn,ln,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		
	}
	
	
	@Test (dependsOnMethods ={"UserCanRegisterSuccssfully"})
	public void RegisterUserCanLogout() {
		
		registerObject.userLogOut();
	}
	
	
	@Test(dependsOnMethods ={"RegisterUserCanLogout"})
	public void RegisterUserCanLogin() {
		
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
		
	}

	
	

}
