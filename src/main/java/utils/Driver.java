package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

	public static WebDriver driver;


	public static void openBrowser(String browser) {
		switch(browser) {

		case "chrome":
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			break;

		case "FF":
			driver= new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			break;

			case "Safari":
				driver= new SafariDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				break;

			default:
				driver= new EdgeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();

			}

	}

	public static void closeBrowser(){
		Driver.driver.quit();
	}

}
