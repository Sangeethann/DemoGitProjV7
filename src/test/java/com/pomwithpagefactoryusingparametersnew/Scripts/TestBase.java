package com.pomwithpagefactoryusingparametersnew.Scripts;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.pomwithpagefactoryusingparametersnew.Constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterTest;

//Refer: https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html
public class TestBase {
	

	public static WebDriver driver;
	public static Properties prop=null;

	public static void testBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources"+"\\Config.properties");
			prop.load(ip);
		}

		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult iTestResult) throws IOException {

		if((iTestResult.getStatus()==iTestResult.SUCCESS)||(iTestResult.getStatus()==iTestResult.FAILURE))
		{
			takeScreenshotsOn(iTestResult.getName());
		}

	}

	public void takeScreenshotsOn(String name) throws IOException {


		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//Add the dependency of shutterbug in pom.xml file
        Shutterbug.shootPage(driver,Capture.FULL,true).save(System.getProperty("user.dir")+"\\target\\screenshots\\"+name+dateName+".png");


	}
	@Parameters({"browsers"})
	@BeforeTest
	public void beforeTest(String browser) throws Exception {

		testBase();
		getBrowser(browser);
		String baseUrl=prop.getProperty("baseUrl");
		driver.get(baseUrl);
		takeScreenshotsOn("Home");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	public void getBrowser(String browser) throws Exception {

		if(browser.equalsIgnoreCase(Constants.CHROMEBROWSER))
		{

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}

		else if(browser.equalsIgnoreCase(Constants.EDGEBROWSER))
		{
			System.setProperty(Constants.EDGEDRIVER, System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers"+"\\msedgedriverlatest.exe");
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception(Constants.BROWSERNOTCORRECT);
		}



	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
