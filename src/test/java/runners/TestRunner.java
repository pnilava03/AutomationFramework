package runners;

import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import utils.Driver;

@CucumberOptions(tags = "@Sanity",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/java/features"},
        glue = {"stepDefinitions", "Hooks"}

)


public class TestRunner extends AbstractTestNGCucumberTests {





}
