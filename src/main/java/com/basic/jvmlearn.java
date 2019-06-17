package com.basic;

/*
* @since:       created in  2019-02-08 14:20
* @author:      htj
* @modified by:
* @version:     1.1
*/
public class jvmlearn {

    private static final int SIZE = 6 * 1024 * 1024;

    public static void main(String[] args) {
        byte[] b = new byte[SIZE];

        System.gc();
    }
}
