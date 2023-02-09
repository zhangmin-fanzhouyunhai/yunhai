package com.yunhai.excel;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.serializer.ValueFilter;

public class DateValueFilter implements ValueFilter {

	@Override
	public Object process(Object object, String name, Object value) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(name)&&StringUtils.endsWithIgnoreCase(name, "time")
			&& value instanceof Long){
				return new Date((Long)value);
			}
		return value;
	}

}
