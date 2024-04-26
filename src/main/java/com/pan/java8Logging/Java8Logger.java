package com.pan.java8Logging;

import com.pan.reports.ExtentManager;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

public class Java8Logger {

    private static Consumer<String> PASS = (message) -> ExtentManager.getExtentTest().pass(message);
    private static Consumer<String> FAIL = (message) -> ExtentManager.getExtentTest().fail(message);
    private static Consumer<String> SKIP = (message) -> ExtentManager.getExtentTest().skip(message);

    private static Map<LogType, Consumer<String>> map = new EnumMap<>(LogType.class);

    public static void log(LogType status, String message) {
        map.get(status).accept(message);
    }

    static {
        map.put(LogType.PASS, PASS);
        map.put(LogType.FAIL, FAIL);
        map.put(LogType.SKIP, SKIP);
    }
}
