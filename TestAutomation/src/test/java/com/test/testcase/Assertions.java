package com.test.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assertions {
	@Test
	public void testAssertFunctions() {
	WebDriver driver = new ChromeDriver();
	driver.navigate().to("https://www.browserstack.com/");
	String ActualTitle = driver.getTitle();
	String verifyAssertNull=null;
	String ExpectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
	Boolean verifyTitleIsPresent=driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform | BrowserStack");
	Boolean verifyTitleIsChanged=driver.getTitle().equalsIgnoreCase("Testing Platform | BrowserStack");
	Assert.assertEquals(ExpectedTitle, ActualTitle);
	Assert.assertNotEquals(ExpectedTitle, "browserstack");
	Assert.assertFalse(verifyTitleIsChanged);
	Assert.assertNotNull(verifyTitleIsPresent);
	Assert.assertNull(verifyAssertNull);
	}
	@Test
	public void softAssert() {
	WebDriver driver = new ChromeDriver();
	SoftAssert softAssert = new SoftAssert();
	driver.navigate().to("https://www.browserstack.com/");
	String getActualTitle = driver.getTitle();
	Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform | BrowserStack");
	softAssert.assertEquals(getActualTitle, "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
	softAssert.assertNotEquals(getActualTitle, "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
	softAssert.assertNull(verifyTitle);
	softAssert.assertNotNull(verifyTitle);
	softAssert.assertTrue("BrowserStack".equals("Browserstack"), "First soft assert failed");
	softAssert.assertFalse("BrowserStack".equals("BrowserStack"), "Second soft assert failed");
	softAssert.assertAll(); 
	}

}
