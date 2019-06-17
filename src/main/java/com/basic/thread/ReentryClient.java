package com.basic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author htj
 * @since 2019/6/5 10:04
 */
public class ReentryClient {

    private final Condition condition;
    private final Lock lock;
    private boolean flag = false;

    public ReentryClient(Condition condition, Lock lock) {
        this.condition = condition;
        this.lock = lock;
    }

    public void method1() {
        lock.lock();
        if (flag) {
            System.out.println("method1");
            flag = false;
            condition.signalAll();
        } else {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lock.unlock();
    }

    public void method2() {
        lock.lock();
        if (flag) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("method2--------》");
            flag = true;
            condition.signalAll();
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ReentryClient reentryClient = new ReentryClient(condition, lock);
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0) {
                new Thread(() -> {
                    reentryClient.method1();
                }).start();
            } else
                new Thread(() -> {
                    reentryClient.method2();
                }).start();

        }
    }

}
