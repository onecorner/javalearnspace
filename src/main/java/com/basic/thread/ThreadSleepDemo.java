package com.basic.thread;

/**
 * @author htj
 * @since 2019/6/3 12:16
 */
public class ThreadSleepDemo {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "--------" + i);
                if (i == 30) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(runnable, "线程1").start();
        new Thread(runnable, "线程2").start();
        new Thread(runnable, "线程3").start();
        System.out.println("主线程结束");
    }
}
