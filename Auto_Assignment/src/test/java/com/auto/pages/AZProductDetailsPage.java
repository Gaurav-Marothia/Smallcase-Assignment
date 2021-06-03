package com.auto.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AZProductDetailsPage {
	
	WebDriver driver;
	
	public AZProductDetailsPage(WebDriver ldriver)
	{
		this.driver=ldriver;				
	}

	@FindBy(id="add-to-cart-button") WebElement addToCartBtn;
	
	@FindBy(xpath="(//span[@class='a-color-price hlb-price a-inline-block a-text-bold'])[1]") WebElement cartFinal;
	
	@FindBy(css="#priceblock_ourprice") WebElement up;

	public void addToCart()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'})", addToCartBtn);

		addToCartBtn.click();
	}
	
	public Integer unitPrice()
	{
		String unitprice  = up.getText().toString();
		String tempunitprice = "";
		unitprice = unitprice.substring(1, unitprice.length()).trim();
		if (unitprice.indexOf(",") > 0) {
			String [] unitpricearray = unitprice.split(",");	
			for (String val:unitpricearray) {
				tempunitprice = tempunitprice+val; 
			}
		}
		Double d = Double.parseDouble(tempunitprice);
        Integer i = d.intValue();
		
//		System.out.println("finalprice ::" +i);
		return i;
		
	}
}

