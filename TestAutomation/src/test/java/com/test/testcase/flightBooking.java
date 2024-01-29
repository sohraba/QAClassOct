package com.test.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.page.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class flightBooking {
	WebDriver driver;

	@Parameters({ "username", "password" })
	@Test(dependsOnMethods = "intializeTest")
	public void aTestFlightBooking(String username,String password) throws IOException {
		driver.get("https://demo.guru99.com/test/newtours/");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickSubmitButton();
		
	}
	
	@Test
	public void intializeTest() {
			driver = new ChromeDriver();
		
	}
	
	@Test(enabled=false,dataProvider="getData",description = "This is the test to login flight demo application")
	public void setData(String username, String password) throws InterruptedException
	{
		driver.get("https://demo.guru99.com/test/newtours/");
		TimeUnit.SECONDS.sleep(500);
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password); 
		driver.findElement(By.name("submit")).click(); 
	}

	@DataProvider
	public Object[][] getData()
	{
	//Rows - Number of times your test has to be repeated.
	//Columns - Number of parameters in test data.
	Object[][] data = new Object[3][2];

	// 1st row
	data[0][0] ="admin";
	data[0][1] = "admin";

	// 2nd row
	data[1][0] ="test";
	data[1][1] = "test";
	
	// 3rd row
	data[2][0] ="user1";
	data[2][1] = "pass123";

	return data;
	}
}
