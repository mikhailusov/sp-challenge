package com.stormpath.challenge.service;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
public class ValidationError {

    private String message;

    public ValidationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
