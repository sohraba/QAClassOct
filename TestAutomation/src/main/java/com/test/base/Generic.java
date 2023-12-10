package com.test.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Generic {
	String env;
	String filePath;

	public void openBrowser(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

	}

	public String getPropertyValue(String propertyName) throws IOException {
		env = System.getProperty("environment");
		System.out.print(env);
		if (env == null)
			env = "QA";
		filePath = System.getProperty("user.dir") + "/src/main/resources/" + env + "/Configuration.properties";
		FileInputStream fileReader = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(fileReader);
		return prop.getProperty(propertyName);

	}

	public void getEnvironment() {

	}

}
