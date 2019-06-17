package com.learn.test;

/**
 * Created by jhons on 2019/1/11.
 */
/*
* @since: 2019-01-11 15:59
* @author:htj
*
*
*/
public class InnerClassDemo {
    private int a = 10;

    class Inner {
        public int minus(int factor) {
            return a - factor;
        }
    }


    /*
    * static identifier can not be ommited cause there is a static method in this class
    * */
    static class StaticClass {
        public   void drink() {
            System.out.println("drink-----");
        }

        /** 
         * @Description: if any member is modified by static identifier,then the outter class must be modified static
         * @Author: htj
         * @date : 2019/1/11 16:38 
        
         * @return : void
         */
        public static void eat(){
            System.out.println("eat------");
        }
    }

    public static void main(String[] args) {
        InnerClassDemo demo = new InnerClassDemo();
        InnerClassDemo.Inner inner = demo.new Inner();
        System.out.println(inner.minus(10));
        demo.a = 100;
        System.out.println(inner.minus(10));
        new InnerClassDemo.StaticClass().drink();
        InnerClassDemo.StaticClass.eat();

    }
}

