package com.pomwithpagefactoryusingparametersnew.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightPage {
	
	@FindBy(xpath="//a[text()='Flights']")
	WebElement elemFlight;
	
	public WebDriver driver;
	
	public FlightPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void flightDetails() {
		
		elemFlight.click();	
		
	}
	
	public void explicitWaitFlight()
	{
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//font[text()='Preferences']")));
	}
	
	

}
