package com.stormpath.challenge.service.validation.rule;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
public interface Rule {

    boolean isValid(String string);

    String getMessage();
}
