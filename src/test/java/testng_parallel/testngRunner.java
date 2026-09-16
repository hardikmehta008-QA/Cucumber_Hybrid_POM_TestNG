package testng_parallel;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

// TestNG runner for Cucumber. DataProvider parallel = true enables scenario-level parallelism.
@CucumberOptions(
        features = "src\\test\\resources\\features", // relative path to feature files
        glue = {"stepDefinitions", "AppHooks"}, // step definitions and hooks packages
        plugin = { // reporting plugins                "pretty",                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",                "html:target/cucumber-reports/cucumber.html",                "json:target/cucumber-reports/cucumber.json"        },        dryRun = false, // set true to verify mappings without running steps        monochrome = true // readable console output)
public class testngRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
