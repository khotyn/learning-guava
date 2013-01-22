package com.khotyn.learning.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Ticker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * 测试 Guava 的 Cache
 * 
 * @author khotyn.huangt Jan 17, 2013 10:56:00 PM
 */
public class LearningCache {

    @Test
    public void testCacheBuilder() throws ExecutionException {
        LoadingCache<String, Integer> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, Integer>() {

            @Override
            public Integer load(String key) throws Exception {
                System.out.println("Loading value for key " + key);
                return Integer.valueOf(key);
            }
        });

        Assert.assertEquals(Integer.valueOf(1), cache.get("1"));
    }

    @Test
    public void testTimeBasedEviction() throws InterruptedException, ExecutionException {
        Cache<String, Integer> cache = CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS).ticker(new Ticker() {

                                                                                                                   @Override
                                                                                                                   public long read() {
                                                                                                                       return System.nanoTime() * 10;
                                                                                                                   }
                                                                                                               }).build();
        cache.put("1", 10);
        TimeUnit.SECONDS.sleep(1);
        Assert.assertNull(cache.getIfPresent("1"));
    }
}
