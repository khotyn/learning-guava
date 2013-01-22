package com.khotyn.learning.guava;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * @author khotyn.huangt Jan 21, 2013 8:16:28 PM
 */
public class LearningCharMatcher {

    @Test
    public void testCharMatcher() {
        String result = CharMatcher.JAVA_DIGIT.retainFrom("1234.43534523423");
        Assert.assertEquals("123443534523423", result);
    }
}
