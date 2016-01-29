package com.stormpath.challenge.service.validation.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
public class ContainsRule implements Rule {

    private Pattern pattern;
    private int count;

    public ContainsRule(Pattern pattern, int count) {
        this.pattern = pattern;
        this.count = count;
    }

//    public ContainsRule(String string, int count) {
//
//    }
//
//    public ContainsRule(char character, int count) {
//
//    }

    @Override
    public boolean isValid(String string) {
        Matcher matcher = pattern.matcher(string);
        int c = 0;
        while(matcher.find()) {
            c++;
            if(c >= count)
                return true;
        }
        return false;
    }

    @Override
    public String getMessage() {
        return "Must contain at least " + count + " character(s) from " + pattern.toString();
    }
}
