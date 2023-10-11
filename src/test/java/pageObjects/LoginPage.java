package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Log;
import utils.CommonMethods;
import utils.Reports;

public class LoginPage{

    CommonMethods commonMethods= new CommonMethods();
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    @FindBy(how= How.XPATH, using="//input[@name='user_name']")
    WebElement enterUserName;


    @FindBy(how=How.XPATH,using="//input[@name='user_password']")
    WebElement enterPassWord;

    @FindBy(how=How.ID,using="submitButton")
    WebElement clickOnSubmitButton;

    @FindBy(how=How.XPATH, using = "//div[@class='errorMessage']")
    WebElement errorMessage;

    public void login_To_The_Application(String userName, String passWord) throws InterruptedException {
        Log.info("Entering username");
        enterUserName.sendKeys(userName);
        CommonMethods.takeScreenshot("username");
        Log.info("Entered username successfully");
        //decoding password
        Log.info("Entering password");
        String decode_Password=commonMethods.decodePassword(passWord);
        enterPassWord.sendKeys(decode_Password);
        CommonMethods.takeScreenshot("password");
        Log.info("Entered password successfully");
        Thread.sleep(3000);
        Log.info("clicking on Submit button");
        clickOnSubmitButton.click();
        Log.info("clicked on Submit button successfully");
        CommonMethods.takeScreenshot("submitButton");
    }

    public void verifyErrorMessage(String expectedValue){
        Log.info("Verifying the error message");
      String actualValue=errorMessage.getText();
      Assert.assertEquals(actualValue,expectedValue);
        Log.info("Verified error message successfully");
        CommonMethods.takeScreenshot("errMsg");

    }

}
