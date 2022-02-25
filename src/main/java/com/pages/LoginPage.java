package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.ActionsUtil;

public class LoginPage {

	private WebDriver driver;

	// 1. Page factory Locators

	@FindBy(id = "email")
	private WebElement emailAddrField;

	@FindBy(id = "passwd")
	private WebElement passwordField;

	@FindBy(id = "SubmitLogin")
	private WebElement btnSignIn;

	@FindBy(linkText = "Forgot your password?")
	private WebElement lnkForgotPassword;

	// 2. constructor of the page class

	public LoginPage(WebDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	// 3. Page actions: features (behavior) of the page in the form of methods

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean checkForgotPasswordLink() {
		return lnkForgotPassword.isDisplayed();
	}

	public void enterUserName(String userName) {
		emailAddrField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLoginButton() {
		btnSignIn.click();
	}
	
	public AccountsPage doLogin(String userName, String password) {
		emailAddrField.sendKeys(userName);
		passwordField.sendKeys(password);
		btnSignIn.click();
		return new AccountsPage(driver);
	}

}
