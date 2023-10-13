package utils;


import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.Scenario;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CommonMethods {





    //this method is use for decode the password, as we will not save the actual password

    public String decodePassword(String password){
        byte[] decodedBytes= Base64.decodeBase64(password);
        return new String(decodedBytes);
    }





}
