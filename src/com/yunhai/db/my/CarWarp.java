package com.yunhai.db.my;

public class CarWarp implements Car {
	private Car car;

	public CarWarp(Car car) {
		this.car = car;
	}

	@Override
	public void run() {
		System.out.println("���ϵ��");
		System.out.println("�����ڿ���5���ư���...");
	}

	@Override
	public void stop() {
		car.stop();
	}
}
