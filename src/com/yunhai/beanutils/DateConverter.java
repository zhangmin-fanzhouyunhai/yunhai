package com.yunhai.beanutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.beanutils.Converter;

/**
 * 
 * 日期转换对象，使用该转换器，在BaseForm当中做一下注册， 系统自动地帮助
 * 字符的日期表示转换为java.util.Date对象.
 * 
 * @author ZhangMin. 
 * Create Time：2021-08-28 15:17:47.
 */
public class DateConverter implements Converter {
	/**
	 * 日期格式化对象.
	 */
	private static SimpleDateFormat df = new SimpleDateFormat();

	/**
	 * 模式集合.
	 */
	private static Set<String> patterns = new HashSet<String>();
	// 注册一下日期的转换格式
	static {
		DateConverter.patterns.add("yyyy-MM-dd");
		DateConverter.patterns.add("yyyy-MM-dd HH:mm");
		DateConverter.patterns.add("yyyy-MM-dd HH:mm:ss");
		DateConverter.patterns.add("YYYY年");
		DateConverter.patterns.add("YYYY年-MM月"); 
		DateConverter.patterns.add("YYYY年-MM月-dd日"); 
		DateConverter.patterns.add("dd-MM月-yy"); 
		DateConverter.patterns.add("dd-MM月-yy HH:mm:ss"); 
		DateConverter.patterns.add("dd-MM月-yy HH:mm:ss.s"); 
		DateConverter.patterns.add("dd-MM月 -yy"); 
		DateConverter.patterns.add("dd-MM月 -yy HH:mm:ss"); 
		DateConverter.patterns.add("dd-MM月 -yy HH:mm:ss.s"); 
		DateConverter.patterns.add("dd-MM月 -yy HH:mm"); 
		DateConverter.patterns.add("dd-MM月 -yy"); 
		DateConverter.patterns.add("dd-MM月 -yy HH:mm:ss"); 
		DateConverter.patterns.add("dd-MM月 -yy HH:mm:ss.s"); 
		DateConverter.patterns.add("dd-MM月 -yy HH:mm"); 
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
	 * 日期转换器.
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
