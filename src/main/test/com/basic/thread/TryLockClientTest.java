package com.basic.thread;

import org.junit.Test;

/**
 * @author htj
 * @since 2019/6/4 15:47
 */
public class TryLockClientTest {

    @Test
    public void testTryLock() throws InterruptedException {
        TryLockClient lockTest = new TryLockClient();

        // 线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockTest.method();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockTest.method();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("结束啦");
    }

    @Test
    public void testReentrantClient() {
        ReentrantClient rt = new ReentrantClient();
        for (;;) {
            new Thread(rt).start();
        }
    }

    /**
     * 
     * 可重入锁测试
     */
    @Test
    public void testReentry() {
        class MyTest {
            public synchronized void method1() {
                System.out.println(Thread.currentThread().getName() + "---->method1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                method2();
            }

            public synchronized void method2() {
                System.out.println(Thread.currentThread().getName() + "--->method2--->");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        MyTest test = new MyTest();
        while (true) {
            Thread thread = new Thread(() -> {
                test.method1();
            });

            Thread thread1 = new Thread(() -> {
                test.method2();
            });

            thread.start();
            thread1.start();
            try {
                thread.join();
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}