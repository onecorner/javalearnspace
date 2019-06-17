package com.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author jhons
 * @since 2019/5/30 14:21
 */
@Slf4j
public class MapExample {
	private static Map<Integer, Integer> map = new HashMap();
	// 请求总数
	public static int clientNum = 5000;
	// 同时并发执行的线程数
	public static int threadNum = 1;
//	public static int threadNum = 200;

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(threadNum);
		for (int index = 0; index < clientNum; index++) {
			final int threadNum = index;
			exec.execute(() -> {
				try {
					semaphore.acquire();
					func(threadNum);
					semaphore.release();
				} catch (Exception e) {
					log.error("exception", e);
				}
			});
		}
		exec.shutdown();
		log.info("size:{}", map.size());
	}

	private static void func(int threadNum) {
		map.put(threadNum, threadNum);
	}
}