package com.basic.thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author htj
 * @since 2019/6/7 18:39
 */
public class FixedSizeThreadPool {
    /**
     * 仓库
     */
    private BlockingQueue<Runnable> blockingQueue;

    /**
     * 线程集合
     */
    private List<Worker> works;

    private volatile boolean isWorking = true;

    public static class Worker extends Thread {
        private FixedSizeThreadPool fixedSizeThreadPool;

        public Worker(FixedSizeThreadPool fixedSizeThreadPool) {
            this.fixedSizeThreadPool = fixedSizeThreadPool;
        }

        @Override
        public void run() {
            while (this.fixedSizeThreadPool.isWorking || this.fixedSizeThreadPool.blockingQueue.size() > 0) {
                Runnable task = null;

                try {
                    if (this.fixedSizeThreadPool.isWorking) {
                        task = fixedSizeThreadPool.blockingQueue.take();
                    } else {
                        task = fixedSizeThreadPool.blockingQueue.poll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (task != null) {
                    task.run();
                    System.out.println(Thread.currentThread().getName() + "--->执行结束");
                }
            }
        }
    }

    public FixedSizeThreadPool(int poolSize, int taskSize) {
        if (poolSize <= 0 || taskSize <= 0) {
            throw new IllegalArgumentException("非法参数");
        }
        this.blockingQueue = new LinkedBlockingDeque<>(taskSize);
        this.works = Collections.synchronizedList(new LinkedList());
        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker(this);
            worker.start();
            works.add(worker);
        }
    }

    public boolean submit(Runnable task) {
        return this.blockingQueue.offer(task);
    }

    public void excute(Runnable task) throws InterruptedException {
        this.blockingQueue.put(task);
    }

    public void shutDown() {
        this.isWorking = false;
        for (Thread thread : works) {
            if (Thread.State.WAITING.equals(thread.getState()) || Thread.State.BLOCKED.equals(thread.getState())) {
                thread.interrupt();
            }
        }
    }

    public static void main(String[] args) {
        FixedSizeThreadPool pool = new FixedSizeThreadPool(12, 20);
        for (int i = 0; i < 12; i++) {
            pool.submit(() -> {
                System.out.println("线程正在执行");
            });
        }

        pool.shutDown();
    }

}
