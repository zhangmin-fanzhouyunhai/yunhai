package com.itheima.service;

import java.io.IOException;

import com.itheima.dao.CustomerDao;
import com.itheima.dao.PmsItemImportDao;
import com.itheima.domain.Customer;

public class PmsItemImportService {

	public PmsItemImportService() { 
		// TODO Auto-generated constructor stub
	}

	public void importPmsItem() {
		// TODO Auto-generated constructor stub
 
			String dataVersion = "O_2020_2";
			String calYear = "2020";
			String pathStr = "D:/temp/hebei/PMS/一、输电线路.csv";
			try {
				new PmsItemImportDao().csvPmsItemShuLineAdd(pathStr, dataVersion, calYear);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
	}

}
