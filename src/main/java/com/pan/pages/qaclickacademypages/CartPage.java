package com.pan.pages.qaclickacademypages;

import com.pan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

	private By multipleCartProduct = By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li/div[1]/p[1]");

	private By proceedToCheckOut = By.xpath("//button[text()='PROCEED TO CHECKOUT']");

	public List<WebElement> getMultipleCartProduct() { return DriverManager.getDriver().findElements(multipleCartProduct); }

	public WebElement getProceedToCheckOut() { return DriverManager.getDriver().findElement(proceedToCheckOut); }
}
