package com.basic.jvm;

/**
 * @author htj
 * @since 2019/6/6 14:57
 */
public class VolatileTest {

    private int i = 0;
    private int j = 0;
    private boolean flag = false;

    public static void main(String[] args) {
        // bipush 15 将单字节的常量值(-128~127)推送至栈顶
        VolatileTest test = new VolatileTest();
        test.i = 1;
        test.flag = true;
        test.j++;
        int i = 0, j = 0;
        i = i++;
        j = j++;
        System.out.println(i);
        System.out.println(j);
    }

}
