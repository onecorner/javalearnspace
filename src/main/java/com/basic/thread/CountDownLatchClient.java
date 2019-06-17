package com.basic.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 必须要countdown置0时，才能运行下面的代码，否则就会一直等着。
 * @author htj
 * @since 2019/6/3 15:18
 */
public class CountDownLatchClient {
    static int THREAD_NUM = 10000;

    private static final CountDownLatch cdl = new CountDownLatch(THREAD_NUM);

    // 方式二
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            System.out.println("线程" + Thread.currentThread().getName() + "解除阻塞，运行结束");
            cdl.countDown();
        };

        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(runnable).start();
        }
        System.out.println("调用一次wait");
        // 只要计数器不为0，就会一直阻塞
        cdl.await();
        System.out.println("主线程结束");
    }

    // 方式一
    /*
    public static void main(String[] args) {
    
        Runnable runnable = () -> {
            System.out.println("线程" + Thread.currentThread().getName() + "已经运行，即将阻塞");
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "解除阻塞，运行结束");
        };
    
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
    
        thread1.start();
        cdl.countDown();
        System.out.println("调用一次countDown");
    
    
        thread2.start();
        cdl.countDown();
        System.out.println("调用二次countDown");
    
    }
    */

}
