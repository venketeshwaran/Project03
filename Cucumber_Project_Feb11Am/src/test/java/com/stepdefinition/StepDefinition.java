package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import com.baseclass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinition extends BaseClass{
	
	@Given("User Launch the url")
	public void user_launch_the_url() {
	   
		browser("chrome");
		getUrl("https://www.google.com/");
	}
	@When("User Click the search box")
	public void user_click_the_search_box() {
		
		driver.findElement(By.xpath("//input[@title='Search']")).click();
	
	}
	
	@When("User enter a term of {string}")
	public void user_enter_a_term_of(String string) {
	 
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(string);
	}
	@When("User click the enter button")
	public void user_click_the_enter_button() throws AWTException {
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}
	@Then("User Validate the page")
	public void user_validate_the_page() {
	
		String actual = driver.getTitle();
		System.out.println(actual);
		
		String Excepted = "Google";
		
		Assert.assertEquals(Excepted, actual);
	}




}
