package com.test.learning;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestData {
	public static void main(String args[]) throws IOException {
		
		readPropertiesData();
	}
	public static void readPropertiesData() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/test.properties");
		Properties properties=new Properties();
		properties.load(file);
		JSONObject json = new JSONObject(properties);
		System.out.println(json);	
	}
}
