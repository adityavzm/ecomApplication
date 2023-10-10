package Learning.stepDefinitions;

import org.testng.Assert;

import Learning.pageObjects.LoginPage;
import Learning.pageObjects.ProductPage;
import Learning.testComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class productPageDefinitions extends BaseTest {
	
	public LoginPage loginPage;
	public ProductPage productPage;
	
	
	@Given("^User logged into portal with (.+) and (.+)$")
	public void User_logged_into_portal(String userName, String password) {
		
		loginPage = launchApplication();
		productPage = loginPage.enterUserCrendentialsAndLogin(userName, password);
		Assert.assertEquals(loginPage.verifyLoginSuccessfull(), true , "Login SuccessFull");
		
	}
	
	@And("^User adds to cart the cart (.+)$")
	public void User_adds_to_cart_the_cart(String productName){
		productPage.addProductToCart(productName);
	}
	
	@Then("Product should be added to the cart")
	public void Product_should_be_added_to_the_cart() {		
		Assert.assertNotNull(productPage.getNumberOfOrders(), "Items added to cart");
		tearDown();
	}
}
