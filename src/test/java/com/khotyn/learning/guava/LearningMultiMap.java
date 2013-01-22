/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.khotyn.learning.guava;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

/**
 * MultiMap，应该有这样的应用场景，一个 key 对应到一个集合。
 * 
 * @author khotyn.huangt Jan 15, 2013 10:52:10 PM
 */
public class LearningMultiMap {

    @Test
    public void testMultiMap_put() {
        ListMultimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.put("a", "what");
        multiMap.put("a", "the");
        multiMap.put("a", "fuck");
        List<String> values = multiMap.get("a");
        Assert.assertEquals(3, values.size());
    }

    @Test
    public void testMultiMap_putAll() {
        List<String> values = Arrays.asList("what", "the", "fuck");
        ListMultimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.putAll("a", values);
        multiMap.putAll("a", values);
        Assert.assertEquals(6, multiMap.get("a").size());
    }

    @Test
    public void testMultiMap_remove() {
        ListMultimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.put("a", "what");
        multiMap.put("a", "the");
        multiMap.put("a", "fuck");
        multiMap.remove("a", "the");
        Assert.assertEquals(2, multiMap.get("a").size());
        multiMap.remove("a", "fuckk");
        Assert.assertEquals(2, multiMap.get("a").size());
    }

    @Test
    public void testMultiMap_removeAll() {
        ListMultimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.put("a", "what");
        multiMap.put("a", "the");
        multiMap.put("a", "fuck");
        multiMap.removeAll("a");
        Assert.assertEquals(0, multiMap.get("a").size());
    }

    @Test
    public void testMultiMap_replaceValues() {
        ListMultimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.put("a", "what");
        multiMap.put("a", "the");
        multiMap.put("a", "fuck");
        multiMap.replaceValues("a", Arrays.asList("Hello", "world"));
        Assert.assertEquals(2, multiMap.get("a").size());
    }
}
