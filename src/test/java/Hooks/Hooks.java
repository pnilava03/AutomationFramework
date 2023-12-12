package Hooks;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.model.Report;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utils.Driver;
import utils.Log;
import utils.Reports;

import java.util.Arrays;

public class Hooks {

public static Scenario message;


    @Before
    public void setup(){
        Log.info("      -:actiTime Automation Project is Running:-       ");
    }

    @BeforeStep
    public void beforeStep(){
        Log.info("============= Executing Steps =============");
    }
    @AfterStep
    public void attachScreenShot(Scenario scenario) throws Exception {
        Reports.message=scenario;

    }



    @After
    public void tearDown(){
        Log.info("Closing the Browser");
        Driver.driver.quit();
    }



}
