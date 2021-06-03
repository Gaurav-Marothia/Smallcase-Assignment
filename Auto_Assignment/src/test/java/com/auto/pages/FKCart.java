package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FKCart {

	WebDriver driver;
	
	public FKCart(WebDriver ldriver)
	{
		this.driver=ldriver;				
	}
	
	@FindBy(xpath="(//button[@class='_23FHuj'])[2]") WebElement radioBtn;
	
	@FindBy(xpath="//*[@class='Ob17DV _3X7Jj1']") WebElement totalAmount;
	
	public void increaseQty()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		radioBtn.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Total Amount: "+ totalAmount.getText().toString());
	}
}
