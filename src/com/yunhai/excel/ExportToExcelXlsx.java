package com.yunhai.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.yunhai.beanutils.DateFormatUtil;
import com.yunhai.db.orm.TableColumnProperty;
import com.yunhai.db.util.DbUtil;
import com.yunhai.excel.orm.PmsQuexian;
import com.yunhai.excel.service.PmsQuexianService;

public class ExportToExcelXlsx {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		ExportToExcelXlsx exportToExcelXlsx = new ExportToExcelXlsx();  
			String tableName = "MID_ERP_ITEM";
			int recordQuantity = 20000;
			Double maxUsedMemoryPercentLimit = 0.2;
			/**
			 * ������Ҫ���ƶ�ȡ�ļ�¼����������������Ҫ���Ѿ�ʹ�ÿռ���� ���¸�д��excel�Ŀռ��С�� ��ˣ����ռ����Ҫ����һ���ʵ����ռ�ȡ�
			 */
			Double minFreeMemmoryPercentLimit = 0.5;//
			// exportToExcelXlsx.exportTableToXlsx(recordQuantity, tableName, maxUsedMemoryPercentLimit,
			// minFreeMemmoryPercentLimit);
			tableName = "MID_PMS_ITEM";
			recordQuantity = 50000;
			maxUsedMemoryPercentLimit = 0.2;
			minFreeMemmoryPercentLimit = 0.5;
			// exportToExcelXlsx.exportTableToXlsx(recordQuantity, tableName,
			// maxUsedMemoryPercentLimit,minFreeMemmoryPercentLimit);
			tableName = "ERP_ITEM_DISCARD";
			recordQuantity = 50000;
			maxUsedMemoryPercentLimit = 0.2;
			minFreeMemmoryPercentLimit = 0.5;
			//exportToExcelXlsx.exportTableToXlsx(recordQuantity, tableName, maxUsedMemoryPercentLimit, minFreeMemmoryPercentLimit);
			tableName = "M_TABLE";
			recordQuantity = 50000;
			maxUsedMemoryPercentLimit = 0.2;
			minFreeMemmoryPercentLimit = 0.5;
			//exportToExcelXlsx.exportTableToXlsx(recordQuantity, tableName, maxUsedMemoryPercentLimit, minFreeMemmoryPercentLimit);

			tableName = "MID_ERP_ITEM";
			recordQuantity = 50000;
			maxUsedMemoryPercentLimit = 0.2;
			minFreeMemmoryPercentLimit = 0.5;
			//exportToExcelXlsx.exportTableToXlsx(recordQuantity, tableName, maxUsedMemoryPercentLimit, minFreeMemmoryPercentLimit);
			
			// tableName = "MID_PMS_ITEM20_5CIRCUIT_BREAK";
			//
			tableName = "MID_PMS_ITEM";
			
