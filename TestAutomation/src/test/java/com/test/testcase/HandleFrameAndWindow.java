package com.test.testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleFrameAndWindow {
	WebDriver driver;
	@Test
	@BeforeTest
	public void testSetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       
	}
	@Test
	public void testHandleFrame() {
		driver.get("https://demoqa.com/frames");
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("Total number of iframes are " + iframeElements.size());
		
		driver.switchTo().frame("frame1"); //BY fid
		String frameText=driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(frameText);
		driver.switchTo().frame("IF1");// Switch By ID
		driver.switchTo().frame(0); 	//Switch by Index 
//		
//		//Come back to main window
		driver.switchTo().defaultContent();
		
	}
	@Test
	public void windowHandle() {
	        driver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
	        System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");
	        driver.switchTo().frame("iframeResult");
	        WebElement visitLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
	        visitLink.click();
	        
	        
	        Set<String> windowHandles = driver.getWindowHandles();
	        List<String> windowHandlesList = new ArrayList<>(windowHandles); //Set to List Conversion
	        System.out.println("Total window number: " + windowHandlesList.size() + "\n");
	        
	        
	        driver.switchTo().window(windowHandlesList.get(1));
	        System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");
	        WebElement logo = driver.findElement(By.cssSelector(".fa.fa-logo"));
	        AssertJUnit.assertTrue(logo.isDisplayed());
	       
	        driver.switchTo().window(windowHandlesList.get(0));
	        System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");
	        WebElement seeResultButton = driver.findElement(By.cssSelector("button[onclick*='submitTryit(1)'"));
	        AssertJUnit.assertTrue(seeResultButton.getText().contains("Run ❯"));
	    
	        driver.switchTo().defaultContent();
	}

}
