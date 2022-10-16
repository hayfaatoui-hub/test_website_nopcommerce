package pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	
	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactBtn;
	
	@FindBy(id = "customerCurrency")
	WebElement currencydrl;
	
	@FindBy(linkText = "Computers")
	WebElement ComputerMenu;
	
	@FindBy(linkText = "Notebooks")
	WebElement NotebooksMenu;
	
	public void openRegistrationPage() {
		
		//Thread.sleep(0);
		clickButton(registerLink);
	}
	
	public void openLoginPage() {
		
		clickButton(LoginLink);
		
	}
	
	public void openContactUsPage() {
		
		scrollBottom();
		clickButton(contactBtn);
	}
	
	public void changeCurrency() {
		
		select = new Select(currencydrl);
		select.selectByVisibleText("Euro");
	}
	
	public void selectComputerMenu() {
		
		//System.out.println(ComputerMenu.getText());
		action.moveToElement(ComputerMenu).
		click().
		build().
		perform();
		
	}
	
	public void selectNotebooksMenu() {
		
		action.
		moveToElement(NotebooksMenu).
		click().
		build().
		perform();
		
	}

	
}
