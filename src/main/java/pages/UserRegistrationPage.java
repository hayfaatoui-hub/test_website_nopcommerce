package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-male")
	WebElement genderRdoBtn;
	
	@FindBy(id = "FirstName")
	WebElement fnTxtBox;
	
	@FindBy(id = "LastName")
	WebElement lnTxtBox;
	
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	
	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmpasswordTxtBox;
	
	@FindBy(id = "register-button")
	WebElement registerBtn;
	
	@FindBy(css="div.result")
	public WebElement successMessage;
	
	@FindBy(linkText = "Log out")
	public WebElement LogoutLink;
	
	@FindBy(linkText = "My Account")
	public WebElement myAccountLink;

	public void userRegistration(
	String FirstName , String LastName , String Email, String Password) {
		
		clickButton(genderRdoBtn);
		setTextElementText(fnTxtBox, FirstName);
		setTextElementText(lnTxtBox,LastName);
		setTextElementText(emailTxtBox,Email);
		setTextElementText(passwordTxtBox,Password);
		confirmpasswordTxtBox.sendKeys(Password);
		clickButton(registerBtn);
		clickButton(successMessage);

	}
	
	public void userLogOut() {
				
		clickButton(LogoutLink);

			}
	
	public void openMyAccountPage() {
		clickButton(myAccountLink);
		
	}
}
