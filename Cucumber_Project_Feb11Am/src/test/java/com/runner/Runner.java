package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\mages\\eclipse-workspace\\Cucumber_Project_Feb11Am\\src\\test\\java\\com\\feature\\google.feature" ,
                   glue = "com.stepdefinition")
public class Runner {

	
	
}
