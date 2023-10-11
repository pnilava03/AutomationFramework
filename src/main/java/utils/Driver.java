package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Driver {

    public static WebDriver driver;
    public static void openBrowser(String browser) {

        switch (browser) {

            case "chrome":
                driver = new ChromeDriver();
                Log.info("Chrome driver initialized");
                driver.manage().deleteAllCookies();
                Log.info("Delete All cookies");
                driver.manage().window().maximize();
                Log.info("Maximize Chrome Driver");
                break;

            case "FF":
                driver = new FirefoxDriver();
                Log.info("Firefox driver initialized");
                driver.manage().deleteAllCookies();
                Log.info("Delete All cookies");
                driver.manage().window().maximize();
                Log.info("Maximize Firefox Driver");
                break;

            case "Safari":
                driver = new SafariDriver();
                Log.info("Safari driver initialized");
                driver.manage().deleteAllCookies();
                Log.info("Delete All cookies");
                driver.manage().window().maximize();
                Log.info("Maximize Safari Driver");
                break;

            default:
                driver = new EdgeDriver();
                Log.info("Edge driver initialized");
                driver.manage().deleteAllCookies();
                Log.info("Delete All cookies");
                driver.manage().window().maximize();
                Log.info("Maximize Edge Driver");


        }

    }

    public static void closeBrowser() {

        Driver.driver.quit();
    }

}
