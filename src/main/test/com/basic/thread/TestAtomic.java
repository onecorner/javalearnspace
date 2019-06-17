package com.basic.thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author htj
 * @since 2019/6/5 14:59
 */
public class TestAtomic {

    /***
     * 测试AtomicInteger的线程安全性
     */
    @Test
    public void testAtomicInteger() throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0);
        int num = 10000, i = 0;
        CountDownLatch countdown = new CountDownLatch(num);
        while (i < num) {
            i++;
            new Thread(() -> {
                int i1 = count.incrementAndGet();
                System.out.println(i1);
                countdown.countDown();
            }).start();
        }
        countdown.await();
        System.out.println("总数：" + count.get());
    }

    private volatile boolean isBreak = false;

    /***
     * 测试AtomicInteger的线程安全性
     */
    @Test
    public void testAtomicInteger1() throws InterruptedException {
        AtomicInteger count = new AtomicInteger(1000);
        int num = 10000, i = 0;
        while (true) {
            new Thread(() -> {
                int i1 = count.incrementAndGet();
                if (i1 >= num) {
                    isBreak = true;
                    return;
                }
                System.out.println(i1);
            }).start();
            if (isBreak) {
                break;
            }
        }
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("总数：" + count.get());
    }
}
