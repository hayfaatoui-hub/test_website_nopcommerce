package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String oldPassword = "12345678";
	String newPassword = "123456";
	String firstName = "fisrt";
	String lastName = "lastnam";
	String email = "qlq3@gm.ma";
	
	
	
	@Test (priority = 1)
	public void UserCanRegisterSuccssfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(firstName, lastName, email,oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		
	}
	
	@Test(priority = 2)
	public void RegisteredUserCanChangePassword() {
		
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
		//driver.navigate().refresh();
	}
	
	@Test (priority = 3)
	public void IgnoreNotification() {
		myAccountObject.closeNotifBar();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test (priority = 4)
	public void RegisterUserCanLogout() {
		
		registerObject.userLogOut();
	}
	
	
	@Test(priority = 5)
	public void RegisterUserCanLogin() {
		
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, newPassword);
		Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
		
	}
	
	@Test (priority = 6)
	public void Logout() {
		
		registerObject.userLogOut();
	}
}
