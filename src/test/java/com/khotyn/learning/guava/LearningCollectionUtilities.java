/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.khotyn.learning.guava;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * ºØ∫œ∏®÷˙¿‡
 * 
 * @author khotyn.huangt Jan 16, 2013 10:44:27 PM
 */
public class LearningCollectionUtilities {

    @Test
    public void testStaticConstructor() {
        List<Integer> ints = Lists.newArrayList(1, 2, 3);

        for (int i = 0; i < ints.size(); i++) {
            Assert.assertEquals(Integer.valueOf(i + 1), ints.get(i));
        }
    }

    @Test
    public void testIterables() {
        List<Integer> ints = Lists.newArrayList(1, 2, 3);
        Assert.assertEquals(Integer.valueOf(1), Iterables.getFirst(ints, null));
        Assert.assertEquals(Integer.valueOf(3), Iterables.getLast(ints));
        Assert.assertEquals(3, Iterables.size(ints));
    }

    @Test
    public void testSets() {
        Set<Integer> setOne = Sets.newHashSet(1, 3, 4, 5);
        Set<Integer> setTwo = Sets.newHashSet(2, 4, 6, 8);
        Assert.assertEquals(7, Sets.union(setOne, setTwo).size());
        Assert.assertEquals(1, Sets.intersection(setOne, setTwo).size());
        Assert.assertEquals(3, Sets.difference(setOne, setTwo).size());
        Assert.assertEquals(6, Sets.symmetricDifference(setOne, setTwo).size());
    }
}
