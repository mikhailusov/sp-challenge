package com.stormpath.challenge.service.validation.rule;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
public class LengthRule implements Rule {

    private int min;
    private int max;

    public LengthRule(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isValid(String string) {
        return string != null && string.length() >= min && string.length() <= max;
    }

    public String getMessage() {
        return "Must be between " + min + " and " + max + " characters long";
    }
}
