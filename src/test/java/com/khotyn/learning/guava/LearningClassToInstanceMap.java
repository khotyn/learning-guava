package com.khotyn.learning.guava;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

/**
 * 类型到实例的 Map，作用是什么？还有文档里面的 “Like any other Map<Class, Object>, a ClassToInstanceMap may contain entries for primitive
 * types, and a primitive type and its corresponding wrapper type may map to different values.” 到底是什么意思？
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
