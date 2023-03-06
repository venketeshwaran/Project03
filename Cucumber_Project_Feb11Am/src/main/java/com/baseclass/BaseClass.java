package com.baseclass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver browser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver.manage().window().maximize();

		}
		return driver;
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void getPageSource() {
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}

	public static void getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void screenShot(String filename) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinateFile = new File(System.getProperty("screenshot.dir") + "\\screenshot" + filename + ".png");
		FileUtils.copyFileToDirectory(sourceFile, destinateFile);

	}

	public static void sendKeys(WebElement element, String value) {

		element.sendKeys(value);
	}

	public static void clickOnElement(WebElement element) {

		element.click();
	}

	public static void selection(WebElement element, String option, String value) {

		Select s = new Select(element);
		if (option.equalsIgnoreCase("byValue")) {

			s.selectByValue(value);
		}

		else if (option.equalsIgnoreCase("byVisibletext")) {

			s.selectByVisibleText(value);
		}

		else if (option.equalsIgnoreCase("byindex")) {

			int parseInt = Integer.parseInt(value);

			s.selectByIndex(parseInt);
		}

	}

}
