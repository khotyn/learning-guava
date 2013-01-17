/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.khotyn.learning.guava;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

/**
 * ʹ������ֵ����Ϊһ�� map �� key��һ�� column��һ�� row�����Ծ͹�����һ�� table��
 * 
 * @author khotyn.huangt Jan 16, 2013 9:56:52 PM
 */
public class LearningTable {

    @Test
    public void testTable() {
        Table<String, String, String> persons = HashBasedTable.create();
        persons.put("khotyn", "huang", "khotynhuang");
        persons.put("khotyn", "tian", "khotyntian");
        persons.put("vivian", "huang", "vivianhuang");
        persons.put("vivian", "tian", "viviantian");
        String desc = persons.get("khotyn", "tian");
        Assert.assertEquals("khotyntian", desc);
        Set<Cell<String, String, String>> cellSet = persons.cellSet();
        for (Cell<String, String, String> cell : cellSet) {
            Assert.assertEquals(cell.getRowKey() + cell.getColumnKey(), cell.getValue());
        }
    }
}
