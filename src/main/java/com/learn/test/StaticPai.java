package com.learn.test;

/**
 * Created by jhons on 2018/9/29.
 */


public class StaticPai {

    /*public void say(Human hum) {
        System.out.println("I am human");
    }*/

    public void say(Man hum) {
        System.out.println("I am man");
    }

    public void say(Woman hum) {
        System.out.println("I am woman");
    }

    public static void main(String[] args) {

        {
            byte[] holder = new byte[32*1024*1024];
            holder = null;
        }
        System.gc();
      /*  Man man = new Man();
        Woman woman = new Woman();
        StaticPai sp = new StaticPai();
        sp.say(man);
        sp.say(woman);*/
    }
}
