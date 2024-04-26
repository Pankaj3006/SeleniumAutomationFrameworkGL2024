package com.pan.pages.qaclickacademypages;

import com.pan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AutomationPage {
	private By ourProjectText = By.xpath("//h5[text()='OUR PROJECTS']");

	private By automationPracticeLink = By.xpath("//*[@id='project-container']/div/div[1]/a[1]");

	public WebElement getOurProjectText() { return DriverManager.getDriver().findElement(ourProjectText); }

	public WebElement getAutomationPracticeLink() { return DriverManager.getDriver().findElement(automationPracticeLink); }
	}

	



