package com.khotyn.learning.guava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

/**
 * Ordering 方法提供了诸多的排序方法，还是挺方便的。
 * 
 * @author khotyn.huangt Jan 7, 2013 8:03:23 AM
 */
public class LearningOrdering {

    private static List<Integer>     ints          = Arrays.asList(5, 3, 4, 2, 1);
    private static Ordering<Integer> naturalOrder  = Ordering.natural();
    private static Ordering<Integer> reversedOrder = Ordering.natural().reverse();

    @Test
    public void testOrderingNatual() {
        List<Integer> sortedInts = naturalOrder.sortedCopy(ints);
        for (int i = 0; i < sortedInts.size(); i++) {
            Assert.assertEquals(Integer.valueOf(i + 1), sortedInts.get(i));
        }
    }

    @Test
    public void testOrderingUsingToString() {
        List<Integer> sortedInts = Ordering.usingToString().sortedCopy(Arrays.asList(1, 11, 2, 3, 12));
        Assert.assertArrayEquals(new Integer[] { 1, 11, 12, 2, 3 }, sortedInts.toArray());
    }

    @Test
    public void testOrderingIsOrdered() {
        List<Integer> sortedInts = naturalOrder.sortedCopy(ints);
        List<Integer> reverseSortedInts = reversedOrder.sortedCopy(ints);
        Assert.assertTrue(naturalOrder.isOrdered(sortedInts));
        Assert.assertFalse(reversedOrder.isOrdered(sortedInts));
        Assert.assertTrue(reversedOrder.isOrdered(reverseSortedInts));
    }

    @Test
    public void testOrderingMinAndMax() {
        Assert.assertEquals(Integer.valueOf(1), naturalOrder.min(ints));
        Assert.assertEquals(Integer.valueOf(5), naturalOrder.max(ints));
    }

    @Test
    public void testOrderingOnResultOf() {
        Ordering<Integer> zeroNaturalOrder = naturalOrder.onResultOf(new Function<Integer, Integer>() {

            public Integer apply(Integer input) {
                return input - input;
            }
        });
        List<Integer> zeroSortedInts = zeroNaturalOrder.sortedCopy(ints);
        Assert.assertArrayEquals(new Integer[] { 5, 3, 4, 2, 1 }, zeroSortedInts.toArray());
    }

    @Test
    public void testOrderingCompound() {
        class Person {

            String firstName;
            String lastName;
            int    age;

            public Person(String firstName, String lastName, int age){
                this.firstName = firstName;
                this.lastName = lastName;
                this.age = age;
            }

            @Override
            public boolean equals(Object obj) {
                Person person = (Person) obj;
                return this.firstName == person.firstName && this.lastName == person.lastName && this.age == person.age;
            }
        }
        Person khotynHuang = new Person("Khotyn", "Huangt", 24);
        Person khotynTian = new Person("Khotyn", "Tian", 23);
        Person yaKhotynTian = new Person("Khotyn", "Tian", 22);
        Ordering<Person> personOrdering = Ordering.from(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        }).compound(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        }).compound(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        List<Person> orderedPersons = personOrdering.sortedCopy(Arrays.asList(khotynTian, khotynHuang, yaKhotynTian));
        Assert.assertArrayEquals(new Person[] { khotynHuang, yaKhotynTian, khotynTian }, orderedPersons.toArray());
    }
}
