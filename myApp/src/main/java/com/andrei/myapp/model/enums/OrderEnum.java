package com.andrei.myapp.model.enums;

public enum OrderEnum {
    FRESH("fresh"), INPROCESS("inprocess"),DONE("done"),DELETED("deleted");
    private String code;

    private OrderEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
