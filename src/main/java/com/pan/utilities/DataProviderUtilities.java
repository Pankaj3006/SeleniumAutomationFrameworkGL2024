package com.pan.utilities;

import com.pan.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class DataProviderUtilities {

    @DataProvider(name = "Common DataProvider")
    public static Object[] getData(Method m)
    {
        String testName = m.getName();

        List<Map<String, String>> list = ExcelReaderUtilities.readExcelData(FrameworkConstants.DATA_PROVIDER_SHEET_NAME);
        List<Map<String, String>> finalList = new ArrayList<>();

        Predicate<Map<String, String>> ifTestCaseNameNotMatching = Map -> !Map.get("TestName").equalsIgnoreCase(testName);
        Predicate<Map<String, String>> ifTestCaseExecutionIsNo = Map -> Map.get("execute").equalsIgnoreCase("No");

        list.removeIf(ifTestCaseNameNotMatching);
        list.removeIf(ifTestCaseExecutionIsNo);

        return list.toArray();


//        for(int i=0; i< list.size(); i++) {
//            if(list.get(i).get("TestName").equalsIgnoreCase(testName)) {
//                if(list.get(i).get("execute").equalsIgnoreCase("yes")) {
//                    finalList.add(list.get(i));
//                }
//            }
//        }
//        return finalList.toArray();
    }
}
