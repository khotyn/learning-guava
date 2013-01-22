package com.khotyn.learning.guava;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.CaseFormat;

/**
 * Case Format
 * 
 * @author khotyn.huangt Jan 21, 2013 7:59:29 PM
 */
public class LearningCaseFormat {

    @Test
    public void testCaseFormat() {
        Assert.assertEquals("dou_ban", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "DouBan"));
        Assert.assertEquals("dou-ban", CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, "DOU_BAN"));
    }
}
