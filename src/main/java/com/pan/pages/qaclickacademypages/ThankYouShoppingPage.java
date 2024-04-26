package com.pan.pages.qaclickacademypages;

import com.pan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ThankYouShoppingPage {

	private By thankYouMessage = By.xpath("//*[text()='Thank you, your order has been placed successfully ']");
	
	public WebElement getThankYouMessage() { return DriverManager.getDriver().findElement(thankYouMessage); }
}
