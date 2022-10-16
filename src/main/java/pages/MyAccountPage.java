package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{
	
		public MyAccountPage(WebDriver driver) {
		super(driver);
	}
		
		@FindBy(linkText = "Change password")
		WebElement changePasswordLink;
		
		@FindBy(id = "OldPassword")
		WebElement oldPasswordTxt;
		
		@FindBy(id = "NewPassword")
		WebElement newPasswordTxt;
		
		@FindBy(id = "ConfirmNewPassword")
		WebElement confirmPasswordTxt;
		
		@FindBy(css = "button.button-1.change-password-button")
		WebElement ChangePasswordBtn;
		
		@FindBy(css = "p.content")
		public WebElement resultLbl;
		
		@FindBy(linkText = "My account")
		WebElement myAccountBtn;
		
		@FindBy(css = "span.close")
		public WebElement crossBarNotification;
		
		
		
		public void openChangePasswordPage() {
			clickButton(changePasswordLink);
			
		}
		
		public void closeNotifBar() {
			clickButton(crossBarNotification);
			
		}
		
		public void openMyAccountPage() {
			clickButton(myAccountBtn);
			
		}
		
		
		public void ChangePassword(String oldpassword, String newPassword) {
			
			setTextElementText(oldPasswordTxt, oldpassword);
			setTextElementText(newPasswordTxt, newPassword);
			setTextElementText(confirmPasswordTxt, newPassword);
			//confirmPasswordTxt.sendKeys(newPassword);
			clickButton(ChangePasswordBtn);			
		}

}
