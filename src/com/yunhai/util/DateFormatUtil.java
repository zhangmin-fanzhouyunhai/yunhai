package com.yunhai.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class DateFormatUtil {
	//DateFormatUtil.parseDate();
public static Date parseDate(String dateString) {
	Date date=null;
	try {
		date= DateUtils.parseDate(dateString.trim(), 
				"YYYY��",
				"YYYY��-MM��", 
				"YYYY��-MM��-dd��",
				"dd-MM��-yy", 
				"dd-MM��-yy HH:mm:ss",
				"dd-MM��-yy HH:mm:ss.s", 
				"dd-MM��-yy HH:mm", 
				"dd-MM�� -yy", 
				"dd-MM�� -yy HH:mm:ss", 
				"dd-MM�� -yy HH:mm:ss.s",
				"dd-MM�� -yy HH:mm",
				"dd-MM�� -yy", 
				"dd-MM�� -yy HH:mm:ss", 
				"dd-MM�� -yy HH:mm:ss.s", 
				"dd-MM�� -yy HH:mm",
				"yyyy/MM/dd",
				"yyyy/MM/dd HH:mm:ss",
				"yyyy/MM/dd HH:mm",  
				"yyyy/MM/dd HH:mm:ss.s", 
				"yyyy-MM-dd", 
				"yyyy-MM-dd HH:mm:ss",
				"yyyy-MM-dd HH:mm:ss.s",
				"yyyy-MM-dd HH:mm",
				"yyyy-MM",
				"yyyy-MM-dd",
				"yyyy/MM", 
				"yyyy"
				);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return date;
}
}