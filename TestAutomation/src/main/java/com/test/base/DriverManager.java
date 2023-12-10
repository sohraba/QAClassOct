package com.test.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DriverManager {
	public static WebDriver driver;
	public String env;
	public String browserName;
	Generic generics = new Generic();

	@BeforeTest
	public void setup() throws IOException {
		if (System.getProperty("browserName") != null)
			browserName = System.getProperty("browserName");
		else
			browserName = generics.getPropertyValue("browserName");
		
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
