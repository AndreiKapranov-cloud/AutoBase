package com.andrei.myapp.model.enums;

public enum TripEnum {
        WAITING("waiting"),STARTED("started"),STOPPED("stopped"),FINISHED("finished"),
    DELETED("deleted");
        private String code;

        private TripEnum(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

