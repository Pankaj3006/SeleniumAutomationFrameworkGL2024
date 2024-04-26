package com.pan.listeners;

import com.pan.customannotations.FrameworkAnnotation;
import com.pan.java8Logging.Java8Logger;
import com.pan.java8Logging.LogType;
import com.pan.reports.ExtentLogger;
import com.pan.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentReport.createTest(result.getMethod().getMethodName());
        if(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class) != null) {
            ExtentReport.assignCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
            ExtentReport.assignAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       // ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed");
        Java8Logger.log(LogType.PASS, result.getMethod().getMethodName() + " is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed", true);
        ExtentLogger.fail(result.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
      //  ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped");
        Java8Logger.log(LogType.SKIP, result.getMethod().getMethodName() + " is Skipped");
    }
}
