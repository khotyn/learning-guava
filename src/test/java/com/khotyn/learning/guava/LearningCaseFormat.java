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
