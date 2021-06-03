package com.auto.pages;

import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonLandingPage {
	
	WebDriver driver;
	
	public AmazonLandingPage(WebDriver ldriver)
	{
		this.driver=ldriver;	
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.open()");

		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		driver.get("https://www.amazon.in/");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}		
	}
	
	@FindBy(id="twotabsearchtextbox") WebElement searchBar;
	
	@FindBy(id="nav-search-submit-button") WebElement searchbarBtn;
	
	@FindBy(xpath="//span[normalize-space()='Vu 108 cm (43 inches) 4K Ultra HD Cinema Android Smart LED TV 43CA (Black) | With 40W Front Soundbar']") WebElement item;
	
	public void findProduct(String prodName)
	{
		searchBar.sendKeys(prodName);
		searchbarBtn.click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'})", item);
		item.click();
		
		ArrayList <String> tabs = new ArrayList <>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(3));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}
	
}
