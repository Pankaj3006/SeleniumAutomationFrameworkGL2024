package com.pan.utilities;

import com.pan.driver.DriverManager;
import com.pan.java8Logging.Java8Logger;
import com.pan.java8Logging.LogType;
import com.pan.reports.ExtentLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonUtilities {
	
	public static void click(WebElement element, String elementName) {
        WaitUtilities.waitForClickabilityOf(element).click();
        //ExtentLogger.pass(elementName + " is Clicked");
        Java8Logger.log(LogType.PASS, elementName + " is Clicked");
    }

    public static void clearThenInputText(WebElement element, String text, String elementName) {
        element = WaitUtilities.waitForClickabilityOf(element);
        element.clear();
        element.sendKeys(text);
        //ExtentLogger.pass(text + " has been Entered in " + elementName);
        Java8Logger.log(LogType.PASS, text + " has been Entered in " + elementName);
    }

    public static boolean isDisplayed(WebElement element)
    {
       return WaitUtilities.waitForVisibilityOfElement(element).isDisplayed();
    }

    public static String getText(WebElement element) {

        return WaitUtilities.waitForVisibilityOfElement(element).getText();
    }

    public static void clickWithJS(WebElement element, String elementName) {
        //ExtentLogger.pass(elementName + " is Clicked");
        Java8Logger.log(LogType.PASS, elementName + " is Clicked");
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static void selectElement(WebElement element, String text, String elementName) {
        ExtentLogger.pass(text + "has been selected in given " + elementName);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    private static WebDriver getDriver()
    {
        return DriverManager.getDriver();
    }
}
