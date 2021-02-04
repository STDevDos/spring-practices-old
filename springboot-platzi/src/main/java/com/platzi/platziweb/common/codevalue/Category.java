package com.platzi.platziweb.common.codevalue;

public enum Category {

    SPORT("S", "Sport"), //
    MUSIC("M", "Music"), //
    TECHNOLOGY("T", "Technology");

    private String code;
    private String value;

    Category(String code, String Value) {
        this.code = code;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

}
