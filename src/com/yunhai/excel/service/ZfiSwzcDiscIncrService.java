package com.yunhai.excel.service;

import java.io.IOException;
import java.text.ParseException;

import com.yunhai.excel.dao.ZfiSwzcDiscIncrDao;

public class ZfiSwzcDiscIncrService {
	public void save(String pathStr, String versionValue, String calYear) {

		//System.out.println("pathStr="+pathStr);
		try {
			new ZfiSwzcDiscIncrDao().csvZfiSwzcDiscAdd(pathStr, versionValue, calYear);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
