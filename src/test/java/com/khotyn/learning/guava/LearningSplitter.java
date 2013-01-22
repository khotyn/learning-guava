package com.khotyn.learning.guava;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Splitter;

/**
 * Splitter
 * 
 * @author khotyn.huangt Jan 21, 2013 8:07:12 PM
 */
public class LearningSplitter {

    @Test
    public void testSplitter() {
        Iterable<String> result = Splitter.on(",").omitEmptyStrings().trimResults().split("a,,b,c,,   d,,,,,      e,,,,,");
        char ch = 'a';

        for (String str : result) {
            Assert.assertEquals(String.valueOf(ch), str);
            ch += 1;
        }
    }
}
