package com.prodmix.api.enums;

public enum Errors {

    // PSE1XX for store entity errors
    PSE101("PSE101", "No Store found with the given id"),
    PSE102("PSE102", "No Store found with the given email"),

    // PPE2XX for product entity errors
    PPE201("PPE201", "No Product found with the given description");

    private final String code;
    private final String message;

    Errors(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String formatMessage(Object... args) {
        return String.format(message, args);
    }
}
