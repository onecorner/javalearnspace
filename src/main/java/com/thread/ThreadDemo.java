package com.thread;

/**
 * 创建线程的两种方式： 继承Thread 实现Runable
 * 在java当中，程序的启动每次都伴随至少2个线程，一个是main线程，一个是垃圾回收线程。
 *
 * @author jhons
 * @since 2019/5/30 15:00
 */
public class ThreadDemo {

	public static void main(String[] args) {
		// thread方式一
		// MyThread thread1 = new MyThread("A");
		// MyThread thread2 = new MyThread("B");
		// thread1.start();
		// thread2.start();

		// thread 方式2
		MyThread thread1 = new MyThread("A");
		new Thread(thread1).start();
		new Thread(thread1).start();

		// runnable调用方式一
		// new Thread(new Thread2("C")).start();
		// new Thread(new Thread2("D")).start();
	}
}

class MyThread extends Thread {
	private String name;

	public MyThread(String s) {
		this.name = s;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(name + "运行：" + i + "--->" + Thread.currentThread().getName());
		}
	}
}

/**
 * 适合多个相同的程序代码的线程去处理同一个资源
 * 可以避免java中的单继承的限制
 * 增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
 * 线程池只能放入实现Runable或callable类线程，不能直接放入继承Thread的类
 *
 * */
class Thread2 implements Runnable {
	private String name;

	public Thread2(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行  :  " + i);
			try {
				Thread.sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}