package com.stormpath.challenge.service.validation.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
public class RepeatedSequenceRule implements Rule {

    public RepeatedSequenceRule() {
    }

    @Override
    public boolean isValid(String string) {
        Pattern p = Pattern.compile("(\\S{2,})\\1+");
        Matcher m = p.matcher(string);
        while(m.find()) {
            return false;
        }

        return true;
    }

    @Override
    public String getMessage() {
        return "Must not contain any sequence of characters immediately followed by the same sequence";
    }
}
