package com.jdk8.commonuse;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author htj
 * @since 2019/6/2 16:25
 */
public class ConsumerClient {
    public static void accept(String str, Consumer<String> consumer) {
        consumer.accept(str);
    }

    public static <T> void andThenTest(T t, Consumer<T> consumer, Consumer<T> consumer1) {
        // 方法一
        // consumer.accept(t);
        // consumer1.accept(t);
        // 方法二
        consumer.andThen(consumer1).accept(t);
    }

    public static void parseStrAndPrint(String[] strs, Consumer<String> consumer, Consumer<String> consumer2) {
        for (String str : strs) {
            consumer.andThen(consumer2).accept(str);
        }
    }

    public static void main(String[] args) {
        String name = "zHanGsan";
        System.out.println(name);
        accept(name, str -> {
            System.out.println(new StringBuilder(str).reverse().toString());
        });

        // andthen
        andThenTest(name, (t) -> {
            System.out.println(t.toUpperCase());
        }, t -> {
            System.out.println(t.toLowerCase());
        });

        // andThen使用
        String[] strs = {"zhangsan,nan", "lisi,nv", "wangwu,nan"};

        parseStrAndPrint(strs, str1 -> {
            String str_ = str1.split(",")[0];
            System.out.print("姓名：" + str_);

        }, str2 -> {
            String str_ = str2.split(",")[1];
            System.out.println("。性别：" + str_);
        });

        // 方法二
        Consumer<String> consumer1 = str1 -> {
            String str_ = str1.split(",")[0];
            System.out.print("姓名：" + str_);
        };

        Consumer<String> consumer2 = str1 -> {
            String str_ = str1.split(",")[1];
            System.out.println("。性别：" + str_);
        };

        System.out.println("方法二");
        Stream.of(strs).forEach(str -> consumer1.andThen(consumer2).accept(str));

    }
}
