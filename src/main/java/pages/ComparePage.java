package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase {

	public ComparePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.clear-list")
	WebElement clearListLink;

	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;
	
	@FindBy(tagName  = "tr")
	public List<WebElement> allRows;
	
	@FindBy(tagName = "td")
	List<WebElement> allCol;
	
	@FindBy(css = "div.no-data")
	public WebElement noDataLbl;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement firstProduct;
	
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement secondproduct;
	
	public void clearCompareList() {
		
		clickButton(clearListLink);
	}
	
	public void CompareProduct() {
		
		// get all Rows
		//System.out.println(allRows.size());
		
		//get data  from each Row
		for (WebElement row : allRows) {
			System.out.println(row.getText() + "\t");
			
			for(WebElement col:allCol){
				System.out.println(col.getText() + "\t");
				
			}
			
		}
	}

}
