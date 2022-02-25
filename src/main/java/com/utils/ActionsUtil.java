package com.utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ActionsUtil {
	
	private WebDriver driver;
	
	public ActionsUtil (WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(this.driver, this);
	}
	
	public void handleMultipleWindows() {
		Set<String> winHandlesSet = driver.getWindowHandles();
		
		for(String handle : winHandlesSet) {
			driver.switchTo().window(handle);
			if(driver.getTitle().equalsIgnoreCase("MyTitle")) {
				break;
			}
			
		}
	}

}
