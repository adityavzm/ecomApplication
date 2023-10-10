package Learning.stepDefinitions;

import org.testng.Assert;

import Learning.pageObjects.LoginPage;
import Learning.testComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class loginPageDefinitions extends BaseTest{
	
	public LoginPage loginPage;
	
	@Given("User can access application")
	public void User_can_access_application() {
		loginPage = launchApplication();
	}
	
	@And("^Login with valid username (.+) and password (.+)$")
	public void Login_with_valid_username_password(String username, String password) {
		loginPage.enterUserCrendentialsAndLogin(username, password);		
	}
	
	@Then("User should see products")
	public void User_should_see_products() {
		Assert.assertEquals(loginPage.verifyLoginSuccessfull(), true , "Login SuccessFull");
		tearDown();
	}
	
	@Then("User should be unsuccessful")
	public void User_should_be_unsuccessful() {
		Assert.assertEquals("Incorrect email or password.", loginPage.getErrorMessage());
		tearDown();
	}
	
}
