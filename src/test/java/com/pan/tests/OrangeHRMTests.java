package com.pan.tests;

import static com.pan.utilities.CommonUtilities.click;
import static com.pan.utilities.CommonUtilities.clearThenInputText;
import static com.pan.utilities.CommonUtilities.isDisplayed;

import com.pan.customannotations.FrameworkAnnotation;
import com.pan.driver.DriverManager;
import com.pan.enums.AuthorType;
import com.pan.enums.CategoryType;
import com.pan.enums.PropertyType;
import com.pan.pages.orangeHRMPages.OrangeHRMHomePage;
import com.pan.pages.orangeHRMPages.OrangeHRMLoginPage;
import com.pan.utilities.PropertyFileReaderUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class OrangeHRMTests extends BaseTest {

    @FrameworkAnnotation(category = {CategoryType.REGRESSION}, author = {AuthorType.INTEGRATIONS})
    @Test
    void validateLogoTest(Map<String, String> map)
    {
        DriverManager.getDriver().get(PropertyFileReaderUtilities.getValue(PropertyType.ORANGE_HRM_URL));
        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();
        Assert.assertTrue(isDisplayed(orangeHRMLoginPage.getImageLogo()));
    }

    //(dataProvider = "Common DataProvider", dataProviderClass = DataProviderUtilities.class, retryAnalyzer = RetryFailedTests.class)
   // @FrameworkAnnotation(category = {CategoryType.DATAPROVIDER}, author = {AuthorType.STRIKERS})
    @Test
    void orangeHRMLoginTest(Map<String, String> map) {
        DriverManager.getDriver().get(PropertyFileReaderUtilities.getValue(PropertyType.ORANGE_HRM_URL));
        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();
        clearThenInputText(orangeHRMLoginPage.getUserName(), map.get("username"), "UserName Field");
        clearThenInputText(orangeHRMLoginPage.getPassword(), map.get("password"), "Password Field");
        click(orangeHRMLoginPage.getLoginButton(), "Login Button");

        OrangeHRMHomePage orangeHRMHomePage = new OrangeHRMHomePage();
        click(orangeHRMHomePage.getLinkPaul(), "Paul Link");
        click(orangeHRMHomePage.getLogoutLink(), "Logout Link");
    }

    @DataProvider(name="LoginTestDataProvider", parallel = true)
    Object[][] getData() {

        return new Object[][] {
                //{"admin", "admin123"},
                 {"admin123", "admin1234"},
                {PropertyFileReaderUtilities.getValue(PropertyType.ORANGE_HRM_USERNAME), PropertyFileReaderUtilities.getValue(PropertyType.ORANGE_HRM_PASSWORD)}
        };
    }
}
