package com.yunhai.threadDemo;

public class ThreadRunableDemo {

	public static void main(String[] args) {
		window1 w = new window1();

		// ��Ȼ�������̣߳�����ֻ��һ��������ʵ�ֵ�Runnable���������������̹߳���һ��window���������Զ�����100��Ʊ

		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);

		t1.setName("����1");
		t2.setName("����2");
		t3.setName("����3");

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
				System.out.println(Thread.currentThread().getName() + "��ǰ�۳�����" + ticket + "��Ʊ");
				ticket--;
		}
	}
}