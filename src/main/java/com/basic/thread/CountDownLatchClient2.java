package com.basic.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  不推荐，蠢方法
 * @author htj
 * @since 2019/6/3 15:18
 */
public class CountDownLatchClient2 extends Thread {
    private CountDownLatch latch_beg;
    private CountDownLatch latch_end;

    public CountDownLatchClient2(String name, CountDownLatch latch_beg, CountDownLatch latch_end) {
        super(name);
        this.latch_beg = latch_beg;
        this.latch_end = latch_end;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " -> start");
        try {
            this.latch_beg.await();
            System.out.println(this.getName() + " -> running complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch_end.countDown();
        }
    }

    public static void main(String[] arg) throws InterruptedException {
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(1000);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            service.submit(new CountDownLatchClient2(String.valueOf(i), start, end));
        }
        Thread.sleep(1500);
        System.out.println("thread will running");

        // 计数器-1，子线程被唤醒
        start.countDown();
        // 主线程等待子线程运行完
        end.await();

        System.out.println("running complete");
        System.exit(0);
    }

}
