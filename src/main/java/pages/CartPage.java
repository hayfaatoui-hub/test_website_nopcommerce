package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{

	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="button.remove-btn")
	WebElement removeCheck;

	@FindBy(id="updatecart")
	WebElement upDateCartbBtn;

	@FindBy(css="input.qty-input")
	WebElement quantityTxt;

	@FindBy(css="td.product")
	public WebElement ProductNameLbl;

	@FindBy(css="td.subtotal")
	public WebElement totalLbl;

	@FindBy(css="div.no-data")
	public WebElement noDataLbl;

	@FindBy(id = "checkout")
	WebElement CheckoutBtn;
	
	@FindBy(id = "termsofservice")
	WebElement CheckAgreetBtn;
	
//	@FindBy(css="span.product-unit-price")
//	public WebElement productPrice;

	public void RemoveProductFromCart() {

		clickButton(removeCheck);
		//clickButton(upDateCartbBtn);
	}

	public void UpdateProductQuantityInCart(String quantity) {

		//clear quantityTxt
		clearTxt(quantityTxt);
		setTextElementText(quantityTxt, quantity);
		clickButton(upDateCartbBtn);
	}

	public void openCheckoutPage() {

		clickButton(CheckAgreetBtn);
		clickButton(CheckoutBtn);
	}

}
