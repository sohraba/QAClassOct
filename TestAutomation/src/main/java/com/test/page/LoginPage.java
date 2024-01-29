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
	
	public void enterUserName() throws IOException {
		String userName=getPropertyValue("username");
		username_textfield.sendKeys(userName);
	}
	public void enterPassword() throws IOException {
		String password=getPropertyValue("password");
		password_textfield.sendKeys(password);
	}
	public void clickSubmitButton() {
		submit_button.click();
	}

}
