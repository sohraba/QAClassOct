package com.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPOM {

	WebDriver driver;
	By userName=By.name("userName");

	
	public LoginPOM(WebDriver driver) {
		this.driver=driver;
	}
	
	public void typeUserName(String userNameVal) {
		WebElement userNameElem=driver.findElement(userName);
		userNameElem.sendKeys(userNameVal);
	}
	
}
