package com.khotyn.learning.guava;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Joiner;

/**
 * String Join
 *
 * @author khotyn.huangt Jan 21, 2013 8:04:37 PM
 */
public class LearningJoiner {

    @Test
    public void testJoiner() {
        String result = Joiner.on(", ").skipNulls().join(new String[]{"Hello", "World", "Hell"});
        Assert.assertEquals("Hello, World, Hell", result);
    }
}
