package com.auto.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.auto.pages.BaseClass;
import com.auto.pages.FKCart;
import com.auto.pages.FKProductDetailsPage;
import com.auto.pages.FlipkartLandingPage;

public class TC_001_AddProduct extends BaseClass{
	
	@Test
	public void addToCart()  
	{		
		FlipkartLandingPage flipkartlandingpage=PageFactory.initElements(driver, FlipkartLandingPage.class);
		flipkartlandingpage.searchProduct("iphone 12 mini");
		flipkartlandingpage.switchToNewTab();
		
		FKProductDetailsPage fkproductdetailspage=PageFactory.initElements(driver, FKProductDetailsPage.class);
		fkproductdetailspage.addToCart();
		
		FKCart fkcart=PageFactory.initElements(driver, FKCart.class);
		fkcart.increaseQty();
	}
	
}
