package com.basic.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author htj
 * @since 2019/6/4 15:28
 */
public class LockClient {
    private Lock lock = new ReentrantLock();


    private void excute() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "---》正在执行");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "-------------》执行结束");
        lock.unlock();
    }

    public static void main(String[] args) {
        LockClient lockClient = new LockClient();
        Thread thread1 = new Thread(() -> {
            try {
                lockClient.excute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            try {
                lockClient.excute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }
}

/**
 * 
 * @linkplain com.basic.thread.TryLockClientTest#testTryLock()
 * @fomatter:off
 * trylock demo
 * @formatter:on
 */
class TryLockClient {
    private Lock lock = new ReentrantLock();


    public void method() throws InterruptedException {
        if (lock.tryLock(3, TimeUnit.SECONDS)) {
            try {
                System.out.println("线程名" + Thread.currentThread().getName() + "获得了锁");
                Thread.sleep(4000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程名" + Thread.currentThread().getName() + "释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println("我是" + Thread.currentThread().getName() + "有人占着锁，我就不要啦");
        }
    }

}

class ReentrantClient implements Runnable {

    public synchronized void get() {
        System.out.println(Thread.currentThread().getName());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getName());
    }

    public void run() {
        get();
    }

}
