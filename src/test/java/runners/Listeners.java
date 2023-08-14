package runners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.CommonMethods;
import utils.Reports;

public class Listeners implements ITestListener {
    ExtentReports extentReports= Reports.attachReport();
    ExtentTest test;
    String screenshotDir="./screenshots/";
    @Override
    public void onTestStart(ITestResult result){
        test=extentReports.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        String passedTest=result.getName();
        test.log(Status.PASS,"Test Passed")
                .pass(MediaEntityBuilder.createScreenCaptureFromPath(screenshotDir+passedTest+".png").build());


    }
    @Override
    public void onTestFailure(ITestResult result){
        String failedTest=result.getName();
        test.log(Status.FAIL,result.getThrowable())
                .fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotDir+failedTest+".png").build());
    }
    @Override
    public void onTestSkipped(ITestResult result){
        test.log(Status.SKIP,"Test Skipped");

    }
    @Override
    public  void onFinish(ITestContext context){
        extentReports.flush();
    }

}
