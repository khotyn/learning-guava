package com.khotyn.learning.guava;

import static com.google.common.base.Preconditions.checkArgument;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * {@link Preconditions} 提供了各种静态方法用于检查参数的条件，用 static import 进来后，使用起来非常语义化。
 * 
 * @author khotyn.huangt Jan 7, 2013 7:53:10 AM
 */
public class LearningPrecondition {

    @Test
    public void testPreconditionNotNull() {
        assertEquals("hello", basePreconditionTest("hello"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPreconditionEmpty() {
        basePreconditionTest("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPreconditionNull() {
        basePreconditionTest(null);
    }

    public String basePreconditionTest(String str) {
        checkArgument(!Strings.isNullOrEmpty(str), "Str is null or empty");
        return str;
    }
}
