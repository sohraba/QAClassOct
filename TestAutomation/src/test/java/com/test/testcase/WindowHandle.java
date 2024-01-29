package com.test.testcase;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WindowHandle {
	@Test
	public void winhandles() {
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("Current window handle: " + driver.getWindowHandle() + "\n" );
		
		driver.findElement(By.id("windowButton")).click();
		driver.findElement(By.id("messageWindowButton")).click();	
		
	
		
		Set<String> winHandles = driver.getWindowHandles();
		List<String> winHandlesList = new ArrayList<>(winHandles); // set to list conversion
		
		System.out.println("Total number of windows open: " + winHandles.size() + "\n");
		
		for ( String win : winHandles) {
			
			System.out.println(win + "\n");
		}
		
		driver.switchTo().window(winHandlesList.get(1));
		System.out.println("1 window Handle: " + driver.getWindowHandle() ); // Works fine till here
		
		String sheading = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("1 window Heading: " + sheading + "\n");
		Assert.assertTrue(sheading.contains("sample"));
		driver.close();
		
		
		driver.switchTo().window(winHandlesList.get(0));
		System.out.println("0 window Handle: " + driver.getWindowHandle() + "\n");
		WebElement icon = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
		Assert.assertTrue(icon.isDisplayed());
		driver.close();
		
		driver.switchTo().window(winHandlesList.get(2));
		System.out.println("2 index handle: " + driver.getWindowHandle() + "\n");
		
		String wHeading = driver.findElement(By.xpath("//body")).getText();
		System.out.println("2nd window Heading: " + wHeading);
		driver.close();
		
		
		
		driver.quit();
	}

}
