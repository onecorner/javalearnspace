package com.basic.thread;

import java.util.concurrent.Semaphore;

/**
 * 控制并发量
 * 
 * @author htj
 * @since 2019/6/3 17:26
 */
public class SemaphoreClient {
    public static void main(String[] args) {
        int N = 10; // 工人数
        Semaphore semaphore = new Semaphore(5); // 表示能够同时进行的数量大小
        for (int i = 0; i < N; i++)
            new Test.Worker(i, semaphore).start();
    }
}

class Test {

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + Thread.currentThread().getName() + ":" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
