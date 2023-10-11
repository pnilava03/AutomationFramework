package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@Sanity",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-report.json"},
        features = {"src/test/java/features"},
        glue = {"stepDefinitions"}

)


public class TestRunner extends AbstractTestNGCucumberTests {






}
