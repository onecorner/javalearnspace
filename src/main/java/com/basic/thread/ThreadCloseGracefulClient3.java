package com.basic.thread;

/**
 * @fomatter:off
 * 使用场景
 * 需要在规定的时间内完成任务
 * @formatter:on
 * @author htj
 * @since 2019/6/4 10:14
 */
public class ThreadCloseGracefulClient3 {

    private Thread executeThread;

    /*由于demo没有使用同步，所以必须要使用volatile来修饰变量，保证它的可见性*/
    private volatile boolean finished = false;

    public void execute(Runnable task) {
        executeThread = new Thread() {
            @Override
            public void run() {
                Thread runnar = new Thread(task);
                runnar.setDaemon(true);
                runnar.start();
                try {
                    runnar.join();
                    finished = true;
                } catch (InterruptedException e) {
                    System.out.println("executeThread线程被打断");
                }
            }

        };
        executeThread.start();
    }

    public void shutdown(long gats) {

        long currentTimeMillis = System.currentTimeMillis();
        while (!finished) {
            if (System.currentTimeMillis() - currentTimeMillis >= gats) {
                System.out.println("任务超时，需要结束");
                executeThread.interrupt();
                break;
            }
            // 没有完成，且没有到达指定的执行时间
            try {
                System.out.println("等待ing-------》");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("执行线程结束");
                break;
            }
        }
        finished = false;

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadCloseGracefulClient3 runnar = new ThreadCloseGracefulClient3();
        Long starttime = System.currentTimeMillis();
        runnar.execute(() -> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + "执行ing----||||");
                    Thread.sleep(9000);
                    break;
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "执行线程挂了");
                }
            }
        });
        runnar.shutdown(5000);
        Long endtime = System.currentTimeMillis();
        System.out.println("执行了：" + (endtime - starttime) + "毫秒");
    }

}
