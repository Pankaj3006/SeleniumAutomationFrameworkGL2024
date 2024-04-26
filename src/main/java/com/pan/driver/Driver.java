package com.pan.driver;

import com.pan.factory.DriverFactory;
import org.openqa.selenium.WebDriver;


import java.net.MalformedURLException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static void initDriver(String browser) {

        WebDriver driver = null;
        //String browser = PropertyFileReaderUtilities.getValue(PropertyType.BROWSER);
        if(Objects.isNull(DriverManager.getDriver())) {
            try {
                driver = DriverFactory.getData(browser);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public static void quitDriver()
    {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
