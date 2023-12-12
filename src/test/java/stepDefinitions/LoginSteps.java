package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.PropertyConfigurator;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.Log;
import utils.Driver;
import utils.PropertiesFile;

import java.io.IOException;

public class LoginSteps  {


    @io.cucumber.java.en.Given("the application {string}")
    public void theApplication(String url) throws Exception {


        url= PropertiesFile.getProperties("actiTime_URL");
        Log.info("Chrome Browser started");
        Driver.openBrowser("chrome");
        Log.startTestCases("Launch The application URL::"+url);
        Driver.driver.get(url);
    }

    @When("the user enters the credentials {string},{string}")
    public void theUserEntersTheCredentials(String username, String password) throws IOException, InterruptedException {
        LoginPage loginPage= new LoginPage(Driver.driver);
        String UserName=PropertiesFile.getProperties(username);
        String PassWord= PropertiesFile.getProperties(password);
        loginPage.login_To_The_Application(UserName,PassWord);
    }

    @Then("the user should be navigate to the user specific homepage")
    public void theUserShouldBeNavigateToTheUserSpecificHomepage() throws InterruptedException, IOException {
        HomePage homePage= new HomePage(Driver.driver);
        homePage.verifyHomePage();
        Log.endTestCases("application closed");

    }

    @Then("the user close the browser")
    public void theUserCloseTheBrowser() {
        Driver.driver.quit();

    }

    @Then("the user will see error message {string}")
    public void theUserWillSeeErrorMessage(String message) throws InterruptedException, IOException {
        LoginPage loginPage= new LoginPage(Driver.driver);
        loginPage.verifyErrorMessage(message);
        Thread.sleep(5000);
        Log.endTestCases("application closed");


    }
}
