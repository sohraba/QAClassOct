package com.test.page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.Generic;

public class LoginPage extends Generic{
	WebDriver driver;
	
	
	@FindBy(name = "userName")
	WebElement username_textfield;
	
	@FindBy(name = "password")
     WebElement password_textfield;
	
	@FindBy(name="submit")
	 WebElement submit_button;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void login() throws IOException {
		String userName=getPropertyValue("username");
		String password=getPropertyValue("password");
		username_textfield.sendKeys(userName);
		password_textfield.sendKeys(password);
		submit_button.click();
		
	}

}
