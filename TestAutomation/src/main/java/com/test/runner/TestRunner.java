package com.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./src/test/java/com/test/cucumber", 
glue = { "" }, 
monochrome = true, plugin = { "pretty",
		"html:Reports/cucumber-pretty" })

public class TestRunner extends AbstractTestNGCucumberTests {

}
