package com.yunhai.threadDemo;

public class Account {
	private int money;
	public Account(int money) {
		this.money=money;
	}

	public synchronized void getMoney(int money) {
		//注意这个地方必须用while循环，因为即便再存入钱也有可能比取的要少
		while(this.money<money) {
			System.out.println("取款："+money+"，全额："+this.money+",余额不足，正在等待存款......");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.money=this.money-money;
			System.out.println("取出："+money+", 还剩余："+this.money);
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
		System.out.println("新存入："+money+",共计："+this.money);
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
//存款类
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
//取款类
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




