package com.pomwithpagefactoryusingparametersnew.Scripts;

import org.testng.annotations.Test;

import com.pomwithpagefactoryusingparametersnew.Pages.FlightPage;

public class FlightTest extends LoginTest {
  @Test(priority=4)
  public void flight() {
	  
	  FlightPage obj=new FlightPage(driver);
	  obj.flightDetails();
	  obj.explicitWaitFlight();
	  
  }
}
