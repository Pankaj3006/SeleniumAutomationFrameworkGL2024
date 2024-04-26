package com.pan.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.pan.utilities.ScreenshotsUtilities;

public class ExtentLogger {

    public static void pass(String message)
    {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message)
    {
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip(String message)
    {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void fail(String message, boolean flag)
    {
        if(flag) {
            ExtentManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtilities.captureScreenshots()).build());
        } else {
            fail(message);
        }
    }
}
