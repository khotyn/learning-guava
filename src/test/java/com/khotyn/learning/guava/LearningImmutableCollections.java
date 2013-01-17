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
 * Immutable ��ص����ƺ��� web ���͵���Ŀ�к���ʹ�õ����� web
 * ���͵���Ŀ�У��󲿷ֵļ����඼��һ������Ĺ����д������ұ������ˣ�����˵�󲿷ֵļ��϶�ֻ��һ���߳��б����������������ж��߳����⣬����Ҳû��Ҫ�ر�ط�ֹ���̵߳����⣬���� guava �ⷴ����������Ŀ��������
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
