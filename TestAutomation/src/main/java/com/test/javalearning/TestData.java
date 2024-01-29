package com.test.javalearning;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class TestData {
	public static void main(String args[]) throws IOException {
		
		readPropertiesData();
	}
	public static void readPropertiesData() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/test.properties");
		Properties properties=new Properties();
		properties.load(file);	
	}
}
