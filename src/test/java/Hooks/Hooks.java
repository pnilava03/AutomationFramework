package Hooks;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.model.Report;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utils.Driver;
import utils.Log;
import utils.Reports;

import java.util.Arrays;

public class Hooks {

    @Before
    public void setup(){
        Log.info("      -:V-Tiger Automation Project is Running:-       ");
    }
    @AfterStep
    public void attachScreenShot(Scenario scenario) throws Exception {
        TakesScreenshot screenshot=(TakesScreenshot) Driver.driver;
        final byte[] screenShots=screenshot.getScreenshotAs(OutputType.BYTES);
        ExtentCucumberAdapter.addTestStepLog(scenario.toString());
        scenario.attach(screenShots,"image/png","image");





    }

    @After
    public void tearDown(){
        Log.info("Closing the Browser");
        Driver.driver.quit();
    }



}
