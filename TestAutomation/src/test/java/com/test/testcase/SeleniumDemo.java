package com.test.testcase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumDemo {
	WebDriver driver;
	
	@BeforeTest
	public void testSetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
		List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@id='menu-main-navigation']/li"));
		for(int i=1;i<=menuItems.size();i++) {
			driver.findElement(By.xpath("//ul[@id='menu-main-navigation']/li["+i+"]/a/span")).getText();
		}
       
	}

	@Test
	public void testFlightBooking() {
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.name("userName")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin"); 
		driver.findElement(By.name("submit")).click(); 
		
		//Radio Button
		driver.get("https://demo.guru99.com/test/newtours/reservation.php");
		List<WebElement> tripTypeRadio = driver.findElements(By.name("tripType"));
		for(int i=0;i<tripTypeRadio.size();i++) {
			String tripType=tripTypeRadio.get(i).getAttribute("value");
			if(tripType.equalsIgnoreCase("oneway")) {
				tripTypeRadio.get(i).click();
			}
		}
		
		//from Dropdown
		WebElement fromPort=driver.findElement(By.name("fromPort"));
		Select fromDropDown=new Select(fromPort);
		fromDropDown.selectByValue("London");
		
		//Airline Dropdown
		WebElement airline=driver.findElement(By.name("airline"));
		Select airlineDropDown=new Select(airline);
		airlineDropDown.selectByVisibleText("Unified Airlines");
		
		driver.findElement(By.name("findFlights")).click();
		
		
	}
	
	@Test
	public void testUploadFile() {
		String baseUrl = "https://demo.guru99.com/test/upload/";

        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        uploadElement.sendKeys("/Users/sohrabahmad/Desktop/Screenshot 2023-11-20 at 7.58.43 AM.png");

        driver.findElement(By.id("terms")).click();
        driver.findElement(By.name("send")).click();
       }
	@Test
	public void getDimension() {
		driver.get("https://google.com/ncr");
        WebElement searchBox = driver.findElement(By.name("q"));
        Dimension dim = searchBox.getSize();
        
        System.out.println(dim);
	}
		@Test
		public void browserAction() throws InterruptedException {
			driver.navigate().to("https://selenium.dev");
	        
	        //Get the Title of web page
	        String PageTitle= driver.getTitle();
	        System.out.println("Title of Page 1 is : " + PageTitle);    
	        
	        Thread.sleep(2000);
	        System.out.println("Navigate to New Page 2");
	        driver.findElement(By.xpath("//*[@id='main_navbar']/ul/li[4]/a/span")).click();
	
	        Thread.sleep(2000); 
	        System.out.println("Navigate back to Old Page 1");
	        driver.navigate().back();
	 
	        Thread.sleep(2000);
	        System.out.println("Navigate forward to New Page 2");    
	        driver.navigate().forward();
	    
	        Thread.sleep(2000);
	        System.out.println("Refresh the existing page");    
	        driver.navigate().refresh();
		}

}
