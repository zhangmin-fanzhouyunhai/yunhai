package com.yunhai.threadDemo;

public class ThreadTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final MyData data=new MyData(25);
		for(int i=0;i<2;i++) {
			new Thread(new Runnable() {
				public void run() {
					data.add();
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					data.dec();
				}
			}).start();
		}
	}
}
class MyData{
	private int j=0;
	public MyData(int j) {
		this.j=j;
	}
	public MyData() {
		
	}
	public synchronized void add() {
		j++;
		System.out.println("线程："+Thread.currentThread().getName()+"，j为："+j);
	}
	public synchronized void dec() {
		j--;
		System.out.println("线程："+Thread.currentThread().getName()+"，j为："+j);
	}
}

