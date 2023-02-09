package com.yunhai.excel.service;

import java.io.IOException;
import java.text.ParseException;

import com.yunhai.excel.dao.CsvImportDao;

public class CsvImportService {
	public void oriOpticalCableSectionSave(String pathStr, String versionValue, String calYear) {

		//System.out.println("pathStr="+pathStr);
		try {
			new CsvImportDao().csvOriOpticalCableSectionAdd(pathStr, versionValue, calYear);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void csvZfiSwzcDiscSave(String pathStr, String versionValue, String calYear) {

		//System.out.println("pathStr="+pathStr);
		try {
			new CsvImportDao().csvZfiSwzcDiscAdd(pathStr, versionValue, calYear);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void spareEquipmentImportSave(String pathStr, String versionValue, String calYear) {
		//System.out.println("pathStr="+pathStr);
				try {
					new CsvImportDao().csvspareEquipmentImportAdd(pathStr, versionValue, calYear);
				} catch (IOException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
