package com.prodmix.api.controllers.advice.exceptions;


import com.prodmix.api.enums.Errors;

public class StoreIdNotFoundException extends RuntimeException {

    private final String errorCode;

    public StoreIdNotFoundException(Errors error, Object...args) {
        super(error.formatMessage(args));
        this.errorCode = error.getCode();
    }

    public String getErrorCode() { return errorCode; }
}