			recordQuantity = 50000;
			maxUsedMemoryPercentLimit = 0.6;
			minFreeMemmoryPercentLimit = 0.3;
			// 
			exportToExcelXlsx.exportTableToXlsx(recordQuantity, tableName,maxUsedMemoryPercentLimit,
			// 
					minFreeMemmoryPercentLimit);
			tableName = "MID_PMS_ITEM20_5ISOLATE_SWITCH";
			recordQuantity = 50000;
			maxUsedMemoryPercentLimit = 0.6;
			minFreeMemmoryPercentLimit = 0.3;
			// exportToExcelXlsx.exportTableToXlsx(recordQuantity, tableName,maxUsedMemoryPercentLimit,
			// minFreeMemmoryPercentLimit); 
	}

	public void ff2(int recordQuantity, String tableName, Double maxUsedMemoryPercentLimit,
			Double minFreeMemmoryPercentLimit) throws IOException, ParseException {

		ExportToExcelXlsx exportToExcelXlsx = new ExportToExcelXlsx();
		String classString = "com.yicheng.excel.orm.MidErpItem";
		// String tableName = "MID_ERP_ITEM";
		// int recordQuantity = 20000;
		List list = null;
		try {
			// list=
			// int recordQuantity = 65534;
			// int recordQuantity = 50000;
			exportToExcelXlsx.exportTableToXlsx(recordQuantity, tableName, maxUsedMemoryPercentLimit,
					minFreeMemmoryPercentLimit);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*
			 * for(int listI=0;listI<list.size();listI++) {
			 * System.out.println("MID_ERP_ITEM_ID="+((MidErpItem)list.get(listI)).
			 * getMidErpItemId()); }
			 */
	}

	public boolean writeWithRecordLimitNumberIntoXlxs(List<TableColumnProperty> headList, String tableName, List list,
			int recordQuantity, int columnNameOrComment) throws IOException {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		File file = new File("D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xlsx");
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet(tableName);
		FileOutputStream out = new FileOutputStream(file);
		Runtime run = Runtime.getRuntime();
		Double maxMem = 0.0;
		Double freeMem = 0.0;
		Double totalMem = 0.0;
		XSSFRow row0 = sheet.createRow(0);

		for (int colI = 0; colI < headList.size(); colI++) {
			XSSFCell cell = row0.createCell(colI);
			cell.setCellValue(headList.get(colI).getColumnName());
		}
		List rowValueList = null;
		System.out.println("list.size():" + list.size());
		for (int rowI = 0; rowI < list.size(); rowI++) {
			/*
			 * int outputFileNumber = rowI / recordQuantity; ԭʼ������ͨ������ÿ��excel��ŵ�����¼������
			 */
			int outputFileNumber = rowI / recordQuantity;
			if ((rowI % recordQuantity) == 0 && rowI != 0) {
				System.out.println("freeMemory(freeMemory)/totalMemory(usedMemory)="
						+ new Double(run.freeMemory()) / new Double(run.totalMemory()));
				// д�����ݲ��ر��ļ�
				// System.out.println("I'm Here!");
				System.out.println("д��ǰ......");
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				System.out.println("rowI=" + rowI + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / totalMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));
				book.write(out);
				book.close();
				System.out.println("д����......");
				System.gc();
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				System.out.println("rowI=" + rowI + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / totalMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));
				out.close();
				out = null;
				now = new Date();
				nowdate = df.format(now);
				file = new File("D:/temp/" + tableName + "_" + nowdate + "_" + outputFileNumber + ".xlsx");
				out = new FileOutputStream(file);
				book = new XSSFWorkbook();
				sheet = book.createSheet(tableName);
				row0 = sheet.createRow(0);
				for (int colI = 0; colI < headList.size(); colI++) {
					XSSFCell cell = row0.createCell(colI);
					cell.setCellValue(headList.get(colI).getColumnName());
				}
			}
			int recordQuantityTimes = outputFileNumber * recordQuantity;

			run = Runtime.getRuntime();
			maxMem = new Double(run.maxMemory() / 1024 / 1024);
			freeMem = new Double(run.freeMemory() / 1024 / 1024);
			totalMem = new Double(run.totalMemory() / 1024 / 1024);
			if (rowI % 10000 == 0) {
				System.out.println("Number of row=" + (rowI));
			}

			rowValueList = (List) list.get(rowI);
			XSSFRow row = sheet.createRow(rowI + 1 - recordQuantityTimes);
			/**
			 * ���ÿһ�еļ�¼��sheet����
			 */
			for (int colI = 0; colI < rowValueList.size(); colI++) {
				XSSFCell cell = row.createCell(colI);
				cell.setCellValue(rowValueList.get(colI).toString());
			}
		}
		book.write(out);
		book.close();
		out.close();// �ر��ļ���
		out = null;
		/**
		 * ����freeMemPercent�ᱻ�������ƶ���ļ�¼�������� �����ִ�к��������Ƚϴ󣬴ﵽ��������ʱ�������˹����ļ�¼��
		 */
		System.gc();//
		return true;

	}

	public boolean writeIntoXlxs(List<TableColumnProperty> headList, String tableName, List list, int recordQuantity,
			int columnNameOrComment) throws IOException {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String nowdate = df.format(now);
		File file = new File("D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xlsx");
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet(tableName);
		FileOutputStream out = new FileOutputStream(file);
		Runtime run = Runtime.getRuntime();
		Double maxMem = 0.0;
		Double freeMem = 0.0;
		Double totalMem = 0.0;
		XSSFRow row0 = sheet.createRow(0);

		/**
		 * ����Ĳ��ֶ�excel���еĵ�һ�������ͷ
		 */
		for (int colI = 0; colI < headList.size(); colI++) {
			XSSFCell cell = row0.createCell(colI);
			cell.setCellValue(headList.get(colI).getColumnName());
		}
		List rowValueList = null;
		System.out.println("list.size():" + list.size());
		int aheadFileRecordNumber = 0;
		int outputFileNumber = 0;
		for (int rowI = 0; rowI < list.size(); rowI++) {
			/*
			 * ����aheadFileRecordNumber����¼ǰһ��excel�ļ��д�ŵļ�¼������ ��֧�Ż������δʹ���ڴ�ռ�ķ������м�¼�ĵ�����
			 * 
			 */
			if ((new Double(run.totalMemory()) / new Double(run.maxMemory())) == 1
					&& (new Double(run.freeMemory()) / new Double(run.totalMemory())) < 0.20) {
				aheadFileRecordNumber = rowI;
				System.out.println("freeMemory(freeMemory)/totalMemory(usedMemory)="
						+ new Double(run.freeMemory()) / new Double(run.totalMemory()));
				// д�����ݲ��ر��ļ�
				// System.out.println("I'm Here!");
				System.out.println("д��ǰ......");
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				System.out.println("rowI=" + rowI + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / totalMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));
				book.write(out);
				book.close();
				System.out.println("д����......");
				System.gc();
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				System.out.println("rowI=" + rowI + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / totalMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));
				out.close();
				out = null;
				now = new Date();
				nowdate = df.format(now);
				outputFileNumber++;
				file = new File("D:/temp/" + tableName + "_" + nowdate + "_" + outputFileNumber + ".xlsx");
				out = new FileOutputStream(file);
				book = new XSSFWorkbook();
				sheet = book.createSheet(tableName);
				row0 = sheet.createRow(0);
				/**
				 * ����Ĳ��ֶ�excel���еĵ�һ�������ͷ
				 */
				for (int colI = 0; colI < headList.size(); colI++) {
					XSSFCell cell = row0.createCell(colI);
					cell.setCellValue(headList.get(colI).getColumnName());
				}
			}

			run = Runtime.getRuntime();
			maxMem = new Double(run.maxMemory() / 1024 / 1024);
			freeMem = new Double(run.freeMemory() / 1024 / 1024);
			totalMem = new Double(run.totalMemory() / 1024 / 1024);
			if (rowI % 10000 == 0) {
				System.out.println("Number of row=" + (rowI));
			}

			rowValueList = (List) list.get(rowI);
			XSSFRow row = sheet.createRow(rowI + 1 - aheadFileRecordNumber);

			/**
			 * ���ÿһ�еļ�¼��sheet����
			 */
			for (int colI = 0; colI < rowValueList.size(); colI++) {
				XSSFCell cell = row.createCell(colI);
				cell.setCellValue(rowValueList.get(colI).toString());
			}
		}
		book.write(out);
		book.close();
		out.close();// �ر��ļ���
		out = null;
		/**
		 * ����freeMemPercent�ᱻ�������ƶ���ļ�¼�������� �����ִ�к��������Ƚϴ󣬴ﵽ��������ʱ�������˹����ļ�¼��
		 */
		System.gc();//
		return true;

	}

	public void exportTableToXlsx(int recordQuantity, String tableName, Double maxUsedMemoryPercentLimit,
			Double minFreeMemmoryPercentLimit)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
 
		/**
		 * �ڿ�ʼ����֮ǰ���ڴ�ռ�����������Ҫ���ͷ�freeMemory���Է�������㹻��ļ�¼��
		 * ������ŵ������̵Ľ��У�totalMemory���𽥵ļӴ�ռ������100%����50%��ͺ���ƽ������
		 * freeMemory��ռ�������С�������ƽ��ռ��ʱ����ʼ������ܹ��ڶ�ȡ���㹻��ļ�¼���ݵ�ͬʱ ��֤��������ڴ������
		 * ������Գ��ԣ����Ƶ��ڴ�freeMemoryռ�ȵ���15%ʱ�Զ�����������������Ҫ��Ϊ����ÿ���ļ���¼���������⣬
		 * ����һ��������Ҫ��Ե��ǣ�ÿ���ļ�����ļ�¼�������޷����ơ�
		 */
		System.gc();
		int columnNameOrComment = 1;
		// List<MidErpItem> list = new ArrayList<MidErpItem>();
		Connection conn = null; 
		conn = DbUtil.getConnection();
		ExportDao exportDao = new ExportDao();
		List<TableColumnProperty> headList = exportDao.getHeadList(conn, tableName, columnNameOrComment);
		System.out.println("headList.size():" + headList.size());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.s");
		Date startDate = new Date(); 
		// ����Ԥ����������һ�㶼�������������Statement
		PreparedStatement pre = null;
		// ����һ�����������
		ResultSet result = null;

		String sql = "SELECT * FROM " + tableName + " WHERE 1=1";
		//System.out.println("sql:" + sql);
		pre = conn.prepareStatement(sql);// ʵ����Ԥ�������
		result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
		// json����
		JSONObject jsonObj = new JSONObject();
		// ��ȡ����
		ResultSetMetaData rsd = result.getMetaData();
		int columnCount = rsd.getColumnCount();
		System.out.println("Ready in loop!");
		int i = 1;
		Runtime run = Runtime.getRuntime();
		Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
		Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
		Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
		int outj = 1;
		// long usedMem = maxMem - freeMem;
		// ����ResultSet�е�ÿ������
		// long usedMem = maxMem - freeMem;
		// ����ResultSet�е�ÿ������

		List list = new ArrayList<>();
		while (result.next()) {
			run = Runtime.getRuntime();
			maxMem = new Double(run.maxMemory() / 1024 / 1024);// ��ȡ��ǰ����ڴ�ռ䡣
			freeMem = new Double(run.freeMemory() / 1024 / 1024);// ��ȡ��ʹ�õ��ڴ�ռ�
			totalMem = new Double(run.totalMemory() / 1024 / 1024);// ��ȡ�Ѿ�ʹ�õ��ڴ�ռ�
			i++;
			if (((new Double(run.totalMemory()) / new Double(run.maxMemory()) > maxUsedMemoryPercentLimit)
					&& (new Double(run.freeMemory()) / new Double(
							run.totalMemory()) < (new Double(run.totalMemory()) / new Double(run.maxMemory())
									+ minFreeMemmoryPercentLimit) / 2))) {
				System.out.println("output " + (outj++) + "times!");
				boolean BResult = false;

				System.out.println("д����ʼ��");
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				System.out.println("i=" + i + ",usedMemPercent=" + new Double(totalMem / maxMem) + ",freeMemPercent="
						+ new Double(freeMem / totalMem) + ",maxMem=" + (maxMem) + ",freeMem=" + (freeMem) + ",usedMem="
						+ (totalMem) + ",totalMem=" + (totalMem));
				BResult = writeIntoXlxs(headList, tableName, list, recordQuantity, columnNameOrComment);
				list.clear();
				list = null;
				list = new ArrayList<>();

				System.out.println("����һ�Σ�");
				System.out.println("����ǰ��");
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				System.out.println("i=" + i + ",usedMemPercent=" + new Double(totalMem / maxMem) + ",freeMemPercent="
						+ new Double(freeMem / totalMem) + ",maxMem=" + (maxMem) + ",freeMem=" + (freeMem) + ",usedMem="
						+ (totalMem) + ",totalMem=" + (totalMem));
				System.gc();// ����һ���ڴ�ռ������
				System.out.println("�����");
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				System.out.println("i=" + i + ",usedMemPercent=" + new Double(totalMem / maxMem) + ",freeMemPercent="
						+ new Double(freeMem / totalMem) + ",maxMem=" + (maxMem) + ",freeMem=" + (freeMem) + ",usedMem="
						+ (totalMem) + ",totalMem=" + (totalMem));
			}
			List valueList = new ArrayList<>();
			// ����ÿһ��
			for (int colI = 1; colI <= columnCount; colI++) {
				String columnName = rsd.getColumnLabel(colI);

				String value = result.getString(columnName);

				if (rsd.getColumnType(colI) == 93) {// 93Ϊʱ������ DATE:93 is code of date(DATE)
					if (value == null) {
						valueList.add(colI - 1, "");
					} else {
						valueList.add(colI - 1, result.getDate(columnName));
					}
				} else if (rsd.getColumnType(colI) == 12) {// 12Ϊ�ַ������� VARCHAR2()
					if (value == null) {
						valueList.add(colI - 1, "");
					} else {
						valueList.add(colI - 1, result.getString(columnName));
					}
				} else if (rsd.getColumnType(colI) == -9) {// -9Ϊ�ַ������� NVARCHAR2()
					if (value == null) {
						valueList.add(colI - 1, "");
					} else {
						valueList.add(colI - 1, result.getString(columnName));
					}
				} else if (rsd.getColumnType(colI) == 2) {// 2Ϊ˫�������� NUMBER
					if (value == null) {
						valueList.add(colI - 1, "");
					} else {
						valueList.add(colI - 1, result.getString(columnName).toString());
					}
				} else {
					System.out.println("columnName=" + columnName + ", value=" + value);
					valueList.add(colI - 1, result.getString(columnName).toString());
				}
			}
			list.add(valueList);
		}

		if (list.size() != 0) {
			System.out.println("The last times output!");
			boolean BResult = false;
			BResult = writeIntoXlxs(headList, tableName, list, recordQuantity, columnNameOrComment);
			list.clear();
		}
		Date endDate = new Date();
		System.out.println("startTime:" + startDate.toLocaleString()+
				"times:"+startDate.getTime()/1000+
				",currentTimeMillis():"+System.currentTimeMillis());
		System.out.println("endTime:" + endDate.toLocaleString()+
				"times:"+endDate.getTime()/1000+
				",currentTimeMillis():"+System.currentTimeMillis());
		System.out.println("Total time=" + (endDate.getTime() - startDate.getTime()));
		// return null;
	}

	@Autowired
	public void exportMidPmsItemExtendToXLSX(String xlsxFilePath) {
		Connection conn = null;
		conn = DbUtil.getConnection();
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		String nowdate = df.format(now);

		OutputStream out = null;
		try {
			System.out.println("System.getProperty(\"user.dir\"):" + System.getProperty("user.dir"));
			System.out.println("finalXlsxPath:=" + xlsxFilePath);
			File finalXlsxFile = new File(xlsxFilePath);// +"/"+nowdate+".xlsx");
			System.out.println("finalXlsxFile.getName():" + finalXlsxFile.getName());
			Workbook workBook = getWorkbok(finalXlsxFile);
			System.out.println("nowdate=" + nowdate);

			// sheet 对应�?个工作页
			Sheet sheet = workBook.getSheetAt(0);
			// 创建预编译语句对象，�?般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建�?个结果集对象
			ResultSet result = null;
			String sql = "select * from PMS_QUEXIAN";// 预编译语�?
			try {
				pre = conn.prepareStatement(sql);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参�?
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中�?有的数据
			List<PmsQuexian> list = PmsQuexianService.getAllByDb();
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				/*
				 * if(i==2000) { break; }
				 */
				// 创建�?行：从第二行�?始，跳过属�?�列
				Row row = sheet.createRow(i + 1);
				row.createCell(0).setCellValue(list.get(i).getPmsQuexianId());
				// System.out.println("----------------------" +
				// labelAi.toString());
				row.createCell(1).setCellValue(list.get(i).getCalYear().toString());
				row.createCell(2).setCellValue(list.get(i).getVersion());
				row.createCell(3).setCellValue(list.get(i).getSbbm());
				row.createCell(4).setCellValue(list.get(i).getDwmx());
				row.createCell(5).setCellValue(list.get(i).getQxbh());
				row.createCell(6).setCellValue(list.get(i).getZclxbm());
				row.createCell(7).setCellValue(list.get(i).getSblx());

				// System.out.println("getTynf");

				if (null != list.get(i).getTynf()) {
					row.createCell(8).setCellValue(list.get(i).getTynf().toString());
				}
				// System.out.println("getDydj");
				row.createCell(9).setCellValue(list.get(i).getDydj());
				row.createCell(10).setCellValue(list.get(i).getZzsmc());
				row.createCell(11).setCellValue(list.get(i).getSbxlmc());
				row.createCell(12).setCellValue(list.get(i).getQxms());
				row.createCell(13).setCellValue(list.get(i).getQxbw());

				row.createCell(14).setCellValue(list.get(i).getQxzryy());
				row.createCell(15).setCellValue(list.get(i).getSfxq());
				row.createCell(16).setCellValue(list.get(i).getSfjs());
				row.createCell(17).setCellValue(list.get(i).getZryybm());
				row.createCell(18).setCellValue(list.get(i).getQxjsyy());
				row.createCell(19).setCellValue(list.get(i).getJsyybm());
				// System.out.println("getQxdj");

				row.createCell(20).setCellValue(list.get(i).getQxdj());
				// System.out.println("getFsrq=" +
				// df.format(list.get(i).getFsrq()));
				if (null == list.get(i).getFsrq()) {
					row.createCell(21).setCellValue(new String(""));
				} else {
					// System.out.println("getFsrq=" +
					// df.format(list.get(i).getFsrq()));
					row.createCell(21).setCellValue(df.format(list.get(i).getFsrq()).toString());
				}
				if (null == list.get(i).getXqrq()) {
					row.createCell(22).setCellValue(new String(""));
				} else {
					// System.out.println("getXqrq=" +
					// df.format(list.get(i).getXqrq()));
					row.createCell(22).setCellValue(df.format(list.get(i).getXqrq()).toString());
				}
				row.createCell(23).setCellValue(list.get(i).getBz());
				row.createCell(24).setCellValue(list.get(i).getXqsj().toString());
				row.createCell(25).setCellValue(list.get(i).getJsyy());

				// System.out.println("getZryy");
				row.createCell(26).setCellValue(list.get(i).getZryy());
				row.createCell(27).setCellValue(list.get(i).getCwbm());
				row.createCell(28).setCellValue(list.get(i).getQfzd());
				// Label labelADi = null;
				if (null == list.get(i).getCcrq()) {
					row.createCell(29).setCellValue(new String(""));
				} else {
					// System.out.println("getCcrq=" +
					// df.format(list.get(i).getCcrq()));
					row.createCell(29).setCellValue(df.format(list.get(i).getCcrq()));
				}
				// System.out.println("getZcxlms");
				row.createCell(30).setCellValue(list.get(i).getZcxlms());
				// System.out.println("getQxnr");

				row.createCell(31).setCellValue(list.get(i).getQxnr());
				row.createCell(32).setCellValue(list.get(i).getZclxbm2());
				row.createCell(33).setCellValue(list.get(i).getEquipementName());
				row.createCell(34).setCellValue(list.get(i).getLineStationName());
				// System.out.println("getLineStationName");
				System.out.println("i=" + i);
				out = new FileOutputStream(xlsxFilePath);
				out.flush();

				workBook.write(out);
			}

			now = new Date();
			nowdate = df.format(now);
			System.out.println("nowdate=" + nowdate);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�������");

	}

	@Autowired
	public void createXLSX(String finalXlsxPath) {
		Connection conn = null;
		conn = DbUtil.getConnection();
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		String nowdate = df.format(now);

		OutputStream out = null;
		try {
			System.out.println("System.getProperty(\"user.dir\"):" + System.getProperty("user.dir"));
			System.out.println("finalXlsxPath:=" + finalXlsxPath);
			File finalXlsxFile = new File(finalXlsxPath);// +"/"+nowdate+".xlsx");
			System.out.println("finalXlsxFile.getName():" + finalXlsxFile.getName());
			Workbook workBook = getWorkbok(finalXlsxFile);
			System.out.println("nowdate=" + nowdate);

			// sheet 对应�?个工作页
			Sheet sheet = workBook.getSheetAt(0);
			// 创建预编译语句对象，�?般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建�?个结果集对象
			ResultSet result = null;
			String sql = "select * from PMS_QUEXIAN";// 预编译语�?
			try {
				pre = conn.prepareStatement(sql);
				result = pre.executeQuery();// 执行查询，注意括号中不需要再加参�?
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 实例化预编译语句
				// 查询数据库中�?有的数据
			List<PmsQuexian> list = PmsQuexianService.getAllByDb();
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				/*
				 * if(i==2000) { break; }
				 */
				// 创建�?行：从第二行�?始，跳过属�?�列
				Row row = sheet.createRow(i + 1);
				row.createCell(0).setCellValue(list.get(i).getPmsQuexianId());
				// System.out.println("----------------------" +
				// labelAi.toString());
				row.createCell(1).setCellValue(list.get(i).getCalYear().toString());
				row.createCell(2).setCellValue(list.get(i).getVersion());
				row.createCell(3).setCellValue(list.get(i).getSbbm());
				row.createCell(4).setCellValue(list.get(i).getDwmx());
				row.createCell(5).setCellValue(list.get(i).getQxbh());
				row.createCell(6).setCellValue(list.get(i).getZclxbm());
				row.createCell(7).setCellValue(list.get(i).getSblx());

				// System.out.println("getTynf");

				if (null != list.get(i).getTynf()) {
					row.createCell(8).setCellValue(list.get(i).getTynf().toString());
				}
				// System.out.println("getDydj");
				row.createCell(9).setCellValue(list.get(i).getDydj());
				row.createCell(10).setCellValue(list.get(i).getZzsmc());
				row.createCell(11).setCellValue(list.get(i).getSbxlmc());
				row.createCell(12).setCellValue(list.get(i).getQxms());
				row.createCell(13).setCellValue(list.get(i).getQxbw());

				row.createCell(14).setCellValue(list.get(i).getQxzryy());
				row.createCell(15).setCellValue(list.get(i).getSfxq());
				row.createCell(16).setCellValue(list.get(i).getSfjs());
				row.createCell(17).setCellValue(list.get(i).getZryybm());
				row.createCell(18).setCellValue(list.get(i).getQxjsyy());
				row.createCell(19).setCellValue(list.get(i).getJsyybm());
				// System.out.println("getQxdj");

				row.createCell(20).setCellValue(list.get(i).getQxdj());
				// System.out.println("getFsrq=" +
				// df.format(list.get(i).getFsrq()));
				if (null == list.get(i).getFsrq()) {
					row.createCell(21).setCellValue(new String(""));
				} else {
					// System.out.println("getFsrq=" +
					// df.format(list.get(i).getFsrq()));
					row.createCell(21).setCellValue(df.format(list.get(i).getFsrq()).toString());
				}
				if (null == list.get(i).getXqrq()) {
					row.createCell(22).setCellValue(new String(""));
				} else {
					// System.out.println("getXqrq=" +
					// df.format(list.get(i).getXqrq()));
					row.createCell(22).setCellValue(df.format(list.get(i).getXqrq()).toString());
				}
				row.createCell(23).setCellValue(list.get(i).getBz());
				row.createCell(24).setCellValue(list.get(i).getXqsj().toString());
				row.createCell(25).setCellValue(list.get(i).getJsyy());

				// System.out.println("getZryy");
				row.createCell(26).setCellValue(list.get(i).getZryy());
				row.createCell(27).setCellValue(list.get(i).getCwbm());
				row.createCell(28).setCellValue(list.get(i).getQfzd());
				// Label labelADi = null;
				if (null == list.get(i).getCcrq()) {
					row.createCell(29).setCellValue(new String(""));
				} else {
					// System.out.println("getCcrq=" +
					// df.format(list.get(i).getCcrq()));
					row.createCell(29).setCellValue(df.format(list.get(i).getCcrq()));
				}
				// System.out.println("getZcxlms");
				row.createCell(30).setCellValue(list.get(i).getZcxlms());
				// System.out.println("getQxnr");

				row.createCell(31).setCellValue(list.get(i).getQxnr());
				row.createCell(32).setCellValue(list.get(i).getZclxbm2());
				row.createCell(33).setCellValue(list.get(i).getEquipementName());
				row.createCell(34).setCellValue(list.get(i).getLineStationName());
				// System.out.println("getLineStationName");
				System.out.println("i=" + i);
				out = new FileOutputStream(finalXlsxPath);
				out.flush();

				workBook.write(out);
			}

			now = new Date();
			nowdate = df.format(now);
			System.out.println("nowdate=" + nowdate);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�������");

	}

	/**
	 * 判断Excel的版�?,获取Workbook
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
