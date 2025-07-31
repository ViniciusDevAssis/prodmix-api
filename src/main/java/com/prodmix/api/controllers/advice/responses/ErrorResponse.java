package com.prodmix.api.controllers.advice.responses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class ErrorResponse {

    private final int httpCode;
    private final String message;
    private final String internalCode;
    private final List<FieldErrorResponse> errors;
}
