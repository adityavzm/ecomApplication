package Learning.stepDefinitions;

import org.testng.Assert;

import Learning.pageObjects.CartPage;
import Learning.pageObjects.ConfirmationPage;
import Learning.pageObjects.LoginPage;
import Learning.pageObjects.OrderPage;
import Learning.pageObjects.ProductPage;
import Learning.testComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class productPageDefinitions extends BaseTest {
	
	public LoginPage loginPage;
	public ProductPage productPage;
	public CartPage cartPage;
	public OrderPage orderPage;
	public ConfirmationPage confPage;
	
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
	
	@And("^Click on View button (.+)$")
	public void Click_on_View_button(String productName) {
		productPage.clickOnViewButton(productName);
	}
	
	@And("Click continue button on product description page")
	public void Click_continue_button_on_product_description_page() {
		productPage.clickOnContinueProductDesc();
	}
	
	@And("^Return to products page (.+)$")
	public void Return_to_products_page(String productName) {
		Assert.assertEquals(productPage.verifyProductsPage(productName), true , "return SuccessFull");
	}
	
	@And("User clicks on checkout")
	public void User_clicks_on_checkout() {
		
		cartPage = loginPage.goToCartPage();
		orderPage = cartPage.clickCheckOutButton();
		
	}
	
	@And("^User adds country (.+)$")
	public void User_adds_country(String country) {
		
		orderPage.enterCountryAndSelect(country);
	}
	
	@Then("clicking on Place Orders should complete the order")
	public void clicking_on_Place_Orders_should_complete_the_order() {
		confPage = orderPage.placeOrder();
		String message = confPage.confrimMessage();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
	}
}
