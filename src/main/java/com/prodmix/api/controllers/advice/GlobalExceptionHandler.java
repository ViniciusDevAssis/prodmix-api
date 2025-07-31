package com.prodmix.api.controllers.advice;

import com.prodmix.api.controllers.advice.exceptions.StoreEmailNotFoundException;
import com.prodmix.api.controllers.advice.exceptions.StoreIdNotFoundException;
import com.prodmix.api.controllers.advice.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StoreIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStoreIdNotFoundException(
            StoreIdNotFoundException ex,
            WebRequest request
    ) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                ex.getErrorCode(),
                null
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StoreEmailNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStoreEmailNotFoundException(
            StoreIdNotFoundException ex,
            WebRequest request
    ) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                ex.getErrorCode(),
                null
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
