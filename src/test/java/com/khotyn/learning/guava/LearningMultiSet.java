/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.khotyn.learning.guava;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;

/**
 * MultiSet，用来计数非常不错啊。
 * 
 * @author khotyn.huangt Jan 15, 2013 10:26:35 PM
 */
public class LearningMultiSet {

    private static Multiset<String> multiset = HashMultiset.create();

    static {
        List<String> elements = new ArrayList<String>();
        elements.add("a");
        elements.add("b");
        elements.add("c");
        elements.add("a");
        elements.add("b");
        elements.add("a");
        multiset.addAll(elements);
    }

    @Test
    public void testMultiSetCount() {
        Assert.assertEquals(3, multiset.count("a"));
        Assert.assertEquals(2, multiset.count("b"));
        Assert.assertEquals(1, multiset.count("c"));
    }

    @Test
    public void testIterateOverMultiSet() {
        for (Entry<String> entry : multiset.entrySet()) {
            if (entry.getElement().equals("a")) {
                Assert.assertEquals(3, entry.getCount());
            } else if (entry.getElement().equals("b")) {
                Assert.assertEquals(2, entry.getCount());
            } else if (entry.getElement().equals("c")) {
                Assert.assertEquals(1, entry.getCount());
            }
        }
    }

    @Test
    public void testMultiSetSize() {
        Assert.assertEquals(6, multiset.size());
    }
}
