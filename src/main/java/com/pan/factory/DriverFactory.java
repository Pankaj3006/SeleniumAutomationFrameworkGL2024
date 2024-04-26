package com.pan.factory;

import com.pan.enums.PropertyType;
import com.pan.utilities.PropertyFileReaderUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver getData(String browser) throws MalformedURLException {

        WebDriver driver;
        String runmode = PropertyFileReaderUtilities.getValue(PropertyType.RUN_MODE);

        if (browser.equalsIgnoreCase("chrome")) {
            if (runmode.equalsIgnoreCase("Remote")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "chrome");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } else {
                //System.setProperty("webdriver.chrome.driver", FrameworkConstants.CHROMEDRIVER_PATH);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        } else {
            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "firefox");
                driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities);
            } else {
                // System.setProperty("webdriver.gecko.driver", FrameworkConstants.GECKODRIVER_PATH);
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }
}
