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

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

/**
 * ���͵�ʵ���� Map��������ʲô�������ĵ������ ��Like any other Map<Class, Object>, a ClassToInstanceMap may contain entries for primitive
 * types, and a primitive type and its corresponding wrapper type may map to different values.�� ������ʲô��˼��
 * 
 * @author khotyn.huangt Jan 16, 2013 10:08:15 PM
 */
public class LearningClassToInstanceMap {

    @Test
    public void testClassToInstanceMap() {
        ClassToInstanceMap<Object> classToInstanceMap = MutableClassToInstanceMap.create();
        classToInstanceMap.put(Integer.class, 5);
        classToInstanceMap.put(Double.class, 6.6);
        Assert.assertEquals(5, classToInstanceMap.get(Integer.class));
        Assert.assertEquals(6.6, classToInstanceMap.get(Double.class));
    }
}
