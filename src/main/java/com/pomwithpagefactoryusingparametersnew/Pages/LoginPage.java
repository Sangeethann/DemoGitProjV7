package com.pomwithpagefactoryusingparametersnew.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	String loginTitle;
	String homeTitle;

	@FindBy(xpath="//input[@name='userName']")
	WebElement uname;

	@FindBy(name="password")
	WebElement pass;

	@FindBy(name="submit")
	WebElement submitBtn;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void loginDetails(String username, String password) {

		uname.sendKeys(username);
		pass.sendKeys(password);
		submitBtn.click();

	}

	public String getLoginPageTitle()
	{
		loginTitle=driver.getTitle();
		return loginTitle;
	}
	
	public String getHomePageTitle()
	{
		homeTitle=driver.getTitle();
		return homeTitle;
	}
	
	

}
