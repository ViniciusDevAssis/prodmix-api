package com.prodmix.api.controllers.advice.exceptions;


import com.prodmix.api.enums.Errors;

public class StoreEmailNotFoundException extends RuntimeException {

    private final String errorCode;

    public StoreEmailNotFoundException(Errors error, Object...args) {
        super(error.formatMessage(args));
        this.errorCode = error.getCode();
    }

    public String getErrorCode() { return errorCode; }
}
