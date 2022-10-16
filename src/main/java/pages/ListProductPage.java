package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListProductPage extends PageBase{

	public ListProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css ="strong.current-item")
	public WebElement productNamebreadCrumb;
	
	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	@FindBy(css="span.price-value-4")
	public WebElement productPriceLbl;
	
	@FindBy(linkText ="Add your review")
	public WebElement addReviewLink;
	
	@FindBy(id ="add-to-wishlist-button-4")
	WebElement wishListBtn;
	
	@FindBy(linkText = "Wishlist")
	WebElement wishListLink;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;
	
	@FindBy(linkText = "Compare products list")
	WebElement Compareproductslist;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement addToCart;
	
	
	public void openSendEmail() {
		clickButton(emailFriendBtn);
	}
	
	public void openAddPoductReview() {
		
		clickButton(addReviewLink);
	}
	
	public void AddProductToWishList() {
		
		clickButton(wishListBtn);
	}
	
	public void openWishList() {
		
		clickButton(wishListLink);
	}
	
	public void addProductToComparePage() {
		
		clickButton(addToCompareBtn);
	}
	
	
	public void openComparePage() {
		
		clickButton(Compareproductslist);
	}
	
	public void AddProductToShoppingCart() {
		
		clickButton(addToCart);
	}
}



