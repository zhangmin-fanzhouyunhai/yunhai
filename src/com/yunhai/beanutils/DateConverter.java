package com.yunhai.beanutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.beanutils.Converter;

/**
 * 
 * ����ת������ʹ�ø�ת��������BaseForm������һ��ע�ᣬ ϵͳ�Զ��ذ���
 * �ַ������ڱ�ʾת��Ϊjava.util.Date����.
 * 
 * @author ZhangMin. 
 * Create Time��2021-08-28 15:17:47.
 */
public class DateConverter implements Converter {
	/**
	 * ���ڸ�ʽ������.
	 */
	private static SimpleDateFormat df = new SimpleDateFormat();

	/**
	 * ģʽ����.
	 */
	private static Set<String> patterns = new HashSet<String>();
	// ע��һ�����ڵ�ת����ʽ
	static {
		DateConverter.patterns.add("yyyy-MM-dd");
		DateConverter.patterns.add("yyyy-MM-dd HH:mm");
		DateConverter.patterns.add("yyyy-MM-dd HH:mm:ss");
		DateConverter.patterns.add("YYYY��");
		DateConverter.patterns.add("YYYY��-MM��"); 
		DateConverter.patterns.add("YYYY��-MM��-dd��"); 
		DateConverter.patterns.add("dd-MM��-yy"); 
		DateConverter.patterns.add("dd-MM��-yy HH:mm:ss"); 
		DateConverter.patterns.add("dd-MM��-yy HH:mm:ss.s"); 
		DateConverter.patterns.add("dd-MM�� -yy"); 
		DateConverter.patterns.add("dd-MM�� -yy HH:mm:ss"); 
		DateConverter.patterns.add("dd-MM�� -yy HH:mm:ss.s"); 
		DateConverter.patterns.add("dd-MM�� -yy HH:mm"); 
		DateConverter.patterns.add("dd-MM�� -yy"); 
		DateConverter.patterns.add("dd-MM�� -yy HH:mm:ss"); 
		DateConverter.patterns.add("dd-MM�� -yy HH:mm:ss.s"); 
		DateConverter.patterns.add("dd-MM�� -yy HH:mm"); 
		DateConverter.patterns.add("yyyy/MM/dd"); 
		DateConverter.patterns.add("yyyy/MM/dd HH:mm:ss"); 
		DateConverter.patterns.add("yyyy/MM/dd HH:mm"); 
		DateConverter.patterns.add("yyyy/MM/dd HH:mm:ss.s"); 
		DateConverter.patterns.add("yyyy-MM-dd HH:mm:ss.s"); 
		DateConverter.patterns.add("yyyy-MM");  
		DateConverter.patterns.add("yyyy/MM");  
		DateConverter.patterns.add("yyyy");  
		//DateConverter.patterns.add();  
	}

	/**
	 * ����ת����.
	 * 
	 * @param type  Class
	 * @param value Object 
	 * return Date Object.
	 */
	public Object convert(Class type, Object value) {
		if (value == null) {
			return null;
		} else if (value instanceof String) {
			Object dateObj = null;
			Iterator it = patterns.iterator();
			while (it.hasNext()) {
				try {
					String pattern = (String) it.next();
					df.applyPattern(pattern);
					dateObj = df.parse((String) value);
					break;
				} catch (ParseException ex) {
					// do iterator continue
				}
			}
			return dateObj;
		} else {
			return null;
		}
	}

}
