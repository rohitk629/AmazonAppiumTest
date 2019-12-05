package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "src/test/java/features/AmazonScenario2.feature" }, plugin = { "pretty",
		"json:target/cucumber.json",
		"html:target/site/cucumber-pretty" }, monochrome = false, dryRun = false, glue = { "stepDefinitions", "hooks" }, tags = {
				"@scenario" })
public class TestRunner extends AbstractTestNGCucumberTests {


}
