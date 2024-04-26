package com.pan.tests;

import static com.pan.utilities.CommonUtilities.click;
import static com.pan.utilities.CommonUtilities.clickWithJS;
import static com.pan.utilities.CommonUtilities.clearThenInputText;
import static com.pan.utilities.CommonUtilities.getText;
import static com.pan.utilities.CommonUtilities.selectElement;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static com.pan.utilities.WaitUtilities.unConditionalWait;

import com.pan.customannotations.FrameworkAnnotation;
import com.pan.driver.DriverManager;
import com.pan.enums.AuthorType;
import com.pan.enums.CategoryType;
import com.pan.enums.PropertyType;
import com.pan.listeners.RetryFailedTests;
import com.pan.pages.qaclickacademypages.HomePage;
import com.pan.pages.qaclickacademypages.RegisterPage;
import com.pan.pages.qaclickacademypages.AutomationPage;
import com.pan.pages.qaclickacademypages.GreenCartProductPage;
import com.pan.pages.qaclickacademypages.CartPage;
import com.pan.pages.qaclickacademypages.PlaceOrderPage;
import com.pan.pages.qaclickacademypages.ProceedPage;
import com.pan.pages.qaclickacademypages.ThankYouShoppingPage;
import com.pan.utilities.DataProviderUtilities;
import com.pan.utilities.PropertyFileReaderUtilities;
import com.pan.utils.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class QaClickAcademyTests extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    AutomationPage automationPage;
    GreenCartProductPage greenCartProductPage;
    CartPage cartPage;
    PlaceOrderPage placeOrderPage;
    ProceedPage proceedPage;
    ThankYouShoppingPage thankYouShoppingPage;

    //(dataProvider = "Common DataProvider", dataProviderClass = DataProviderUtilities.class, retryAnalyzer = RetryFailedTests.class)
    //@FrameworkAnnotation(category = {CategoryType.DATAPROVIDER}, author = {AuthorType.INTEGRATIONS})
    @Test
    void qaClickLoginTest(Map<String, String> map)
    {
        homePage = new HomePage();
        DriverManager.getDriver().get(PropertyFileReaderUtilities.getValue(PropertyType.QA_CLICK_URL));
        click(homePage.getPracticeLink(), "Practice Link");
        registerPage = new RegisterPage();
        getText(registerPage.getRegisterPageText());
        Assert.assertEquals(getText(registerPage.getRegisterPageText()), Constant.REGISTER_PAGE_TEXT);
//        clearThenInputText(registerPage.getUsername(), PropertyFileReaderUtilities.getValue(PropertyType.QA_CLICK_USERNAME),
//                "UserName TextBox");
//        clearThenInputText(registerPage.getUserEmail(), PropertyFileReaderUtilities.getValue(PropertyType.QA_CLICK_PASSWORD),
//                "UserEmail TextBox");
        clearThenInputText(registerPage.getUsername(), map.get("username"), "UserName TextBox");
        clearThenInputText(registerPage.getUserEmail(), map.get("password"), "UserEmail TextBox");
        click(registerPage.getCheckbox(), "CheckBox");
        click(registerPage.getSubmitButton(), "Submit Button");
        automationPage = new AutomationPage();
        Assert.assertEquals(getText(automationPage.getOurProjectText()), Constant.AUTOMATION_PAGE_TITLE);
        clickWithJS(automationPage.getAutomationPracticeLink(), "Automation Practice Link");
        Assert.assertEquals(DriverManager.getDriver().getTitle(), Constant.GREEN_CART_PAGE_TITLE);
    }

    @FrameworkAnnotation(category = {CategoryType.REGRESSION}, author = {AuthorType.STRIKERS})
    @Test
    void fullFlowTest(Map<String, String> map)
    {
        DriverManager.getDriver().get(PropertyFileReaderUtilities.getValue(PropertyType.QA_PRACTICE_URL));
        greenCartProductPage = new GreenCartProductPage();
        List<String> listOFItemsNeedToAdd = new ArrayList(Arrays.asList("Tomato", "Potato", "Onion", "Pomegranate", "Almonds"));
        for (int i=0; i<listOFItemsNeedToAdd.size(); i++) {
            greenCartProductPage.selectProductByName(listOFItemsNeedToAdd.get(i));
        }
        click(greenCartProductPage.getCart(), "Cart Link");
        cartPage = new CartPage();
        click(cartPage.getProceedToCheckOut(), "Checkout Link");
        placeOrderPage = new PlaceOrderPage();
        unConditionalWait(2000);
        List<String> listOfOrderItems = placeOrderPage.getListOfOrderProducts();
        Assert.assertTrue(listOfOrderItems.containsAll(listOFItemsNeedToAdd));
        clearThenInputText(placeOrderPage.getPromoCodeTextBox(), PropertyFileReaderUtilities.getValue(PropertyType.PROMO_CODE),
                "PromoCode TextBox");
        click(placeOrderPage.getPromoCodeApplyButton(), "Apply Button");
        click(placeOrderPage.getPlaceOrder(), "Place Order Link");
        proceedPage = new ProceedPage();
        Assert.assertEquals(getText(proceedPage.getChooseCountry()), Constant.COUNTRY_CHOOSE);
        selectElement(proceedPage.getCountryDropdown(), "India", "Country DropDown");
        click(proceedPage.getTermAndConditionCheckBox(), "Terms and Condition CheckBox Link");
        click(proceedPage.getProceedButton(), "Proceed Button");
        thankYouShoppingPage = new ThankYouShoppingPage();
        String successMessage = getText(thankYouShoppingPage.getThankYouMessage());
        assertThat(successMessage, containsString(Constant.SUCCESSFUL_MESSAGE));
    }
}
