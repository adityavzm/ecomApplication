package Learning.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import Learning.pageObjects.CartPage;
import Learning.pageObjects.ConfirmationPage;
import Learning.pageObjects.LoginPage;
import Learning.pageObjects.OrderPage;
import Learning.pageObjects.ProductPage;
import Learning.testComponents.BaseTest;

public class LoginApplication extends BaseTest
{
	@Test
	public void loginAppliction() {
		
		LoginPage loginPage = launchApplication();
		loginPage.enterUserCrendentialsAndLogin("adityatest@test.com", "Test@123");
		Assert.assertEquals(loginPage.verifyLoginSuccessfull(), true , "Login SuccessFull");
		
	}
    
	@Test
	public void invalidLoginCredentials() {
		
		LoginPage loginPage = launchApplication();
		loginPage.enterUserCrendentialsAndLogin("adityatest@test.com", "WEWE");
		Assert.assertEquals("Incorrect email or password.", loginPage.getErrorMessage());
		
	}
	
	@Test
	public void AddProdut() {
		
		LoginPage loginPage = launchApplication();
		ProductPage productPage = loginPage.enterUserCrendentialsAndLogin("adityatest@test.com", "Test@123");
		Assert.assertEquals(loginPage.verifyLoginSuccessfull(), true , "Login SuccessFull");
		productPage.addProductToCart("ZARA COAT 3");
	}
	
	public void navigateToCartPageAndbackToProduct() {
		LoginPage loginPage = launchApplication();
		ProductPage productPage = loginPage.enterUserCrendentialsAndLogin("adityatest@test.com", "Test@123");
		Assert.assertEquals(loginPage.verifyLoginSuccessfull(), true , "Login SuccessFull");
		productPage.addProductToCart("ZARA COAT 3");
		CartPage cartPage = loginPage.goToCartPage();
		OrderPage orderPage = cartPage.clickCheckOutButton();
		orderPage.enterCountryAndSelect("IND");
		ConfirmationPage confPage = orderPage.placeOrder();
		String message = confPage.confrimMessage();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		
	}
}
