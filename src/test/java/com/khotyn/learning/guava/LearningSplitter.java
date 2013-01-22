/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
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
