package com.khotyn.learning.guava;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * 双向映射的 Map
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
