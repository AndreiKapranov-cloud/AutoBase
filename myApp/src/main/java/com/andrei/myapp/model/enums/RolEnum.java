package com.andrei.myapp.model.enums;

public enum RolEnum {
    DRIVER("driver"), DISPATCHER("dispatcher"), ADMIN("admin");
    private String code;

    private RolEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
