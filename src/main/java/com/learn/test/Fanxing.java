package com.learn.test;

/**
 * Created by jhons on 2018/9/27.
 */
class Human {
    public void say(Human man) {
        man.say();
    }

    public void say() {
        System.out.println("I am human");
    }
}

class Man extends Human {
    public void say(Human man) {
        man.say();
    }
    public void say() {
        System.out.println("I am man");
    }
}

class Woman extends Human {
    public void say(Human man) {
        man.say();
    }
    public void say() {
        System.out.println("I am woman");
    }
}

public class Fanxing {

    static{
        a=1;
       // System.out.println(a);
    }

    public static int a = 2;

    static{
        System.out.println(a);
    }

    public void say(Human hum){
       // System.out.println("I am human");
        hum.say();
    }

    public static void main(String[] args) {
       /* Human man = new Man();
       Human woman = new Woman();
        Human man1  = (Human)man;
        Human man2  = (Human)woman;
       // Fanxing sp = new Fanxing();
        man1.say();
        man2.say();*/



        Human man = new Man();
        Human woman = new Woman();
        Fanxing sp = new Fanxing();
        sp.say(man);
        sp.say(woman);
    }
}
