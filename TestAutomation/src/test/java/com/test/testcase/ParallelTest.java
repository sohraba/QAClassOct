package com.test.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;

public class ParallelTest {
	public WebDriver driver;
        @Test
        public void FirefoxTest() {	 
            //Initializing the firefox driver (Gecko)
	    driver = new FirefoxDriver();	  
	    driver.get("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.name("userName")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin"); 
		driver.findElement(By.name("submit")).click(); 
         }
 
        @Test
 	public void ChromeTest()
 	{ 
	  //Initialize the chrome driver
	  driver = new ChromeDriver();
	  driver.get("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.name("userName")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin"); 
		driver.findElement(By.name("submit")).click(); 
 	}
}