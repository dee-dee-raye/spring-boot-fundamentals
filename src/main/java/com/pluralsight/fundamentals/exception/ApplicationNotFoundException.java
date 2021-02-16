package com.pluralsight.fundamentals.exception;

import com.pluralsight.fundamentals.entity.Application;

public class ApplicationNotFoundException extends RuntimeException {

    public ApplicationNotFoundException(String exception) {
        super(exception);
    }
}
