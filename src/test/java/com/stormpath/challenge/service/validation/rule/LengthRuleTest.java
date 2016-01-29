package com.stormpath.challenge.service.validation.rule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
public class LengthRuleTest {

    private LengthRule lengthRule;

    @Before
    public void setUp() throws Exception {
        lengthRule = new LengthRule(1, 10);
    }

    @Test
    public void invalidTest() {
        Assert.assertFalse(lengthRule.isValid(""));
        Assert.assertFalse(lengthRule.isValid("123123123123123123"));
        Assert.assertFalse(lengthRule.isValid("01234567899"));
        Assert.assertFalse(lengthRule.isValid("abcabcabcabfdrgfd"));
    }

    @Test
    public void validTest() {
        Assert.assertTrue(lengthRule.isValid("12"));
        Assert.assertTrue(lengthRule.isValid("1234567890"));
        Assert.assertTrue(lengthRule.isValid("abc123"));
        Assert.assertTrue(lengthRule.isValid("a"));
        Assert.assertTrue(lengthRule.isValid("1"));
    }
}
