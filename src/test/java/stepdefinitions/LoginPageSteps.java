package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());

	private static String title;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user get title of the page")
	public void user_get_title_of_the_page() {
	    title = loginpage.getLoginPageTitle();
	    System.out.println(title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		title = loginpage.getLoginPageTitle();
		System.out.println(title);
	    Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	    Assert.assertTrue(loginpage.checkForgotPasswordLink());
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
	    loginpage.enterUserName(userName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	    loginpage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    loginpage.clickLoginButton();
	}
	
}
