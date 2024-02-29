package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Feature_File//search_bookshelves.feature", 
		glue = "stepDefinitions",
		plugin = {
		"pretty", "html:Cucumber_Report/myReport.html", "rerun:target/rerun.txt",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
		dryRun = false, 
		monochrome = true, 
		publish = true)
public class TestRunner {
	// Your test runner class implementation
}
