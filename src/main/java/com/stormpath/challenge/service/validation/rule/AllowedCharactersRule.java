package com.stormpath.challenge.service.validation.rule;

import java.util.regex.Pattern;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
public class AllowedCharactersRule implements Rule {

    private Pattern pattern;

    public AllowedCharactersRule(Pattern pattern) {
        this.pattern = pattern;
    }

//    public AllowedCharactersRule(String alowedChars) {
//
//    }
//
//    public AllowedCharactersRule(char[] allowedChars) {
//
//    }

    @Override
    public boolean isValid(String string) {
        return Pattern.compile(pattern.toString()+"*").matcher(string).matches();
    }

    @Override
    public String getMessage() {
        return "Can contain only allowed characters: " + pattern.toString();
    }
}
