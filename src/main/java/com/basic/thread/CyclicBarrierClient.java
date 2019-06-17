package com.basic.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 以下实例可以用来测试并发执行的线程数，用于秒杀活动的测试
 * 
 * @author htj
 * @since 2019/6/3 15:59
 */
public class CyclicBarrierClient {
    private static int thread_num = 100;
    private static CountDownLatch startLock = new CountDownLatch(thread_num);
    // 需要算上主线程
    private static CyclicBarrier endlock = new CyclicBarrier(thread_num + 1);
    private static CyclicBarrier cyclicBarrier_start = new CyclicBarrier(thread_num);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Runnable runnable = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + "--->开始执行");
                cyclicBarrier_start.await();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----------------------->执行当中");
            try {
                endlock.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        long starttime = System.currentTimeMillis();
        for (int i = 0; i < thread_num; i++) {
            new Thread(runnable, "线程" + (i < 10 ? "0" + i : i)).start();
        }
        endlock.await();
        long endTime = System.currentTimeMillis();
        System.out.println("结束了，一共执行了：" + (endTime - starttime) + "毫秒");
    }
    /*
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Runnable runnable = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + "--->开始执行");
                startLock.await();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----------------------->执行当中");
            try {
                endlock.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->执行结束");
        };
    
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < thread_num; i++) {
            new Thread(runnable).start();
            startLock.countDown();
        }
        endlock.await();
        long endTime = System.currentTimeMillis();
        System.out.println("结束了，一共执行了：" + (endTime - starttime) + "毫秒");
    }
    */
}
