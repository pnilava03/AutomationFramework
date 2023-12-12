package pageObjects;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Log;
import utils.CommonMethods;
import utils.Reports;

import java.io.IOException;

public class LoginPage {

    CommonMethods commonMethods = new CommonMethods();

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.XPATH, using = "//input[@name='username']")
    WebElement enterUserName;


    @FindBy(how = How.XPATH, using = "//input[@name='pwd']")
    WebElement enterPassWord;

    @FindBy(how = How.ID, using = "loginButton")
    WebElement clickOnSubmitButton;

    @FindBy(how = How.XPATH, using = "(//td/span[@class='errormsg'])[1]")
    WebElement errorMessage;

    public void login_To_The_Application(String userName, String passWord) throws InterruptedException, IOException {
        Log.info("Entering username");
        enterUserName.sendKeys(userName);
        Log.info("Entered username successfully");
        Reports.takeScreenshot("Entered username");
        //decoding password
        Log.info("Entering password");
        String decode_Password = commonMethods.decodePassword(passWord);
        enterPassWord.sendKeys(decode_Password);
        Log.info("Entered password successfully");
        Reports.takeScreenshot("Entered password");

        Thread.sleep(3000);
        Log.info("clicking on Submit button");
        clickOnSubmitButton.click();
        Log.info("clicked on Submit button successfully");
        Reports.takeScreenshot("clicked on Submit button");
    }

    public void verifyErrorMessage(String expectedValue) throws IOException {
        Log.info("Verifying the error message");
        String actualValue = errorMessage.getText();
        Assert.assertEquals(actualValue, expectedValue);
        Log.info("Verified error message successfully");
        Reports.takeScreenshot("Error message verified");

    }

}
