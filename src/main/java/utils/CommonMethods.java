package utils;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CommonMethods {

    public static void takeScreenshot(String screenShotName){
        TakesScreenshot screenshot=(TakesScreenshot) Driver.driver;
        File file =screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\reports\\" + screenShotName + ".png"));
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    //this method is use for decode the password, as we will not save the actual password

    public String decodePassword(String password){
        byte[] decodedBytes= Base64.decodeBase64(password);
        return new String(decodedBytes);
    }





}
