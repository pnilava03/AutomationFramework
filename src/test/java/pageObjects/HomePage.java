package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.CommonMethods;
import utils.Log;

public class HomePage {


    public HomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "(//tr/td/img)[1]")
    WebElement verifyLogoOnHomePage;


    public void verifyHomePage() throws InterruptedException {
        Log.info("Verifying logo on home page");
        Thread.sleep(6000);
        Assert.assertTrue(verifyLogoOnHomePage.isDisplayed());
        Log.info("Verified logo on home page Successfully");
        //  CommonMethods.takeScreenshot("HomePage");

    }
}
