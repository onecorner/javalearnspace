package com.abstracttest;

/**
 * Created by jhons on 2018/10/10.
 */
public class Child extends ParentTest {

    private String a = "test";

    public Child(int a) {
        super(a);
        System.out.println("child--->" + a);
    }

    public void show() {
        a = "test";
    }

    public static void main(String[] args) {
        Child c = new Child(1);

        String app = "hello";

    }

    static class Inner {

    }
}

abstract class ParentTest {
    protected ParentTest(int a) {
        System.out.println("supper----" + a);
    }
}
