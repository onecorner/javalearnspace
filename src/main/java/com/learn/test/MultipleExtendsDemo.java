package com.learn.test;


abstract class Eraser {
    public abstract void erase();
}

/**
 * ?*? Ǧ����
 * ?*
 */
abstract class Pencil {
    public abstract void wirte();
}

/*
* @since: 2019-01-11 16:59
* @author:htj
*
*
*/
public class MultipleExtendsDemo {
    private MyPencil pencil = new MyPencil();
    private MyEraser eraser = new MyEraser();




    //**cannot be referenced from a static context(eg: static method)
    private class MyPencil extends Pencil {
        public void wirte() {
            System.out.println("use to wirte");
        }
    }



    private class MyEraser extends Eraser {
        public void erase() {
            System.out.println("use to erase");
        }
    }

    public void wirte() {
        pencil.wirte();
    }

    public void eraser() {
        eraser.erase();
    }

    public static void main(String[] args) {
        MultipleExtendsDemo pencilWithEraser = new MultipleExtendsDemo();
        pencilWithEraser.wirte();
        pencilWithEraser.eraser();
    }


}
