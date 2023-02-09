package com.yunhai.threadDemo;

public class Account {
	private int money;
	public Account(int money) {
		this.money=money;
	}

	public synchronized void getMoney(int money) {
		//ע������ط�������whileѭ������Ϊ�����ٴ���ǮҲ�п��ܱ�ȡ��Ҫ��
		while(this.money<money) {
			System.out.println("ȡ�"+money+"��ȫ�"+this.money+",���㣬���ڵȴ����......");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.money=this.money-money;
			System.out.println("ȡ����"+money+", ��ʣ�ࣺ"+this.money);
		}
	}
	public synchronized void setMoney(int money) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.money=this.money+money;
		System.out.println("�´��룺"+money+",���ƣ�"+this.money);
		notify();
	}
	public static void main(String args[]) {
		Account account=new Account(0);
		Bank b =new Bank(account);
		Consumer c=new Consumer(account);
		new Thread(b).start();
		new Thread(c).start();
	}
}
//�����
class Bank implements Runnable{
	Account account;
	public Bank(Account account) {
		this.account=account;
	}
	public void run() {
		while(true) {
			int temp=(int)(Math.random()*1000);
			account.setMoney(temp);
		}
	}
}
//ȡ����
class Consumer implements Runnable{
	Account account;
	public Consumer(Account account) {
		this.account=account;
	}
	public void run() {
		while(true) {
			int temp=(int)(Math.random()*1000);
			account.getMoney(temp);
		}
	}
}




