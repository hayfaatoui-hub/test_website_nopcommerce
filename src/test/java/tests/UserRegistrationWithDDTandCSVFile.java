package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandCSVFile extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	CSVReader reader;
	
	@Test (priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws CsvValidationException, IOException {
		
		//get path of CSV file
		String CSV_file = System.getProperty
			("user.dir")+"\\src\\test\\java\\data\\userData.csv";
		reader = new CSVReader(new FileReader(CSV_file));
		
		String[] csvCell;
		//while loop will be excuted till the last value in csv file
		while ((csvCell = reader.readNext())!=null) {
			String firstname = csvCell[0];
			String lastname = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];

			homeObject = new HomePage(driver);
			homeObject.openRegistrationPage();
			registerObject = new UserRegistrationPage(driver);
			registerObject.userRegistration(firstname,lastname,email,password);
			Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
			registerObject.userLogOut();
			homeObject.openLoginPage();
			loginObject = new LoginPage(driver);
			loginObject.UserLogin(email, password);
			Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
			registerObject.userLogOut();
		}
		
		
	}
}
