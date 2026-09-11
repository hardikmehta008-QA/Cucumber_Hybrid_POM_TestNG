package testng_parallel;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src\\test\\resources\\features", //the path of the feature file.
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
public class testngRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
