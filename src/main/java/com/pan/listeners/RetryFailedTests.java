package com.pan.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {
    int count =0;
    int retries =1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<retries) {
            count++;
            return true;
        } else {
            return false;
        }
    }
}
