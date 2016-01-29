package com.stormpath.challenge.service.validation.rule

import com.stormpath.challenge.service.validation.rule.AllowedCharactersRule
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
class AllowedCharactersRuleTest {

    private AllowedCharactersRule allowedCharactersRule;

    @Before
    public void setUp() throws Exception {
        allowedCharactersRule = new AllowedCharactersRule();
    }

    @Test
    void testIsValid() {
        Assert.assertFalse(allowedCharactersRule.isValid(""));
    }

    @Test
    void testGetMessage() {
        Assert.assertNotNull(allowedCharactersRule.getMessage());
    }
}
