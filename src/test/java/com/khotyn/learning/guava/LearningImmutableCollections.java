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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Immutable 相关的类似乎在 web 类型的项目中很难使用到，在 web
 * 类型的项目中，大部分的集合类都在一个请求的过程中创建并且被销毁了，就是说大部分的集合都只在一个线程中被操作，根本不会有多线程问题，所以也没必要特别地防止多线程的问题，引入 guava 库反而增加了项目的依赖。
 * 
 * @author khotyn.huangt Jan 14, 2013 10:32:50 PM
 */
public class LearningImmutableCollections {

    private static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of("red", "orange", "yellow", "green", "blue",
                                                                            "purple");

    @Test
    public void testImmutableSetPreserveOrder() {
        Assert.assertEquals("yellow", COLOR_NAMES.asList().get(2));
    }

    @Test
    public void testImmutableSetCopyOf() {
        ImmutableList<String> colors = ImmutableList.copyOf(new String[] { "red", "orange", "yellow", "green", "blue",
                "purple" });
        Assert.assertEquals("green", colors.get(3));
    }

    @Test(expected = NullPointerException.class)
    public void testImmutableSetNull() {
        ImmutableList.copyOf(new String[] { null, "orange", "yellow", "green", "blue", "purple" });
    }
}
