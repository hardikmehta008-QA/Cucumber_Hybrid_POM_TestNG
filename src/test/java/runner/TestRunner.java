package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "E:\\Intellij_IDEA_Projects\\Selenium_Cucumber_Hybrid_POM\\src\\test\\resources\\features", //the path of the feature file.
        glue = {"stepDefinitions", "AppHooks"}, //the path of the step definition file.
        plugin = { //to generate different types of reporting.
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        dryRun = false, //to check the mapping is proper between feature file & step definition file.
        monochrome = true //Display the console output in a proper readable format.
)

public class TestRunner {
}
