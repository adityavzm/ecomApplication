package Learning.FeatureFiles;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Learning/FeatureFiles",glue="Learning.stepDefinitions", monochrome=true, plugin= {"html: target/cucumber-report-html/cucumber.html"}, tags="@smoke")
public class SmokeRunner extends AbstractTestNGCucumberTests {
	
	

}
