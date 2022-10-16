package tests;

import org.testng.Assert;
import org.testng.annotations.Test; 
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@Test (priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Hayy","Attttt","qlq1@gm.vb","123456");
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
		loginObject.UserLogin("qlq1@gm.vb", "123456");
		Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
		
	}

	
	

}
