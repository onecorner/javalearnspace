package com.basic.reflection;

import org.junit.Test;

/**
 * @author htj
 * @since 2019/6/14 17:11
 */
public class ClassTest {
    @Test
    public void testClass() {
        Class clazz1 = ClassTest.class;
        Class clazz2 = ClassTest.class;
        System.out.println(clazz1 == clazz2);
        String str = "str";
        StringBuffer sb = new StringBuffer("test");
    }
}
