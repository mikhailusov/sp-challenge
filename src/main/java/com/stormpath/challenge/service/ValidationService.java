package com.stormpath.challenge.service;

import com.stormpath.challenge.service.validation.rule.Rule;

import java.util.List;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
public interface ValidationService {

    List<ValidationError> validate(String string);

    void setRules(List<Rule> rules);

    void addRule(Rule rule);
}
