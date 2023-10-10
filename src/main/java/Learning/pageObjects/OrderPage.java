package Learning.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Learning.AbstractComponents.AbstractComponents;


public class OrderPage extends AbstractComponents {

	WebDriver driver;
	
	public OrderPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	
	@FindBy(css = "input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css =".ta-results button span")
	WebElement selectCountry;
	
	@FindBy(css=".actions a")
	WebElement placeOrder;
	

	
	By dropdown = By.cssSelector(".ta-results button");
	By inputBox = By.cssSelector("input[placeholder='Select Country']");
	
	public void enterCountryAndSelect(String countries) {
		
		waitForElementToApper(inputBox);
		country.sendKeys(countries);		
		selectCountry.click();

		
	}
	
	public ConfirmationPage placeOrder() {
		placeOrder.click();
		return new ConfirmationPage(driver);
	}
	

	

}
