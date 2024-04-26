package com.pan.pages.qaclickacademypages;

import com.pan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

private By practiceLink = By.xpath("//ul/li[7]/a[text()='Practice']");

	public WebElement getPracticeLink() { return DriverManager.getDriver().findElement(practiceLink); }
}