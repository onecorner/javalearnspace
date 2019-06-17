package com.basic.java;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

/**
 * @author htj
 * @since 2019/6/12 11:25
 */
public class ObjectSizeCalculatorClient {
    public static void main(String[] args) {
        int i = 10;
        long objectSize = ObjectSizeCalculator.getObjectSize(i);
        //System.out.println(objectSize); // 这是计算的是Integer的大小
        System.out.println(Integer.SIZE);// 32 位
        System.out.println("Byte的字节长度为："+Byte.SIZE/8);
        System.out.println("Short的字节长度为："+Short.SIZE/8);//16
        System.out.println("整数的字节长度为："+Integer.SIZE/8);
        System.out.println("Long的字节长度为："+Long.SIZE/8);

    }
}
