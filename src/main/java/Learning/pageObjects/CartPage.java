package Learning.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}


	@FindBy(css=".btn.btn-primary[routerlink='/dashboard']")
	WebElement continueShopingButton;
	
	@FindBy(css=".btn.btn-danger")
	WebElement deleteButton;
	
	@FindBy(xpath="//button[normalize-space()='Buy Now']")
	WebElement buyNowButton;
	
	@FindBy(css="li[class='totalRow'] button[type='button']")
	WebElement checkOutButton;
	
	
	public OrderPage clickCheckOutButton() {		
		checkOutButton.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
		
		
	}
	
	public void clickRemoveProduct() {
		deleteButton.click();
	}
	
	public void clickContinueShopping() {
		continueShopingButton.click();
	}

}
