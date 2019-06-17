package com.basic.jvm;

import com.basic.thread.SafeThread;
import com.basic.thread.UnSafeThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author htj
 * @since 2019/6/6 9:34
 */
public class TicketClient {

    public static void main(String[] args) throws InterruptedException {
        // 线程数量
       /* int threadNum = 10000;
        // 总票数
        int ticketCount = 100_000;
        AtomicInteger atoCount = new AtomicInteger(ticketCount);
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        Ticket ticket = new Ticket(countDownLatch, atoCount);
        for (int i = 0; i < threadNum; i++) {
            new Thread(ticket).start();
        }
        countDownLatch.await();
        System.out.println("还剩下（张）：" + atoCount.get());
*/
        // 线程不安全测试
        int threadNum = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        UnsafeTicket ticket = new UnsafeTicket(countDownLatch);
        for (int i = 0; i < threadNum; i++) {
            new Thread(ticket).start();
        }
        countDownLatch.await();

    }
}

@SafeThread
class Ticket implements Runnable {
    private AtomicInteger atoCount;
    private CountDownLatch countDownLatch;

    public Ticket(CountDownLatch countDownLatch, AtomicInteger atoCount) {
        this.countDownLatch = countDownLatch;
        this.atoCount = atoCount;
    }

    @Override
    public void run() {
        while (true) {
            int num = atoCount.decrementAndGet();
            if (num <= 0) {
                break;
            }
            System.out.println(num);
        }
        countDownLatch.countDown();
    }
}

@UnSafeThread
class UnsafeTicket implements Runnable {
    private CountDownLatch countDownLatch;
    private volatile int count = 10_000;

    public UnsafeTicket(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        while (true) {
            // 会重复卖
            //getfield 获取指定类的实例域, 并将其压入栈顶
            //dup_x1	复制栈顶一个字长的数据，弹出栈顶两个字长数据，先将复制后的数据压栈，再将弹出的两个字长数据压栈。
            //iconst_1	将int型1推送至栈顶
            //isub	将栈顶两int型数值相减并将结果压入栈顶
            //putfield	为指定类的实例域赋值
            //istore_1	将栈顶int型数值存入第二个本地变量
            int num = count--;
            if (num <= 0) {
                break;
            }
            System.out.println(num);
        }
        countDownLatch.countDown();
    }
}
