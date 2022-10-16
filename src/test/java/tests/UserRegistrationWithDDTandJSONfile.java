package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDatareader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandJSONfile extends TestBase {
	
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@Test (priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws FileNotFoundException, IOException, ParseException {
		
		JsonDatareader jsonReader = new JsonDatareader();
		jsonReader.JsonReader();
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration
		(jsonReader.firstname,jsonReader.lastname,
				jsonReader.email,jsonReader.password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogOut();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(jsonReader.email,jsonReader.password);
		Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
		registerObject.userLogOut();
	}
}
