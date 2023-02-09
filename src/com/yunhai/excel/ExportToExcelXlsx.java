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
			 * 由于需要控制读取的记录总数量，即尽量不要让已经使用空间过大， 留下给写入excel的空间过小。 因此，这个占比需要设置一个适当大的占比。
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
			 * int outputFileNumber = rowI / recordQuantity; 原始方案是通过输入每个excel存放的最大记录总数量
			 */
			int outputFileNumber = rowI / recordQuantity;
			if ((rowI % recordQuantity) == 0 && rowI != 0) {
				System.out.println("freeMemory(freeMemory)/totalMemory(usedMemory)="
						+ new Double(run.freeMemory()) / new Double(run.totalMemory()));
				// 写入数据并关闭文件
				// System.out.println("I'm Here!");
				System.out.println("写出前......");
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				System.out.println("rowI=" + rowI + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / totalMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));
				book.write(out);
				book.close();
				System.out.println("写出后......");
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
			 * 输出每一行的记录至sheet表中
			 */
			for (int colI = 0; colI < rowValueList.size(); colI++) {
				XSSFCell cell = row.createCell(colI);
				cell.setCellValue(rowValueList.get(colI).toString());
			}
		}
		book.write(out);
		book.close();
		out.close();// 关闭文件流
		out = null;
		/**
		 * 由于freeMemPercent会被用来控制读入的记录的数量， 如果在执行后清除，会比较大，达到限制条件时，读入了过量的记录。
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
		 * 下面的部分对excel表中的第一行输出表头
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
			 * 后交由aheadFileRecordNumber，记录前一个excel文件中存放的记录数量， 以支撑基于最低未使用内存空间的方案进行记录的导出。
			 * 
			 */
			if ((new Double(run.totalMemory()) / new Double(run.maxMemory())) == 1
					&& (new Double(run.freeMemory()) / new Double(run.totalMemory())) < 0.20) {
				aheadFileRecordNumber = rowI;
				System.out.println("freeMemory(freeMemory)/totalMemory(usedMemory)="
						+ new Double(run.freeMemory()) / new Double(run.totalMemory()));
				// 写入数据并关闭文件
				// System.out.println("I'm Here!");
				System.out.println("写出前......");
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				System.out.println("rowI=" + rowI + ",usedMemPercent=" + new Double(totalMem / maxMem)
						+ ",freeMemPercent=" + new Double(freeMem / totalMem) + ",maxMem=" + (maxMem) + ",freeMem="
						+ (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));
				book.write(out);
				book.close();
				System.out.println("写出后......");
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
				 * 下面的部分对excel表中的第一行输出表头
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
			 * 输出每一行的记录至sheet表中
			 */
			for (int colI = 0; colI < rowValueList.size(); colI++) {
				XSSFCell cell = row.createCell(colI);
				cell.setCellValue(rowValueList.get(colI).toString());
			}
		}
		book.write(out);
		book.close();
		out.close();// 关闭文件流
		out = null;
		/**
		 * 由于freeMemPercent会被用来控制读入的记录的数量， 如果在执行后清除，会比较大，达到限制条件时，读入了过量的记录。
		 */
		System.gc();//
		return true;

	}

	public void exportTableToXlsx(int recordQuantity, String tableName, Double maxUsedMemoryPercentLimit,
			Double minFreeMemmoryPercentLimit)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
 
		/**
		 * 在开始导出之前对内存空间进行清除，主要是释放freeMemory，以方便读出足够多的记录。
		 * 随后随着导出过程的进行，totalMemory会逐渐的加大，占比趋向100%，与50%求和后做平均，则
		 * freeMemory的占比相对在小于求出的平均占比时，开始输出，能够在读取到足够多的记录数据的同时 保证不会出现内存溢出。
		 * 后面可以尝试，控制当内存freeMemory占比低于15%时自动输出，将不会出现需要人为设置每个文件记录数量的问题，
		 * 但有一个问题需要面对的是，每个文件输出的记录数量将无法控制。
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
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;

		String sql = "SELECT * FROM " + tableName + " WHERE 1=1";
		//System.out.println("sql:" + sql);
		pre = conn.prepareStatement(sql);// 实例化预编译语句
		result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		// json对象
		JSONObject jsonObj = new JSONObject();
		// 获取列数
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
		// 遍历ResultSet中的每条数据
		// long usedMem = maxMem - freeMem;
		// 遍历ResultSet中的每条数据

		List list = new ArrayList<>();
		while (result.next()) {
			run = Runtime.getRuntime();
			maxMem = new Double(run.maxMemory() / 1024 / 1024);// 获取当前最大内存空间。
			freeMem = new Double(run.freeMemory() / 1024 / 1024);// 获取可使用的内存空间
			totalMem = new Double(run.totalMemory() / 1024 / 1024);// 获取已经使用的内存空间
			i++;
			if (((new Double(run.totalMemory()) / new Double(run.maxMemory()) > maxUsedMemoryPercentLimit)
					&& (new Double(run.freeMemory()) / new Double(
							run.totalMemory()) < (new Double(run.totalMemory()) / new Double(run.maxMemory())
									+ minFreeMemmoryPercentLimit) / 2))) {
				System.out.println("output " + (outj++) + "times!");
				boolean BResult = false;

				System.out.println("写出开始！");
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

				System.out.println("清理一次！");
				System.out.println("清理前！");
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				System.out.println("i=" + i + ",usedMemPercent=" + new Double(totalMem / maxMem) + ",freeMemPercent="
						+ new Double(freeMem / totalMem) + ",maxMem=" + (maxMem) + ",freeMem=" + (freeMem) + ",usedMem="
						+ (totalMem) + ",totalMem=" + (totalMem));
				System.gc();// 进行一次内存空间的清理
				System.out.println("清理后！");
				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				System.out.println("i=" + i + ",usedMemPercent=" + new Double(totalMem / maxMem) + ",freeMemPercent="
						+ new Double(freeMem / totalMem) + ",maxMem=" + (maxMem) + ",freeMem=" + (freeMem) + ",usedMem="
						+ (totalMem) + ",totalMem=" + (totalMem));
			}
			List valueList = new ArrayList<>();
			// 遍历每一列
			for (int colI = 1; colI <= columnCount; colI++) {
				String columnName = rsd.getColumnLabel(colI);

				String value = result.getString(columnName);

				if (rsd.getColumnType(colI) == 93) {// 93为时间类型 DATE:93 is code of date(DATE)
					if (value == null) {
						valueList.add(colI - 1, "");
					} else {
						valueList.add(colI - 1, result.getDate(columnName));
					}
				} else if (rsd.getColumnType(colI) == 12) {// 12为字符串类型 VARCHAR2()
					if (value == null) {
						valueList.add(colI - 1, "");
					} else {
						valueList.add(colI - 1, result.getString(columnName));
					}
				} else if (rsd.getColumnType(colI) == -9) {// -9为字符串类型 NVARCHAR2()
					if (value == null) {
						valueList.add(colI - 1, "");
					} else {
						valueList.add(colI - 1, result.getString(columnName));
					}
				} else if (rsd.getColumnType(colI) == 2) {// 2为双精度类型 NUMBER
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

			// sheet 瀵瑰簲涓?涓伐浣滈〉
			Sheet sheet = workBook.getSheetAt(0);
			// 鍒涘缓棰勭紪璇戣鍙ュ璞★紝涓?鑸兘鏄敤杩欎釜鑰屼笉鐢⊿tatement
			PreparedStatement pre = null;
			// 鍒涘缓涓?涓粨鏋滈泦瀵硅薄
			ResultSet result = null;
			String sql = "select * from PMS_QUEXIAN";// 棰勭紪璇戣鍙?
			try {
				pre = conn.prepareStatement(sql);
				result = pre.executeQuery();// 鎵ц鏌ヨ锛屾敞鎰忔嫭鍙蜂腑涓嶉渶瑕佸啀鍔犲弬鏁?
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 瀹炰緥鍖栭缂栬瘧璇彞
				// 鏌ヨ鏁版嵁搴撲腑鎵?鏈夌殑鏁版嵁
			List<PmsQuexian> list = PmsQuexianService.getAllByDb();
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				/*
				 * if(i==2000) { break; }
				 */
				// 鍒涘缓涓?琛岋細浠庣浜岃寮?濮嬶紝璺宠繃灞炴?у垪
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
		System.out.println("导出完毕");

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

			// sheet 瀵瑰簲涓?涓伐浣滈〉
			Sheet sheet = workBook.getSheetAt(0);
			// 鍒涘缓棰勭紪璇戣鍙ュ璞★紝涓?鑸兘鏄敤杩欎釜鑰屼笉鐢⊿tatement
			PreparedStatement pre = null;
			// 鍒涘缓涓?涓粨鏋滈泦瀵硅薄
			ResultSet result = null;
			String sql = "select * from PMS_QUEXIAN";// 棰勭紪璇戣鍙?
			try {
				pre = conn.prepareStatement(sql);
				result = pre.executeQuery();// 鎵ц鏌ヨ锛屾敞鎰忔嫭鍙蜂腑涓嶉渶瑕佸啀鍔犲弬鏁?
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 瀹炰緥鍖栭缂栬瘧璇彞
				// 鏌ヨ鏁版嵁搴撲腑鎵?鏈夌殑鏁版嵁
			List<PmsQuexian> list = PmsQuexianService.getAllByDb();
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				/*
				 * if(i==2000) { break; }
				 */
				// 鍒涘缓涓?琛岋細浠庣浜岃寮?濮嬶紝璺宠繃灞炴?у垪
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
		System.out.println("导出完毕");

	}

	/**
	 * 鍒ゆ柇Excel鐨勭増鏈?,鑾峰彇Workbook
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
