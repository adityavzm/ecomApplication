package Learning.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Learning.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
	@FindBy(css="#userEmail")
	WebElement userEmailTextBox;
	
	
	@FindBy(css="#userPassword")
	WebElement userPasswordTextBox;
	
	@FindBy(css="#login")
	WebElement loginButton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductPage enterUserCrendentialsAndLogin(String userName, String password) {
		userEmailTextBox.sendKeys(userName);
		userPasswordTextBox.sendKeys(password);
		loginButton.click();
		ProductPage productPage = new ProductPage(driver);
		return productPage;
		
		
	}
	
	public Boolean verifyLoginSuccessfull() {
		return getHomeButton().isDisplayed();
		
	}
	
	public String getErrorMessage() {
		waitForWebElementToApper(errorMessage);
		return errorMessage.getText();
	}
	

}
