package com.itheima.domain.day16.listener.life;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttrListener implements ServletContextAttributeListener {

	@Override
	//添加
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("在servletContext中添加了一个属性,属性为："+arg0.getName());
	}

	@Override
	//移除
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("在servletContext中移除了一个属性,属性为："+arg0.getName());
	}

	@Override
	//替换
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("在servletContext中替换了一个属性,属性为："+arg0.getName());
	}

}
