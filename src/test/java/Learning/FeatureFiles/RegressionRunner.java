package Learning.FeatureFiles;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Learning/FeatureFiles",
glue="Learning.stepDefinitions",
plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-reports/Cucumber.html"}
,monochrome = true, tags="@regression")
public class RegressionRunner extends AbstractTestNGCucumberTests {
	
	

}
