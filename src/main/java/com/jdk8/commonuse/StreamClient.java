package com.jdk8.commonuse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author htj
 * @since 2019/6/2 22:04
 */
public class StreamClient {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("wamngwude");
        list.add("zhoubichang");
        list.add("lijie");
        list.stream().filter(str -> {
            return str.length() > 5;
        }).filter(str -> {
            return str.contains("z");
        }).forEach(item -> System.out.println(item));
    }
}
