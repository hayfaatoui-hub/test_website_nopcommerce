package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class WishListPage extends PageBase {

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="h1")
	public WebElement wishlistHeader;
	
	@FindBy(css="td.product")
	public WebElement productCell;
	
	@FindBy(id = "updatecart")
	WebElement updateWishList;
	
	@FindBy(css = "button.remove-btn")
	WebElement removeFromCart;
	
	@FindBy(css = "div.no-data")
	public WebElement EmptyFromCart;
	
	public void removeProductFromWishList() {
		
		clickButton(removeFromCart);
		//clickButton(updateWishList);

	}

}
