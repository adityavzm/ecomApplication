package Learning.FeatureFiles;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Learning/FeatureFiles",glue="Learning.stepDefinitions", 	plugin = { "html:target/cucumber.html"},
monochrome = true, tags="@smoke")
public class SmokeRunner extends AbstractTestNGCucumberTests {
	
	

}
