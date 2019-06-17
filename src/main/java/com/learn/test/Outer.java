package com.learn.test;

/**
 * Created by jhons on 2019/1/11.
 */


interface AnnoInner {
    int addXYZ();
}


public class Outer {
    public AnnoInner getAnnoInner(int x) {
        final int y = 100;
        AnnoInner annoInner = new AnnoInner() {
            int z = 100;

            public int addXYZ() {
                return x + y + z;
            }
//public void changeY(){y+=1;} //��������޷��޸��ⲿ�����е����ɱ���y��
        };
        return annoInner;
    }

    public AnnoInner foo(int x) {
        final int y = 100;
        return new AnnoInner() {
            int z = 100;

            public int addXYZ() {
                return x + y + z;
            }
        };
    }

    private int num = 100;

    public static void main(String[] args) {
        System.out.println(new Outer().getAnnoInner(10).addXYZ());

        AA a  = new AA.BB();
    }
}

interface AA {
    void get();
    class BB implements AA{
        @Override
        public void get() {
            System.out.println("����");
        }
    }
}