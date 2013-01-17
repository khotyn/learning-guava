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

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Ë«ÏòÓ³ÉäµÄ Map
 * 
 * @author khotyn.huangt Jan 15, 2013 11:06:26 PM
 */
public class LearningBiMap {

    @Test
    public void testBiMap_reverse() {
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("13", 13);
        biMap.put("12", 12);
        biMap.put("11", 11);
        BiMap<Integer, String> inverseBiMap = biMap.inverse();
        for (Integer key : inverseBiMap.keySet()) {
            Assert.assertEquals(key.toString(), inverseBiMap.get(key));
        }
    }
}
