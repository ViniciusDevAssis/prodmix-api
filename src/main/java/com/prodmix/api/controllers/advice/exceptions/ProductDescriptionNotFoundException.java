package com.prodmix.api.controllers.advice.exceptions;


import com.prodmix.api.enums.Errors;

public class ProductDescriptionNotFoundException extends RuntimeException {

    private final String errorCode;

    public ProductDescriptionNotFoundException(Errors error, Object...args) {
        super(error.formatMessage(args));
        this.errorCode = error.getCode();
    }

    public String getErrorCode() { return errorCode; }
}
