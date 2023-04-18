package com.pomwithpagefactoryusingparametersnew.Scripts;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pomwithpagefactoryusingparametersnew.Constants.Constants;
import com.pomwithpagefactoryusingparametersnew.Pages.LoginPage;

public class TestClass extends TestBase {

	LoginPage obj;

	@Parameters({"validusername","invalidpassword"})
	@Test(priority=0)
	public void verifyLoginwithValidUsernameandInvalidPassword(String username,String password) {

		obj=new LoginPage(driver);
		obj.loginDetails(username,password);
		Assert.assertNotEquals(obj.getLoginPageTitle(), Constants.LOGINTITLE);


	}
	@Parameters({"invalidusername","validpassword"})
	@Test(priority=1)
	public void verifyLoginwithInvalidUsernameandValidPassword(String username,String password) {

		obj=new LoginPage(driver);
		obj.loginDetails(username,password);
		Assert.assertEquals(obj.getHomePageTitle(), Constants.HOMETITLE);


	}

	@Parameters({"invalidusername","invalidpassword"})
	@Test(priority=2)
	public void verifyLoginwithInvalidUsernameandInvalidPassword(String username,String password) {

		obj=new LoginPage(driver);
		obj.loginDetails(username,password);
		Assert.assertNotEquals(obj.getLoginPageTitle(), Constants.LOGINTITLE);


	}

	@Parameters({"validusername","validpassword"})
	@Test(priority=3)
	public void verifyLoginwithValidUsernameandValidPassword(String username,String password) {

		obj=new LoginPage(driver);
		obj.loginDetails(username,password);
		Assert.assertEquals(obj.getLoginPageTitle(), Constants.LOGINTITLE);


	}
}
