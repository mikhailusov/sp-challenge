package com.stormpath.challenge.service.validation.rule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
public class AllowedCharactersRuleTest {

    private AllowedCharactersRule allowedCharactersRule;

    @Before
    public void setUp() throws Exception {
        allowedCharactersRule = new AllowedCharactersRule(Pattern.compile("[a-z]"));
    }

    @Test
    public void validTest() {
        Assert.assertTrue(allowedCharactersRule.isValid(""));
        Assert.assertTrue(allowedCharactersRule.isValid("abc"));
        Assert.assertTrue(allowedCharactersRule.isValid("a"));
        Assert.assertTrue(allowedCharactersRule.isValid("azbdbcgdfgsgfdgsdfg"));
    }

    @Test
    public void invalidTest() {
        Assert.assertFalse(allowedCharactersRule.isValid("123"));
        Assert.assertFalse(allowedCharactersRule.isValid("dsfgsd3"));
        Assert.assertFalse(allowedCharactersRule.isValid("12dfgsdD3"));
        Assert.assertFalse(allowedCharactersRule.isValid("A"));
        Assert.assertFalse(allowedCharactersRule.isValid("-___"));
    }
}
