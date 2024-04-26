package com.pan.enums;

public enum PropertyType {

    ORANGE_HRM_URL("hrm_url"),
    QA_CLICK_URL("qaclick_url"),
    QA_PRACTICE_URL("qapractice_url"),
    GOOGLE_URL("google_url"),
    ORANGE_HRM_USERNAME("hrm_username"),
    ORANGE_HRM_PASSWORD("hrm_password"),
    QA_CLICK_USERNAME("qaclick_username"),
    QA_CLICK_PASSWORD("qaclick_password"),
    PROMO_CODE("promocode"),
    Is_RETRY_REQUIRED("isRetryRequired"),
    BROWSER("browser"),
    RUN_MODE("runmode");

    private String value;

    PropertyType(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
