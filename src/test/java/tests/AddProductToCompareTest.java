package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.ListProductPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase {
	
	String firsProductName = "Mac";
	String secondProductName = "Asu";
	
	ListProductPage productObject;
	ComparePage compareObject;
	SearchPage searchObject;
	
	
	// 1- search for product number1
	
	//3- add to compare page
	
	@Test(priority = 1)
	public void userCanCompareProducts() {
		searchObject = new SearchPage(driver);
		productObject = new ListProductPage(driver);
		compareObject = new ComparePage(driver);
		
		
		searchObject.ProductSearchUsingAutoSugges(firsProductName);
		Assert.assertTrue(productObject.productNamebreadCrumb.getText().contains(firsProductName));
		productObject.addProductToComparePage();
		//productObject.openComparePage();
		
		
		searchObject.ProductSearchUsingAutoSugges(secondProductName);
		Assert.assertTrue(productObject.productNamebreadCrumb.getText().contains(secondProductName));
		productObject.addProductToComparePage();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.navigate().to("http://demo.nopcommerce.com/compareproducts");
		productObject.openComparePage();
		Assert.assertTrue(compareObject.firstProduct.isDisplayed());
		Assert.assertTrue(compareObject.secondproduct.isDisplayed());
				
		//productObject.openComparePage();
		//driver.navigate().refresh();
		//productObject.openComparePage();
		compareObject.CompareProduct();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	//4- clear list 
	
	@Test(priority = 3)
	public void userCanClearCompareList() {
		
		compareObject = new ComparePage(driver);
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("no items to compare"));
	}

}
