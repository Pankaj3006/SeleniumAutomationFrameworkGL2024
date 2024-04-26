package com.pan.constants;

public class FrameworkConstants {

    private static final String RESOURCES_PATH = System.getProperty("user.dir")+"/src/test/resources";
    public static final String CHROMEDRIVER_PATH = RESOURCES_PATH + "/executables/chromedriver.exe";
    public static final String GECKODRIVER_PATH = RESOURCES_PATH + "/executables/geckodriver.exe";
    public static final String CONFIG_FILEPATH = RESOURCES_PATH + "/config/config.properties";
    public static final String EXCEL_PATH = RESOURCES_PATH + "/excel/TestData.xlsx";
    public static final String RUNNER_DATA_SHEET_NAME = "Runner Data";
    public static final String DATA_PROVIDER_SHEET_NAME = "DataProvider";
    public static final String JSON_PATH = RESOURCES_PATH + "/jsons/json1.json";
    public static final String REPORT_PATH = "index.html";
}
