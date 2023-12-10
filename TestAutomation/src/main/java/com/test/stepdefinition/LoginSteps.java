package com.test.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;

	@Given("user navigates to Login Page")
	public void user_navigates_to_login_page() {
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
	}
	@When("user enters username {string}")
	public void user_enters_username(String username) {
		driver.findElement(By.name("userName")).sendKeys(username);
	}

	@And("user enters password {string}")
	public void user_enters_password(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}
	@And("user clicks on submit button")
	public void user_enters_username_and_password() {
		driver.findElement(By.name("submit")).click();
	}
	@Then("success message is displayed")
	public void success_message_is_displayed() {
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Login Successfully']")).isDisplayed());
		driver.quit();
	}
	

}
