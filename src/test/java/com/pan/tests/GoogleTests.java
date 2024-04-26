package com.pan.tests;

import com.pan.driver.DriverManager;
import com.pan.enums.PropertyType;
import com.pan.utilities.PropertyFileReaderUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTests extends BaseTest {

    @Test
    void googleLoginTest() {
        DriverManager.getDriver().get(PropertyFileReaderUtilities.getValue(PropertyType.GOOGLE_URL));
        String expectedTitle = "Google";
        Assert.assertEquals(DriverManager.getDriver().getTitle(), expectedTitle);
    }
}
