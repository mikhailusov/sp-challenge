package com.stormpath.challenge.controller;

import com.stormpath.challenge.service.ValidationError;
import com.stormpath.challenge.service.validation.PasswordValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
@RestController
public class PasswordValidationController {

    @Autowired
    PasswordValidationService passwordValidationService;

    @RequestMapping(value="/validate/password",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity validatePassword(@RequestParam("password") String password) {

        List<ValidationError> errorList = passwordValidationService.validate(password);
        return (errorList.isEmpty()) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().body(errorList);
    }
}
