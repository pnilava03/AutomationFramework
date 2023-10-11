package Test;

import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {



    public static void main (String [] args) throws InterruptedException, MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Emulator_Nilu");
        options.setCapability("browserName","Chrome");
        options.setChromedriverExecutable(System.getProperty("user.dir")+"\\src\\test\\resources\\libs\\chromedriver.exe");
        AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
//        WebDriver driver= new ChromeDriver();
        driver.get("https://www.apple.com/");
        Thread.sleep(8000);
        driver.findElement(AppiumBy.cssSelector("button#globalnav-menutrigger-button")).click();
       // driver.findElement(AppiumBy.cssSelector("span.globalnav-link-text-container")).click();
        driver.findElement(AppiumBy.cssSelector("#globalnav-list > li.globalnav-item.globalnav-menu.globalnav-item-flyout-open > div > div > div.globalnav-item.globalnav-item-mac.globalnav-item-menu.globalnav-item-submenu > ul > li:nth-child(1) > a")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.cssSelector("#globalnav-submenu-link-mac > div > div > div.globalnav-submenu-group.globalnav-submenu-group-elevated > ul > li:nth-child(1) > a")).click();
        driver.quit();



    }
}
