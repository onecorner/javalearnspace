package com.basic.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author htj
 * @since 2019/6/6 16:41
 */
public class BlockingQueuesConsumer {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
        Thread pro = new Thread(new Producer(queue), "生产者");
        pro.start();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Concumer(queue), "消费者 " + i);
            t.start();
        }
    }
}

class Producer implements Runnable {
    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        int i = 0;
        while (true) {
            try {
                int number = i++;
                queue.put(" 食物 " + number); // 阻塞
                System.out.println("生产者生产食物， 食物编号为：" + number);
                // queue.add(" 食物 " + i++);
                // Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("生产者被中断");
            }
        }
    }
}

class Concumer implements Runnable {
    BlockingQueue<String> queue;

    public Concumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + "消费：" + queue.take());
                System.out.println(queue.size());
            } catch (InterruptedException e) {
                System.out.println("消费者被中断");
            }
        }
    }
}
