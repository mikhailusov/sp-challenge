package com.stormpath.challenge.service.validation.rule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
public class ContainsRuleTest {

    private ContainsRule containsRule;

    @Before
    public void setUp() throws Exception {
        containsRule = new ContainsRule(Pattern.compile("[0-9]"), 2);
    }

    @Test
    public void invalidTest() {
        Assert.assertFalse(containsRule.isValid("a"));
        Assert.assertFalse(containsRule.isValid("abcd"));
        Assert.assertFalse(containsRule.isValid("4"));
        Assert.assertFalse(containsRule.isValid("bafxf5"));
    }

    @Test
    public void validTest() {
        Assert.assertTrue(containsRule.isValid("123"));
        Assert.assertTrue(containsRule.isValid("12"));
        Assert.assertTrue(containsRule.isValid("1sdfasdf3"));
    }
}
