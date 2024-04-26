package com.pan.utilities;

import com.pan.constants.FrameworkConstants;
import com.pan.enums.PropertyType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyFileReaderUtilities {

    private static Properties properties = new Properties();
    private static Map map = new HashMap();

    static
    {
        try {
            FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.CONFIG_FILEPATH);
            properties.load(fileInputStream);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        properties.entrySet().forEach(e -> map.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
    }

    public static String getValue(String key)
    {
        return String.valueOf(map.get(key));
    }

    public static String getValue(PropertyType type)
    {
        return String.valueOf(map.get(type.getValue()));
    }
}
