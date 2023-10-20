package Learning.testComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import Learning.pageObjects.LoginPage;
import Learning.resources.AppConfig;

public class BaseTest {
	
	public WebDriver driver;
	
	
	public WebDriver initializeDriver() {
		String browser = AppConfig.browser;
		
		if(browser.contains("headless")){
			FirefoxOptions ops = new FirefoxOptions();
			ops.addArguments("--headless");
			
			driver = new FirefoxDriver(ops);

		}else if(browser.contains("chrome")) {
			driver = new ChromeDriver();
			
		}else {
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
		
	}
	

	public LoginPage launchApplication() {
		driver = initializeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		LoginPage loginPage = new LoginPage(driver);		
		return loginPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileHandler.copy(Source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}

}
