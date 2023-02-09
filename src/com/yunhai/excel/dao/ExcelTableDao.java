package com.yunhai.excel.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTableDao {
	
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";
	
	public List<String> getCSVHeader(String filePathStr) throws IOException {
		File csv = new File(filePathStr);

		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		System.out.println("filePathStr=" + filePathStr);
		Iterable<CSVRecord> records;
		/*
		 * CSVFormat.RFC4180.parse(in)方法读取csv文件中包括表头的所有数据。
		 * CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);方法则是将第一行视为表头不读取。
		 */
		records = CSVFormat.RFC4180.parse(in); 
		int recordI = 1;
		/**
		 * 正面的部分读取csv文件的表头部分。
		 */
		Iterator<CSVRecord>iterator=records.iterator();
		CSVRecord record =iterator.next();
		List<String> excelHeaderList= new ArrayList<String>();
		for (int vI = 0; vI < record.size(); vI++) {
			System.out.println(vI + ":" + record.get(vI));
			excelHeaderList.add(record.get(vI));
		}
		/**
		 * 下面的部分读取csv文件的表头部分。下面是旧方法。
		 */
		/*
		for (CSVRecord record : records) {
			if (recordI == 1) {

				System.out.println("1:" + record.toString());// 打印整行内容
				for (int vI = 0; vI < record.size(); vI++) {
					System.out.println(vI + ":" + record.get(vI));
				}
				System.out.println("2:" + record.size());// 打印本行有多少个值
				System.out.println("3:" + record.getRecordNumber());// 打印本行行数
				System.out.println("4:" + record.get(0));// 按索引返回对应值
				System.out.println("recordI:" + recordI);// 按索引返回对应值
				// System.out.println(record.get("id"));//按名称返回对应值
				recordI++; 
				break;
			}
		} */
		/*
		 * 下面的部分读取csv文件中的非表头部分的数据
		 */
		/*Iterator<CSVRecord> iterator = records.iterator(); 
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();

			System.out.println(csvRecord.get(0));
		} */

		//关闭输入流
		in.close();
		return excelHeaderList;
	}



	/**
	 * 判断Excel的版本,获取Workbook
	 * 
	 * @param in
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static Workbook getWorkbok(File file) throws IOException {
		Workbook wb = null;
		FileInputStream in = new FileInputStream(file);
		if (file.getName().endsWith(EXCEL_XLS)) { // Excel&nbsp;2003
			wb = new HSSFWorkbook(in);
		} else if (file.getName().endsWith(EXCEL_XLSX)) { // Excel 2007/2010
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}
	
}
