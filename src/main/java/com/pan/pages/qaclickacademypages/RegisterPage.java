package com.pan.pages.qaclickacademypages;

import com.pan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {

private By registerPageText = By.xpath("//*[text()='Join now to Practice']");
private By username = By.xpath("//input[@id='name']");
private By userEmail = By.xpath("//input[@id='email']");
private By checkbox = By.xpath("//input[@type='checkbox']");
private By submitButton = By.xpath("//button[@id='form-submit']");

	public WebElement getRegisterPageText() {
		return DriverManager.getDriver().findElement(registerPageText);
	}

	public WebElement getUsername() { return DriverManager.getDriver().findElement(username); }

	public WebElement getUserEmail() {
		return DriverManager.getDriver().findElement(userEmail);
	}

	public WebElement getCheckbox() { return DriverManager.getDriver().findElement(checkbox); }

	public WebElement getSubmitButton() {
		return DriverManager.getDriver().findElement(submitButton);
	}
}
