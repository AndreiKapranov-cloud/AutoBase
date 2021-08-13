package com.andrei.myapp.model.enums;

public enum UserEnum {
    READY("ready"),ILL("ill"),ONACARGORUN("onacargorun"),DELETED("deleted");
    private String code;

    private UserEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

