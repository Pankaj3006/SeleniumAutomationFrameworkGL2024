package com.pan.listeners;

import com.pan.utilities.DataProviderUtilities;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setDataProvider("Common DataProvider");
        annotation.setDataProviderClass(DataProviderUtilities.class);
        annotation.setRetryAnalyzer(RetryFailedTests.class);
    }
}
