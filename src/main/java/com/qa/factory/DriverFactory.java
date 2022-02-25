package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/**
	 * This method is used to initialize the ThreadLoal driver on the basis of given browser name
	 * @param browser
	 * @return tlDriver
	 */
	public WebDriver initdriver(String browser) {
		
		System.out.println("Browser is : " + browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new ChromeDriver());
		}else if(browser.equalsIgnoreCase("safari")) {
			tlDriver.set(new ChromeDriver());
		}else {
			System.out.println("Please enter valid browser name : " + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/**
	 * This is used to get the driver with ThreadLocal
	 * @return 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
