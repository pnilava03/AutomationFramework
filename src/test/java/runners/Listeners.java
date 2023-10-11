package runners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.CommonMethods;
import utils.Driver;
import utils.Reports;

import java.util.Locale;

public class Listeners implements ITestListener {
    ExtentReports extentReports= Reports.attachReport("vTiger Automation Report");
   // String screenshotPath="\\reports\\";
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result){

        test=extentReports.createTest(result.getMethod().getMethodName().toString());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        String passedTest=result.getTestName();
        try {
            test.log(Status.PASS,"Test Passed")
                    .pass(MediaEntityBuilder.createScreenCaptureFromBase64String(Reports.attachScreenShots(passedTest)).build())  ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    @Override
    public void onTestFailure(ITestResult result){
        String failedTest= result.getTestName();
        try {
            test.log(Status.FAIL,result.getThrowable())
                    .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(Reports.attachScreenShots(failedTest)).build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestSkipped(ITestResult result){
        test.log(Status.SKIP,"Test Skipped");

    }
    @Override
    public void onFinish(ITestContext context) {
        Driver.driver.quit();
        extentReports.flush();
        try {
            Thread.sleep(5000);
         //   Reports.openReport();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
