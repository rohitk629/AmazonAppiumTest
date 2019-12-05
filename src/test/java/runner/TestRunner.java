package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "src/test/java/features/AmazonScenario.feature" }, plugin = { "pretty",
		"json:target/cucumber.json",
		"html:target/site/cucumber-pretty" }, monochrome = false, dryRun = false, glue = { "stepDefinitions", "hooks" }, tags = {
				"@Required" })
public class TestRunner extends AbstractTestNGCucumberTests {


}
