package com.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM {

	WebDriver driver;
	By userName=By.name("userName");
	
	public LoginPOM(WebDriver driver) {
		this.driver=driver;
	}
	
	public void typeUserName() {
		driver.findElement(userName).sendKeys("");
	}
	
}
