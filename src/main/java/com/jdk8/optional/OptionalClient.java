package com.jdk8.optional;

import java.util.Optional;

/**
 * @author htj
 * @since 2019/6/3 9:52
 */
public class OptionalClient {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = null;
        Integer c = 4;
        Optional<Integer> optionala = Optional.ofNullable(a);
        // 这里会抛出异常
        // Optional<Integer> optionalb = Optional.of(b);
        Optional<Integer> optionalb = Optional.ofNullable(b);
        test(optionala, optionalb);
    }

    public static void test(Optional<Integer> a, Optional<Integer> b) {
        System.out.println(a.isPresent());
        System.out.println(b.isPresent());
        Integer c = b.orElse(10);
        System.out.println(c);

    }
}
