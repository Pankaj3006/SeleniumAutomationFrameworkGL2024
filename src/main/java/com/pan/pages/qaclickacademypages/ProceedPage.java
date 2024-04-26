package com.pan.pages.qaclickacademypages;

import com.pan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProceedPage {

	private By chooseCountry = By.xpath("//label[text()='Choose Country']");
	private By countryDropdown = By.xpath("//select[@style='width: 200px;']");
	private By termAndConditionCheckBox = By.xpath("//input[@type='checkbox']");
	private By proceedButton = By.xpath("//button[text()='Proceed']");

	public WebElement getChooseCountry() {
		return DriverManager.getDriver().findElement(chooseCountry);
	}

	public WebElement getCountryDropdown() { return DriverManager.getDriver().findElement(countryDropdown); }

	public WebElement getTermAndConditionCheckBox() { return DriverManager.getDriver().findElement(termAndConditionCheckBox); }

	public WebElement getProceedButton() { return DriverManager.getDriver().findElement(proceedButton); }
}
