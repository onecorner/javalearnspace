package com.learn.test;

/*
* @since:       created in  2019-01-25 11:39
* @author:      htj
* @modified by:
* @version:     1.1
*/
public class ReverseCompileIntegerDemo {

    public static int add(int a, int b) {
        int c = a, d = b;
        int f = c + d;
        return f;
    }

    public static void main(String[] args) {
        System.out.println(add(1,2));
    }
}
