package com.yunhai.initial;

import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.yunhai.beanutils.DateConverter;

public class initialEvent implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
			 if(event.getApplicationContext().getParent()==null) {
					ConvertUtils.register(new DateConverter(),java.util.Date.class);
				 //System.out.println("We start now......");
			 }
	}
	
}
