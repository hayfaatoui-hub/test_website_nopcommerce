package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class orderDetailsPage extends PageBase{

	public orderDetailsPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(css = "a.button-2.print-order-button")
	WebElement printOrderBtn;

	@FindBy(css = "a.button-2.pdf-invoice-button")
	WebElement orderInPDFLink;
	
	public void PrintOrderDetail() throws InterruptedException {
		clickButton(printOrderBtn);
		Thread.sleep(5000);
	}
	
public void DownloadPDFInvoice() throws InterruptedException {
		clickButton(orderInPDFLink);
		Thread.sleep(5000);
	}

}
