package com.jdk8.commonuse;

import java.util.function.Function;

/**
 * @author htj
 * @since 2019/6/2 20:24
 */
public class FunctionClient {

    /**
     * 将function的第一个参数类型转换成第二个参数类型
     */
    public static int parseInt(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    public static void main(String[] args) {
        String a = "123";
        int i = parseInt(a, (str) -> {
            return Integer.parseInt(str);
        });
        System.out.println(i);
        // 方法二
        Function<String,Integer> myfunction = num->Integer.parseInt(num);
        System.out.println(myfunction.apply("143323"));
    }
}
