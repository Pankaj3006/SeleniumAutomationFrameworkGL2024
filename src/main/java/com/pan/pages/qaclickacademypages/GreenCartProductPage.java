package com.pan.pages.qaclickacademypages;

import com.pan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GreenCartProductPage {

private By greenCartLogo = By.xpath("//div[@class='brand greenLogo']");
private By products = By.xpath("//div[@class='product']");
private By searchBox = By.xpath("//input[@class='search-keyword']");
private By productNames = By.xpath("//h4[@class='product-name']");
private By cart = By.xpath("//a[@class='cart-icon']");
private By countOnCart = By.xpath("//tr[1]/td[3]/strong");

	public WebElement getGreenCartLogo() {
		return DriverManager.getDriver().findElement(greenCartLogo);
	}

	public List<WebElement> getProductNames() {
		return DriverManager.getDriver().findElements(productNames);
	}

	public WebElement getSearchBox() {
		return DriverManager.getDriver().findElement(searchBox);
	}

	public List<WebElement> getProducts() {
		return DriverManager.getDriver().findElements(products);
	}

	public WebElement getCart() {
		return DriverManager.getDriver().findElement(cart);
	}

	public WebElement getCountOnCart() {
		return DriverManager.getDriver().findElement(countOnCart);
	}

	public void selectProductByName(String productName)
	{
		for(int i = 1; i<= getProductNames().size(); i++) {
			if(getProductNames().get(i-1).getText().contains(productName))
			{
				DriverManager.getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div["+i+"]/div[3]/button")).click();
				break;
			}
		}
	}
}