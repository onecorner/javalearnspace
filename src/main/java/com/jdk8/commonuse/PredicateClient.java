package com.jdk8.commonuse;

import java.util.function.Predicate;

/**
 * @author htj
 * @since 2019/6/2 18:49
 */
public class PredicateClient {

    public static <T> boolean test(T str, Predicate<T> predicate) {
        return predicate.test(str);
    }

    public static void main(String[] args) {
        String name = "testestest";
        boolean test1 = test(name, test -> {
            return test.length() > 5;
        });
        System.out.println(test1);
    }

}
