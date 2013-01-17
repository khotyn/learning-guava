package com.khotyn.learning.guava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.Optional;

/**
 * 作用：将对象封装到 Optional 中的作用是程序员看到 Optional，就会想到这个 Value 可能是 null 的，是 optional 的，这样，封装就带来了程序语义的增强。
 * 
 * @author khotyn.huangt Jan 7, 2013 7:48:39 AM
 */
public class LearningOptional {

    @Test
    public void testOptional() {
        Optional<Integer> num = Optional.of(5);
        assertEquals(5, num.get().intValue());
    }
}
