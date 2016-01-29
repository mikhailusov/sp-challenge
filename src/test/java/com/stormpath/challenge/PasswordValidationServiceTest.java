package com.stormpath.challenge;

import com.stormpath.challenge.service.validation.PasswordValidationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PasswordValidationServiceTest {

    @Autowired
    PasswordValidationService passwordValidationService;

    @Test
    public void serviceValidTest() {
        Assert.assertEquals(0, passwordValidationService.validate("f48sf4bs").size());
    }

    @Test
    public void serviceInvalidTest() {
        Assert.assertEquals(1, passwordValidationService.validate("f4sd").size());
    }

    @Test
    public void serviceAllErrorsTest() {
        Assert.assertEquals(3, passwordValidationService.validate("abab.").size());
    }
}
