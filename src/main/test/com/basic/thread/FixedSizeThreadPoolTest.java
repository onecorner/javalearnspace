package com.basic.thread;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author htj
 * @since 2019/6/7 20:05
 */
public class FixedSizeThreadPoolTest {

    @Test
    public void submit() {
        FixedSizeThreadPool pool = new FixedSizeThreadPool(12, 20);
        for (int i = 0; i < 12; i++) {
            pool.submit(() -> {
                System.out.println("线程正在执行");
            });
        }
    }

    @Test
    public void testThreadGroup() {
        ThreadGroup thread = new ThreadGroup("tg");
        ThreadGroup threadGroup = new ThreadGroup(thread, "tg1");
        System.out.println(threadGroup.getName());
        System.out.println(threadGroup.getParent().getName());
        System.out.println(thread.getParent().getName());
    }

    private static volatile int INIT_VALUE = 0;
    private static final int MAX_VALUE = 50;

    @Test
    public void testVolatil() throws InterruptedException {
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_VALUE) {
                if (localValue != INIT_VALUE) {
                    System.out.printf("the value updated to [%d]\n", INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }
        }).start();

        Thread thread = new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_VALUE) {
                System.out.printf("the value updated to-----------》 [%d]\n", ++INIT_VALUE);
                localValue = INIT_VALUE;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
    }

    @Test
    public void testBlockQueue() throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        Thread thread1 = new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    String message = Thread.currentThread().getName() + ": product num->" + i++;
                    queue.put(message);
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("消费者：" + queue.take());;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public void testSynchronousQueue() throws InterruptedException {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue();

        class Test {
            public void produce() {
                int i = 0;
                for (;;) {
                    String message = Thread.currentThread().getName() + "(生产者)" + i++;
                    try {
                        System.out.println(message);
                        synchronousQueue.put(message);
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            public void consume() {
                for (;;) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "(消费者)----》" + synchronousQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

        Test test = new Test();
        Thread thread = new Thread(test::produce);
        Thread thread1 = new Thread(test::consume);
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();

    }

    @Test
    public void testBloackQueue() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(2);
        blockingQueue.put("isArray");
        blockingQueue.put("test2");
        blockingQueue.offer("wwwww");
        String take = blockingQueue.take();
        System.out.println(take);
        Executors.newCachedThreadPool();
    }

}