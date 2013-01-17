package com.khotyn.learning.guava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.Optional;

/**
 * ���ã��������װ�� Optional �е������ǳ���Ա���� Optional���ͻ��뵽��� Value ������ null �ģ��� optional �ģ���������װ�ʹ����˳����������ǿ��
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
