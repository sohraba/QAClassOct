package com.test.testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Satifice {
	WebDriver driver;
	@Test
	public void testSatisfise() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.satisfice.com/");
		List<WebElement> numberOfMenu=driver.findElements(By.xpath("//ul[@id='menu-main-navigation']/li"));
		System.out.println("Menu Size"+numberOfMenu.size());
		for(int i=1;i<=numberOfMenu.size();i++)
		{
				WebElement menuItem=driver.findElement(By.xpath("//ul[@id='menu-main-navigation']/li["+i+"]/a/span"));
				String menuItemText=menuItem.getText();
				System.out.println("Menu Items:::"+menuItemText);
				Actions action=new Actions(driver);
				List<WebElement> numberOfSubMenu=driver.findElements(By.xpath("//ul[@id='menu-main-navigation']/li["+i+"]/ul/li"));
				System.out.println("SubMenu Size"+numberOfSubMenu.size());
				for(int j=1;j<=numberOfSubMenu.size();j++){
				action.moveToElement(menuItem).build().perform();
				TimeUnit.SECONDS.sleep(2);
				String subMenuText=driver.findElement(By.xpath("//ul[@id='menu-main-navigation']/li["+i+"]/ul/li["+j+"]/a/span")).getText();
				System.out.println("Sub Menu Items:::"+subMenuText);
				}
		}
		
	}
}
