package com.basic.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author htj
 * @since 2019/6/6 13:50
 */
public class StackClient {


    public int cal(List<Containner> objs, int a) {
        objs.add(new Containner());
        System.out.println(a);
        return cal(objs, ++a);
    }

    public static void main(String[] args) {
        List<Containner> objs = new ArrayList<>();
        new StackClient().cal(objs,0);//10458  26  833
    }
}


class Containner{
    //不加这行代码爆出的错误是java.lang.StackOverflowError
    //加上这行代码爆出的错误是OutOfMemoryError: Java heap space
   // byte aByte[] = new byte[1024*1024*4];
}
