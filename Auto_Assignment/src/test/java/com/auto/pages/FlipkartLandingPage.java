package com.auto.pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FlipkartLandingPage {
	
	WebDriver driver;
	
	public FlipkartLandingPage(WebDriver ldriver)
	{
		this.driver=ldriver;				
	}
	
	@FindBy(name="q") WebElement search;
	
	@FindBy(xpath="//button[@type='submit']") WebElement searchbtn;
	
	@FindBy(css="alt='iPhone 12 Mini'") WebElement img;
	
	@FindBy(xpath="(//*[@class='_4rR01T'])[1]") WebElement product;
	
	
	public void searchProduct(String productName)
	{	
		Actions actions = new Actions(driver);
		
		Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();
		sendEsc.perform();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		search.sendKeys(productName);
		
		searchbtn.click();
		
		System.out.println(product.getText().toString());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		
		product.click();
	}
	
	public void switchToNewTab()
	{
		ArrayList <String> tabs = new ArrayList <>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		
	}
}
