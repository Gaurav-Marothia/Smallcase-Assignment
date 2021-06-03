package com.auto.pages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.auto.utilities.BrowserFactory;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	public WebDriver driver;
		
	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver, "Chrome", "https://www.flipkart.com/");
	}
	
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
}
