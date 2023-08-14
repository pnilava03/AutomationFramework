package runners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import utils.Reports;
import static utils.Reports.extentReports;


public class TestRunner {

    @CucumberOptions(tags = "@Sanity",
            features = {"src/test/java/features"},
            glue = {"stepDefinitions"},
            plugin = {"html:target/results.html", "message:target/results.ndjson"}
    )

    @Test
    public class Run extends AbstractTestNGCucumberTests {
    }
}
