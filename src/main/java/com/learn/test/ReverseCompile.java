package com.learn.test;

/*
* @since:       created in  2019-01-24 17:29
* @author:      htj
* @modified by:
* @version:     1.1
*/
public class ReverseCompile {
    static abstract class Human{
        protected abstract void sayHello();
    }
    static class Man extends Human{
        @Override
        protected void sayHello(){
            System.out.println("man say hello");
        }
    }
    static class Woman extends Human{
        @Override
        protected void sayHello(){
            System.out.println("woman say hello");
        }
    }
    public static void main(String[]args){
        Human man=new Man();
        Human woman=new Woman();
        man.sayHello();
        woman.sayHello();
        man=new Woman();
        man.sayHello();
    }

}
