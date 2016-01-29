package com.stormpath.challenge.service.validation;

import com.stormpath.challenge.service.ValidationError;
import com.stormpath.challenge.service.ValidationService;
import com.stormpath.challenge.service.validation.rule.Rule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
@Service
public class PasswordValidationService implements ValidationService {

    private List<Rule> rules = new ArrayList<>();

    @Override
    public List<ValidationError> validate(String password) {
        List<ValidationError> errors = new ArrayList<>();

        for(Rule rule: rules) {
            if(!rule.isValid(password))
                errors.add(new ValidationError(rule.getMessage()));
        }

        return errors;
    }

    @Override
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public void addRule(Rule rule) {
        rules.add(rule);
    }
}
