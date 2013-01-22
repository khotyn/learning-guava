package com.khotyn.learning.guava;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

/**
 * 区间，区间的合并到底是怎么回事儿？TODO？
 * 
 * @author khotyn.huangt Jan 16, 2013 10:17:38 PM
 */
public class LearningRangeSet {

    @Test
    public void testRangeSet() {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10));
        Assert.assertEquals(1, rangeSet.asRanges().size());
        rangeSet.add(Range.openClosed(11, 15));
        Assert.assertEquals(2, rangeSet.asRanges().size());
        rangeSet.add(Range.open(15, 20));
        Assert.assertEquals(2, rangeSet.asRanges().size());
        rangeSet.add(Range.openClosed(0, 0));
        Assert.assertEquals(2, rangeSet.asRanges().size());
        rangeSet.remove(Range.open(5, 10));
        Assert.assertEquals(3, rangeSet.asRanges().size());
    }
}
