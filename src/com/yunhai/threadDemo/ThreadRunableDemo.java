package com.yunhai.threadDemo;

public class ThreadRunableDemo {

	public static void main(String[] args) {
		window1 w = new window1();

		// 虽然有三个线程，但是只有一个窗口类实现的Runnable方法，由于三个线程共用一个window对象，所以自动共用100张票

		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);

		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");

		t1.start();
		t2.start();
		t3.start();
	}
}

class window1 implements Runnable {

	private int ticket = 100;

	@Override
	public void run() {
		while (ticket > 0) { 
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "当前售出：第" + ticket + "张票");
				ticket--;
		}
	}
}