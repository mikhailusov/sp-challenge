package com.stormpath.challenge.service.validation.rule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mikhail Usov<usov.me@gmail.com> on 1/29/16.
 */
public class RepeatedSequenceTest {

    private RepeatedSequenceRule repeatedSequenceRule;

    @Before
    public void setUp() throws Exception {
        repeatedSequenceRule = new RepeatedSequenceRule();
    }

    @Test
    public void invalidTest() {
        Assert.assertFalse(repeatedSequenceRule.isValid("qweqwe"));
        Assert.assertFalse(repeatedSequenceRule.isValid("abab"));
        Assert.assertFalse(repeatedSequenceRule.isValid("1111"));
        Assert.assertFalse(repeatedSequenceRule.isValid("aBabAbAbAb"));
    }

    @Test
    public void validTest() {
        Assert.assertTrue(repeatedSequenceRule.isValid("aa"));
        Assert.assertTrue(repeatedSequenceRule.isValid("qwe"));
        Assert.assertTrue(repeatedSequenceRule.isValid("abcba"));
        Assert.assertTrue(repeatedSequenceRule.isValid("12321"));
    }
}
