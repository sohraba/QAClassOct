package com.test.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightBooking {

	WebDriver driver;
	@FindBy(name = "tripType")
	List<WebElement> passenger_Dropdown;
	
	@FindBy(name = "findFlights")
     WebElement continue_Button;
	
	@FindBy(name="submit")
	 WebElement submit_button;
	
	public FlightBooking(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickContinue() {
		continue_Button.click();
	}
}
