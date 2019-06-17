package com.basic.thread;

/**
 * @author htj
 * @since 2019/6/4 9:32
 */
public class InteruptClient {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            while (true) {
                // 一直让他在这里执行
                // System.out.println("is alive--->" + Thread.currentThread().isInterrupted());
                // 方式二 如果不捕获InterruptedException的话， 子线程会一直挂起
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("收到中断信息");
                    return;
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();
        // 主线程休眠
        Thread.sleep(1000);
        System.out.println(thread1.isInterrupted());
        thread1.interrupt();
        System.out.println(thread1.isInterrupted());

    }
}
