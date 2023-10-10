package Learning.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Learning.pageObjects.CartPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
	@FindBy(css=".btn.btn-custom[routerlink='/dashboard/']")
	WebElement homeLink;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	@FindBy(css="button[class='btn btn-custom'] label")
	WebElement numberOfOrders;
	
	public void waitForElementToApper(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToApper(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public WebElement getHomeButton() {
		
		return homeLink;
		
	}
	
	public CartPage goToCartPage() {
		
		cart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
		
	}
	
	public int getNumberOfOrders() {
		String ele = numberOfOrders.getText();
		return Integer.parseInt(ele);
	}
	

	
	
}
