package com.pan.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pan.constants.FrameworkConstants;
import com.pan.enums.AuthorType;
import com.pan.enums.CategoryType;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {

    private static ExtentReports extent;

    public static void initReports() {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.REPORT_PATH);
            extent.attachReporter(spark);

            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Selenium Framework Report");
            spark.config().setReportName("Test Cases Report");
        }
    }

    public static void flushReports() {
        if(Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unlaod();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.REPORT_PATH).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testCaseName)
    {
        ExtentTest test = extent.createTest(testCaseName);
        ExtentManager.setExtTest(test);
    }

    public static void assignCategory(CategoryType[] categories)
    {
        for(CategoryType category: categories) {
            ExtentManager.getExtentTest().assignCategory(category.name());
        }
    }

    public static void assignAuthor(AuthorType[] authors)
    {
        for(AuthorType author: authors) {
            ExtentManager.getExtentTest().assignAuthor(author.name());
        }
    }
}
