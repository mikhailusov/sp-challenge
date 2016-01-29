package com.stormpath.challenge;

import com.stormpath.challenge.service.validation.PasswordValidationService;
import com.stormpath.challenge.service.validation.rule.AllowedCharactersRule;
import com.stormpath.challenge.service.validation.rule.ContainsRule;
import com.stormpath.challenge.service.validation.rule.LengthRule;
import com.stormpath.challenge.service.validation.rule.RepeatedSequenceRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.regex.Pattern;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PasswordValidationService passwordValidationService() {
        PasswordValidationService p = new PasswordValidationService();

        // Adding rules
        // Must consist of a mixture of lowercase letters and numerical digits only
        p.addRule(new AllowedCharactersRule(Pattern.compile("[a-z0-9]")));

        // with at least one of each.
        p.addRule(new ContainsRule(Pattern.compile("[a-z]"), 1));
        p.addRule(new ContainsRule(Pattern.compile("[0-9]"), 1));

        // Must be between 5 and 12 characters in length.
        p.addRule(new LengthRule(5, 12));

        // Must not contain any sequence of characters immediately followed by the same sequence.
        p.addRule(new RepeatedSequenceRule());

        return p;
    }
}
