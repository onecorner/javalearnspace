package com.basic.thread;

/**
 * @fomatter:off
 * 使用场景
 * 多线程执行业务逻辑的时候，需要关闭异常线程
 * @formatter:on
 * @author htj
 * @since 2019/6/4 10:14
 */
public class ThreadCloseGracefulClient1 {

    public static class Worker extends Thread {
        private volatile boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                // 具体的业务逻辑
            }

        }

        public void shutDown() {
            flag = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(3_000);
        System.out.println("结束线程");
        worker.shutDown();
    }

}
