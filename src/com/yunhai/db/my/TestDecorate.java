package com.yunhai.db.my;

public class TestDecorate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QQ qq=new QQ();
		//qq.run();
		//qq.stop();
		
		CarWarp warp=new CarWarp(qq);
		warp.run();
		warp.stop();
	}

}
