package com.itheima.domain.day16.listener.life;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttrListener implements ServletContextAttributeListener {

	@Override
	//���
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("��servletContext�������һ������,����Ϊ��"+arg0.getName());
	}

	@Override
	//�Ƴ�
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("��servletContext���Ƴ���һ������,����Ϊ��"+arg0.getName());
	}

	@Override
	//�滻
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("��servletContext���滻��һ������,����Ϊ��"+arg0.getName());
	}

}
