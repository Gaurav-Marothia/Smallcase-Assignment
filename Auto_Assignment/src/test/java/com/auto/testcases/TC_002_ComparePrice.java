package com.auto.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.auto.pages.BaseClass;
import com.auto.pages.FKProductDetailsPage;
import com.auto.pages.FlipkartLandingPage;
import com.auto.pages.AZProductDetailsPage;
import com.auto.pages.AmazonLandingPage;

public class TC_002_ComparePrice extends BaseClass{

	@Test
	public void comparePrices() 
	{
		FlipkartLandingPage flipkartlandingpage=PageFactory.initElements(driver, FlipkartLandingPage.class);
		flipkartlandingpage.searchProduct("vu tv 43CA");
		flipkartlandingpage.switchToNewTab();
		
		FKProductDetailsPage fkproductdetailspage=PageFactory.initElements(driver, FKProductDetailsPage.class);
		Integer fkup = fkproductdetailspage.unitPrice();
		fkproductdetailspage.addToCart();
//		FKProductDetailsPage.main();

		AmazonLandingPage amazonlandingpage=PageFactory.initElements(driver, AmazonLandingPage.class);
		amazonlandingpage.findProduct("vu tv 43CA");
		
		AZProductDetailsPage azproductdetailspage=PageFactory.initElements(driver, AZProductDetailsPage.class);
		Integer azup = azproductdetailspage.unitPrice();
		azproductdetailspage.addToCart();

		
		if (fkup < azup) {
			System.out.println("Flipkart is cheaper");	
		}
		else {
			System.out.println("Amazon is cheaper");
		}
		
	}
}
