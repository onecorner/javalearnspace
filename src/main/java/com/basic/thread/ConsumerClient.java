package com.basic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者模式
 * 
 * @author htj
 * @since 2019/6/5 11:00
 */
public class ConsumerClient {
    /**
     * 线程编号
     */
    private static int threadCount = 1;

    public static void main(String[] args) {
        Resource resource = new Resource();

        while (true) {
            new Thread(() -> {
                resource.produce();
            }, "thread" + (threadCount++)).start();

            new Thread(() -> {
                resource.consumer();
            }, "thread" + (threadCount++)).start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Resource {
    /**
     * 总共生产个数
     */
    private int count = 0;

    /**
     * 是否已经生产
     */
    private boolean isProduced = false;

    /**
     * 
     * 监视器（锁）
     **/
    private Lock lock = new ReentrantLock();
    /**
     * 
     * 条件
     */
    private Condition condition = lock.newCondition();

    /**
     *
     * 生产
     */
    public void produce() {
        lock.lock();
        // 如果已经生产过了，就停止生产，否则继续生产
        while (isProduced) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "生产者：" + (++count));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        condition.signalAll();
        isProduced = true;
        lock.unlock();
    }

    /**
     * 消费
     */
    public void consumer() {
        lock.lock();
        // 如果还没有生产，则等待生产，否则即可消费。
        while (!isProduced) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "消费者：------------》" + (count));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        condition.signalAll();
        isProduced = false;
        lock.unlock();
    }

}
