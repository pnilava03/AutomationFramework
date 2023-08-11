package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class LoginSteps {

    public static Properties prop= new Properties();

    {
        try {
            prop.load(Files.newInputStream(Paths.get("./src/test/resources/config/devtest.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @io.cucumber.java.en.Given("the application {string}")
    public void theApplication(String url) throws Exception {

        url=prop.getProperty("vTiger_URL");
        Driver.openBrowser("chrome");
        Driver.driver.get(url);
    }

    @When("the user enters the credentials {string},{string}")
    public void theUserEntersTheCredentials(String username, String password) throws IOException {
        LoginPage loginPage= new LoginPage(Driver.driver);
        String UserName=prop.getProperty(username);
        System.out.println("application username is: "+UserName);
        String PassWord= prop.getProperty(password);
        System.out.println("application password is: "+PassWord);
        loginPage.login_To_The_Application(UserName,PassWord);
    }

    @Then("the user should be navigate to the user specific homepage")
    public void theUserShouldBeNavigateToTheUserSpecificHomepage() {
        HomePage homePage= new HomePage(Driver.driver);
        homePage.verifyHomePage();

    }

    @Then("the user close the browser")
    public void theUserCloseTheBrowser() {
        Driver.driver.quit();
    }
}
