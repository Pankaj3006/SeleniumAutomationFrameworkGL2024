package com.pan.pages.qaclickacademypages;

import com.pan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderPage {

private By NumberOfRows = By.xpath("//*[@id='productCartTables']/tbody/tr");
private By placeOrder = By.xpath("//button[text()='Place Order']");
private By promoCodeTextBox = By.cssSelector(".promoCode");
private By promoCodeApplyButton = By.cssSelector(".promoBtn");
private By codeApplied = By.xpath("//span[@class='promoInfo']");

	public List<WebElement> getNumberOfRows() {
		return DriverManager.getDriver().findElements(NumberOfRows);
	}

	public WebElement getPlaceOrder() {
		return DriverManager.getDriver().findElement(placeOrder);
	}

	public WebElement getPromoCodeTextBox() {
		return DriverManager.getDriver().findElement(promoCodeTextBox);
	}

	public WebElement getPromoCodeApplyButton() {
		return DriverManager.getDriver().findElement(promoCodeApplyButton);
	}

	public WebElement getCodeApplied() {
		return DriverManager.getDriver().findElement(codeApplied);
	}

	public List<String> getListOfOrderProducts() {
		List<String> listOFAddedItems = new ArrayList<String>();
		for(int i = 1; i<= getNumberOfRows().size(); i++){
			String item=DriverManager.getDriver().findElement(By.xpath("//*[@id='productCartTables']/tbody/tr["+i+"]/td[2]")).getText().split("-")[0].trim();
			listOFAddedItems.add(item);
		}
		return listOFAddedItems;
	}
}
