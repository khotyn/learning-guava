package com.khotyn.learning.guava;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

/**
 * Objects 的 {@link ComparisonChain} 用起来好棒，用于实现 {@link Comparable} 接口非常方便啊。
 * 
 * @author khotyn.huangt Jan 7, 2013 10:57:24 PM
 */
public class LearningObjects {

    @Test
    public void testObjectsEquals() {
        Assert.assertFalse(Objects.equal(null, "a"));
    }

    @Test
    public void testObjectsToStringHelper() {
        class Person {

            String firstName;
            String lastName;

            public Person(String firstName, String lastName){
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public String toString() {
                return Objects.toStringHelper(Person.class).add("firstName", firstName).add("lastName", lastName).toString();
            }
        }
        Assert.assertEquals("Person{firstName=Khotyn, lastName=Huang}", new Person("Khotyn", "Huang").toString());
    }

    @Test
    public void testObjectsComparisonChain() {
        class Person implements Comparable<Person> {

            String firstName;
            String lastName;

            Person(String firstName, String lastName){
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public int compareTo(Person o) {
                return ComparisonChain.start().compare(this.firstName, o.firstName).compare(this.lastName, o.lastName).result();
            }

        }

        Assert.assertTrue(new Person("Khotyn", "Huangt").compareTo(new Person("Khotyn", "Tian")) < 0);
    }
}
