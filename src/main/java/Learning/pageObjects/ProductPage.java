package Learning.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Learning.AbstractComponents.AbstractComponents;

public class ProductPage extends AbstractComponents{
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//PageFactory
	
	// WebElements
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy(css=".continue")
	WebElement continueButton;
	
	
	
	
	By productsBy = By.cssSelector(".mb-3");
	By addtoCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	By viewButton = By.cssSelector(".card-body button:first-of-type");
	
	
	public List<WebElement> getProductsList() {
		waitForElementToApper(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod = getProductsList().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addtoCart).click();
		waitForElementToApper(toastMessage);
		waitForElementToDisappear(spinner);
	}
	
	public void clickOnViewAndReturnBack(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(viewButton).click();
		waitForWebElementToApper(continueButton);
		continueButton.click();
		waitForElementToApper(viewButton);
		
	}
	
	public void clickOnViewButton(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(viewButton).click();
	}
	
	public void clickOnContinueProductDesc() {
		waitForWebElementToApper(continueButton);
		continueButton.click();
	}
	
	public Boolean verifyProductsPage(String productName) {
		WebElement prod = getProductByName(productName);
		return prod.findElement(viewButton).isDisplayed();
	}
}
