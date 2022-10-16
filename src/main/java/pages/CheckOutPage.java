package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(css = "button.button-1.checkout-as-guest-button")
	WebElement checkoutAsGuestBtn;
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement fnTxt;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lnTxt;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailfnTxt;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;

	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxt;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement adress1Txt;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postalCodeTxt;

	@FindBy(css = "button.button-1.new-address-next-step-button")
	WebElement continueBtn;

	@FindBy(id = "shippingoption_0")
	WebElement shippingMethodeRBtn;

	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement continueShippingBtn;

	//	@FindBy(id = "paymentmethod_0")
	//	WebElement paymentMethodRBtn;
	
	//button-1 confirm-order-next-step-button

	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement paymentMethodBtn;

	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement paymentInformationBtn;

	@FindBy(css = "a.product-name")
	public WebElement productNameLbl;

	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmOrderBtn;

	@FindBy(css = "h1")
	public WebElement ThankYouLbl;

	@FindBy(css = "div.title")
	public WebElement successMessage;

	//@FindBy(css = "button.button-1.order-completed-continue-button")
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement completeOrderBtn;

	@FindBy(linkText = "Click here for order details.")
	WebElement DetailsLink;


	public void RegisterUserAndCheckoutProduct(String countryName,
			String adress,	String codePostal, String phone,
			String city, String productname) throws Exception {
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxt, city);
		setTextElementText(adress1Txt, adress);
		setTextElementText(postalCodeTxt, codePostal);
		setTextElementText(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodeRBtn);
		Thread.sleep(2000);
		clickButton(continueShippingBtn);
		Thread.sleep(2000);
		clickButton(paymentMethodBtn);
		clickButton(paymentInformationBtn);
		Thread.sleep(2000);
		clickButton(completeOrderBtn);
		//Assert.assertTrue(productNameLbl.isDisplayed());
		//Assert.assertTrue(ThankYouLbl.isDisplayed());
		// Assert.assertTrue(successMessageLbl.isDisplayed());

	}
	
	public void checkoutAsGuest() {
		clickButton(checkoutAsGuestBtn);

	}

	public void GuesterUserCanCheckoutProduct(String firstname, 
			String lastname, String email, String country, String adress,
			String postcode, String phone, String city, 
			String productname) throws Exception {
		setTextElementText(fnTxt, firstname);
		setTextElementText(lnTxt, lastname);
		setTextElementText(emailfnTxt, email);
		select = new Select(countryList);
		select.selectByVisibleText(country);
		setTextElementText(cityTxt, city);
		setTextElementText(adress1Txt, adress);
		setTextElementText(postalCodeTxt, postcode);
		setTextElementText(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodeRBtn);
		Thread.sleep(2000);
		clickButton(continueShippingBtn);
		Thread.sleep(2000);
		clickButton(paymentMethodBtn);
		clickButton(paymentInformationBtn);
		Thread.sleep(2000);
		clickButton(completeOrderBtn);
	}

	public void confirmOrder() {
		clickButton(confirmOrderBtn);

	}
	
	public void viewOrderDetails() {
		clickButton(DetailsLink);

	}
	
	

}
