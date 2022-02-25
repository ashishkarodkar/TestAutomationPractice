package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.ActionsUtil;

public class AccountsPage{

	private WebDriver driver;
	
	@FindBy(xpath = "//div[@id='center_column']//ul[@class='myaccount-link-list']//span")
	private List<WebElement> myAccountList;
	
	public AccountsPage(WebDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public int getAccountSectionCount() {
		return myAccountList.size();
	}
	
	public List<String> getAccountSectionList() {
		
		List<String> accountList = new ArrayList<String>();
		for(WebElement listItem : myAccountList) {
			accountList.add(listItem.getText().trim());
		}
		
		return accountList;
	}
	
	public String getAccountspageTitle() {
		return driver.getTitle();
	}
	
}
