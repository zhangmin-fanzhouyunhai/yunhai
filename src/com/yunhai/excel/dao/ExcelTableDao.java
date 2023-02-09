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
		 * CSVFormat.RFC4180.parse(in)������ȡcsv�ļ��а�����ͷ���������ݡ�
		 * CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);�������ǽ���һ����Ϊ��ͷ����ȡ��
		 */
		records = CSVFormat.RFC4180.parse(in); 
		int recordI = 1;
		/**
		 * ����Ĳ��ֶ�ȡcsv�ļ��ı�ͷ���֡�
		 */
		Iterator<CSVRecord>iterator=records.iterator();
		CSVRecord record =iterator.next();
		List<String> excelHeaderList= new ArrayList<String>();
		for (int vI = 0; vI < record.size(); vI++) {
			System.out.println(vI + ":" + record.get(vI));
			excelHeaderList.add(record.get(vI));
		}
		/**
		 * ����Ĳ��ֶ�ȡcsv�ļ��ı�ͷ���֡������Ǿɷ�����
		 */
		/*
		for (CSVRecord record : records) {
			if (recordI == 1) {

				System.out.println("1:" + record.toString());// ��ӡ��������
				for (int vI = 0; vI < record.size(); vI++) {
					System.out.println(vI + ":" + record.get(vI));
				}
				System.out.println("2:" + record.size());// ��ӡ�����ж��ٸ�ֵ
				System.out.println("3:" + record.getRecordNumber());// ��ӡ��������
				System.out.println("4:" + record.get(0));// ���������ض�Ӧֵ
				System.out.println("recordI:" + recordI);// ���������ض�Ӧֵ
				// System.out.println(record.get("id"));//�����Ʒ��ض�Ӧֵ
				recordI++; 
				break;
			}
		} */
		/*
		 * ����Ĳ��ֶ�ȡcsv�ļ��еķǱ�ͷ���ֵ�����
		 */
		/*Iterator<CSVRecord> iterator = records.iterator(); 
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();

			System.out.println(csvRecord.get(0));
		} */

		//�ر�������
		in.close();
		return excelHeaderList;
	}



	/**
	 * �ж�Excel�İ汾,��ȡWorkbook
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
