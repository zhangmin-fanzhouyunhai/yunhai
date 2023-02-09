package com.yunhai.util;

public class StringUtil {

	public static Boolean isNotEmpty(String id) {

		if (id.trim().length() == 0) {
			return false;
		}
		return true;
	}

}
