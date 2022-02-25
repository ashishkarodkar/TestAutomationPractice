package stepdefinitions;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	
	@Given("user is already logged in to application")
	public void user_is_already_logged_in_to_application(DataTable credentialTable) {
		List<Map<String, String>> loginDetails = credentialTable.asMaps();
		String userName = loginDetails.get(0).get("username");
		String password = loginDetails.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		accountsPage = loginPage.doLogin(userName, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	    accountsPage.getAccountspageTitle();
	}

	@Then("user gets Accounts section")
	public void user_gets_accounts_section(DataTable accountPageListTable) {
		List<String> expectAccountItemsList = accountPageListTable.asList();
		
		List<String> actualAccountItemsList = accountsPage.getAccountSectionList();
		
		
		System.out.println(expectAccountItemsList);
		System.out.println(actualAccountItemsList);
		
		Assert.assertTrue(expectAccountItemsList.containsAll(actualAccountItemsList));
		Assert.assertTrue(expectAccountItemsList.equals(actualAccountItemsList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer accountListItemCount) {
		Assert.assertTrue(accountListItemCount == accountsPage.getAccountSectionCount());
	    
	}
}
