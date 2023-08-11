package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
       }

       @FindBy(how = How.XPATH, using = "(//tr/td/img)[1]")
        WebElement verifyLogoOnHomePage;


    public void verifyHomePage(){
        System.out.println("Verify logo on home page");
        Assert.assertTrue(verifyLogoOnHomePage.isDisplayed());

    }
}
