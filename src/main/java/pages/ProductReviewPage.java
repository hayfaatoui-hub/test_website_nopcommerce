package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTiteleTxt;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewText;
	
	@FindBy(id="addproductrating_3")
	WebElement rating4RdBtn;
	
	@FindBy(css="button.button-1.write-product-review-button")
	WebElement submitReviewBtn;
	
	@FindBy(css="div.result")
	public WebElement reviewNotification;
	
	public void AddProductReview(String reviewTitle, String reviewMessage) {
		
		setTextElementText(reviewTiteleTxt, reviewTitle);
		setTextElementText(reviewText, reviewMessage);
		clickButton(rating4RdBtn);
		clickButton(submitReviewBtn);
		
	}

}
