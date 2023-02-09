package com.yunhai.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtil {
	/**
	 * 将result的结果集转化成json数组格式
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	public static JSONArray formatRsToJsonArray(ResultSet rs)throws Exception{
		ResultSetMetaData md=rs.getMetaData();
		int num=md.getColumnCount();
		JSONArray array=new JSONArray();
		while(rs.next()){
			JSONObject mapOfColValues=new JSONObject();
			for(int i=1;i<=num;i++){
				mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
			}
			//array.add(mapOfColValues);
			array.put(mapOfColValues);
		}
		return array;
	}

}
