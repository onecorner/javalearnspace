package com.basic.thread;

/**
 * @author htj
 * @since 2019/6/3 12:16
 */
public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {
        int result = 0;
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "--------" + i);
            }
        };

        Thread thread = new Thread(runnable, "线程1");
        Thread thread1 = new Thread(runnable, "线程2");
        Thread thread2 = new Thread(runnable, "线程3");
        thread.start();
        thread1.start();
        thread2.start();
        System.out.println(Thread.activeCount());
        // 主线程阻塞，等待线程一结束运行
        thread.join();
        thread1.join();
        thread2.join();
        System.out.println("主线程结束");
    }
}
