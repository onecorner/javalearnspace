package com.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 并发：同时拥有两个或者多个线程，如果程序在单核处理器上运行，多个线程将交替地换入或者换出
 * 内存，这些线程是同时“存在”的，每个线程都处于执行过程中的某个状态，如果运行在多核处理器上此时，
 * 程序中的每个线程都分配到一个处理器核上，因此可以同时运行。
 *
 * 多个线程操作相同的资源，保证线程安全，合理利用资源
 *
 * 高并发:是互联网分布式系统架构设计中必须考虑的因素之一，它通常是指，通过设计保证系统
 * 能够同时并行处理很多请求。
 *
 * 服务能够处理很多请求，提高程序性能。
 *
 * CPU 多级缓存：
 *      主要是为了缓解cpu和内存之间速度的不匹配问题 （CPU->cache-?memory）
 *      意义:
 *      	时间局限性： 如果某个数据被访问，那么在不久的将来它很可能被再次访问。
 *      	空间局限性： 如果某个数据被访问，那么与它相邻的数据很快也可能被访问。
 *      缓存一致性（MESI）：用于保证多个cpu cache之间缓存共享数据的一致性。
 *      	M:modified,该缓存行只存在CPU的缓存中，并且是被修改过的，与主存不一致。
 *          E:eclusive
 *          S:shared
 *          I:invalidated
 *
 * @author jhons
 * @since 2019/5/30 13:32
 * 5000个请求，同时并发的请求有200个，查看执行时间
 */
@Slf4j
public class CountDemo {
	// 请求总数
	public static int clientTotal = 5000;
	// 同时并发执行的线程数
//	public static int threadTotal = 200;
	public static int threadTotal = 1;
	public static int count = 0;

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(threadTotal);

		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i = 0; i < clientTotal; i++) {
			executorService.execute(() -> {
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (Exception e) {
					log.error("exception", e);
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executorService.shutdown();
		log.info("count:{}", count);
	}

	private static void add() {
		count++;
	}
}
