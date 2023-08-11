package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Driver;

public class LoginPage {

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

    public void login_To_The_Application(String userName, String passWord){
        enterUserName.sendKeys(userName);
        enterPassWord.sendKeys(passWord);
        clickOnSubmitButton.click();
    }

    public void verifyErrorMessage(String expectedValue){
      String actualValue=errorMessage.getText();
      Assert.assertEquals(actualValue,expectedValue);

    }

}
