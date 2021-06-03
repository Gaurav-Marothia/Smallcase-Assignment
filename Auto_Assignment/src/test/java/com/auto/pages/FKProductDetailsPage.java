package com.auto.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FKProductDetailsPage {
	
	WebDriver driver;
	
	public FKProductDetailsPage(WebDriver ldriver)
	{
		this.driver=ldriver;				
	}

	@FindBy(css="button[class='_2KpZ6l _2U9uOA _3v1-ww']") WebElement addToCartBtn;
	
	@FindBy(xpath="//div[@class='_30jeq3 _16Jk6d']") WebElement up1;

	public void addToCart()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		
//		Actions actions = new Actions(driver);
//		Action mouseclick = actions.moveByOffset(122, 534).click().build();
//		mouseclick.perform();
//		actions.moveToElement((addToCartBtn), 0, 0);
//		actions.moveByOffset(122, 534).click().build().perform();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'})", addToCartBtn);

		addToCartBtn.click();
	}
	
	public Integer unitPrice()
	{
		String unitprice  = up1.getText().toString();
		String tempunitprice = "";
		unitprice = unitprice.substring(1, unitprice.length());
		
		if (unitprice.indexOf(",") > 0) {
			String [] unitpricearray = unitprice.split(",");	
			for (String val:unitpricearray) {
				tempunitprice = tempunitprice+val; 
			}
		}
		return Integer.parseInt(tempunitprice);
		
	}
}
