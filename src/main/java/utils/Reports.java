package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;
import java.io.File;
import java.io.IOException;

//import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.getCurrentStep;

public class Reports {

    public static ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\vTigerReport.html");
    public static ExtentSparkReporter failedReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\vTigerFailReport.html").filter().statusFilter().as(new Status[]{Status.FAIL, Status.SKIP}).apply();

    public static ExtentReports extentReports;
    static final File file = new File("./src/test/resources/config/extentconfig.xml");


    public static ExtentReports attachReport(String projectName) {
        try {
            reporter.loadXMLConfig(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter, failedReporter);
        extentReports.setSystemInfo("OS:: ", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version:: ", System.getProperty("java.version"));
        extentReports.setSystemInfo("UserName:: ", System.getProperty("user.name"));
        extentReports.setSystemInfo("Selenium version:: ", "3.141.59");
        return extentReports;
    }

    public static void openReport() {
        try {
            Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "\\reports\\vTigerReport.html").toURI());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "\\reports\\vTigerFailReport.html").toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


//  //  public static void addStepLogs(String msg){
//        getCurrentStep().info(msg);
//    }

    public static String takeScreenshot(String screenShotName, String msg) throws IOException {
       TakesScreenshot takesScreenshot=(TakesScreenshot)Driver.driver;
       File file =takesScreenshot.getScreenshotAs(OutputType.FILE);
       String imagePath=System.getProperty("user.dir")+"\\reports\\Screenshots\\"+screenShotName+".png";
       FileUtils.copyFile(file, new File(imagePath));
       ExtentCucumberAdapter.addTestStepLog(msg);
       ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(imagePath);

        return imagePath;
    }



}


