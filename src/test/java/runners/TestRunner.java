package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



public class TestRunner {

    @CucumberOptions(

            features={"src/test/java/features"},
            glue={"stepDefinitions"},
            plugin= { "html:target/results.html", "message:target/results.ndjson" }
    )


    public static class Run extends  AbstractTestNGCucumberTests{

    }

}
