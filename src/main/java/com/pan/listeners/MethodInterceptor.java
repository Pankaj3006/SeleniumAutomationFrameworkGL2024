package com.pan.listeners;

import com.pan.constants.FrameworkConstants;
import com.pan.utilities.ExcelReaderUtilities;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {

        List<IMethodInstance> finalList = new ArrayList<>();
        List<Map<String, String>> results = ExcelReaderUtilities.readExcelData(FrameworkConstants.RUNNER_DATA_SHEET_NAME);

        for(int i=0; i< list.size(); i++) {
            for(int j=0; j< results.size(); j++) {
                if(list.get(i).getMethod().getMethodName().equalsIgnoreCase(results.get(j).get("TestName"))) {
                    if(results.get(j).get("execute").equalsIgnoreCase("yes")) {
                        list.get(i).getMethod().setInvocationCount(Integer.parseInt(results.get(j).get("count")));
                        list.get(i).getMethod().setPriority(Integer.parseInt(results.get(j).get("priority")));
                        finalList.add(list.get(i));
                    }
                }
            }
        }
        return finalList;
    }
}
