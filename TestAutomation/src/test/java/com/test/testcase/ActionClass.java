package com.test.testcase;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionClass {
	WebDriver driver;
	@Test
	@BeforeTest
	public void testSetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.print("Testing");
       
	}
	
	//@Test
	public void doubleClick() {
		driver.get("https://demoqa.com/buttons"); 
		System.out.println("Demoqa Web Page Displayed"); 
		driver.manage().window().maximize(); 

		Actions actions = new Actions(driver); 
		
		WebElement btnElement = driver.findElement(By.id("doubleClickBtn")); 
		actions.doubleClick(btnElement).perform();
	}
	//@Test
	public void rightClick() {
		   driver.get("https://demoqa.com/buttons");
		//Instantiate Action Class
		   Actions actions = new Actions(driver);
			 
		   //Retrieve WebElement to perform right click
		   WebElement btnElement = driver.findElement(By.id("rightClickBtn"));
			 
		   //Right Click the button to display Context Menu&nbsp;
		   actions.contextClick(btnElement).perform();
		  
		  
	}
	//@Test
	@Test
	public void testDragAndDrop() {
		String URL = "https://demoqa.com/droppable/";
		 
		driver.get(URL);	
		Actions builder = new Actions(driver);
		WebElement from = driver.findElement(By.id("draggable"));
		 
		WebElement to = driver.findElement(By.id("droppable"));	 
		builder.dragAndDrop(from, to).perform();
		
		String textTo = to.getText();

		if(textTo.equals("Dropped!")) {
			System.out.println("PASS: Source is dropped to target as expected");
		}else {
			System.out.println("FAIL: Source couldn't be dropped to target as expected");
		}
	}
	@Test
	public void takeScreenshot() throws IOException {
        driver.get("https://demoqa.com");
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("/Users/sohrabahmad/Documents/test.png"));
        
	}
	//@Test
	public void keyboardEvents() {
		driver.get("https://www.w3schools.com/html/html_forms.asp");		
		
		driver.manage().window().maximize();
		
		// Create object of the Actions class
        Actions actions = new Actions(driver);
		        
        // Clear existing value in the first name textbox
        driver.findElement(By.id("fname")).clear();	
        
        //Setting a new name
		driver.findElement(By.id("Richard")).clear();	
        
        
        // Copy the Current Address
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        
        /// Copy the value of First Name using CTRL + C
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
		
		// Press the TAB Key to Switch Focus to Last Name
        actions.sendKeys(Keys.TAB);
        actions.build().perform();		
		
        // Select the existing value of Last Name using CTRL + A
		actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
		
        // Paste the value of First Name using CTRL + V
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
       
        
	}
	

}
