package com.learn.test;

/**
 * Created by jhons on 2018/9/29.
 */
class SingleTon {

    private static SingleTon singleTon = new SingleTon();
    public final int count1;
    public static int count2 = 0;

    private SingleTon() {
        count1 = 1;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}

public class Test {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }
}
